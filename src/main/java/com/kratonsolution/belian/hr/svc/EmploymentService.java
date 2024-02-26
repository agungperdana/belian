/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.hr.dm.Employer;
import com.kratonsolution.belian.hr.dm.EmployerRepository;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.dm.EmploymentRepository;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyRelationship;
import com.kratonsolution.belian.partys.dm.PartyRelationshipStatusType;
import com.kratonsolution.belian.partys.dm.PartyRelationshipType;
import com.kratonsolution.belian.partys.dm.PartyRepository;
import com.kratonsolution.belian.partys.dm.PartyRoleType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EmploymentService extends AbstractService
{
	@Autowired
	private EmploymentRepository repository;
	
	@Autowired
	private EmployerRepository employerRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private PartyRepository partyRepo;

	@Secured("ROLE_EMPLOYMENT_READ")
	public Employment findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll()
	{
		return repository.findAll();
	}

	@Secured("ROLE_EMPLOYMENT_READ")
	public int getSize()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public int getSize(String key)
	{
		if(utils.getOrganization() == null)
			return 0;
		
		if(Strings.isNullOrEmpty(key))
			return getSize();
		
		return repository.count(utils.getOrganization().getId(),key).intValue();
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll(int pageIndex,int itemsSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();

		return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll(int pageIndex,int itemsSize,String key)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, itemsSize);

		return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganization().getId(),key);
	}

	@Secured("ROLE_EMPLOYMENT_CREATE")
	public void add(Date start,Date end,IDValueRef person,IDValueRef company)
	{
		/**
		 * check for existing employer role for (company)
		 */
		Employer employer = employerRepo.findEmployer(company.getId());
		if(employer == null)
		{
			employer = new Employer();
			employer.setStart(start);
			employer.setEnd(end);
			employer.setParty(partyRepo.findOne(company.getId()));
			employer.setType(PartyRoleType.EMPLOYER);
			employerRepo.save(employer);
		}
		
		/**
		 * check for existing employee role for (person)
		 */
		Employee employee = employeeRepo.findEmployee(person.getId());
		if(employee == null)
		{
			employee = new Employee();
			employee.setStart(start);
			employee.setEnd(end);
			employee.setParty(partyRepo.findOne(person.getId()));
			employee.setType(PartyRoleType.EMPLOYEE);
			
			employeeRepo.save(employee);
		}
		
		Party owner = partyRepo.findOne(person.getId());
		if(owner != null)
		{
			Iterator<PartyRelationship> iterator = owner.getRelationships().iterator();
			while (iterator.hasNext())
			{
				PartyRelationship on = (PartyRelationship) iterator.next();
				if(on instanceof Employment && 
				   on.getFromParty().getId().equals(person.getId()) && 
				   on.getToParty().getId().equals(company.getId()) && 
				   on.getFromRole().getId().equals(employee.getId()) &&
				   on.getToRole().getId().equals(employer.getId()))
					return;
			}
			
			//relationship doestnot exist
			Employment employment = new Employment();
			employment.setStart(start);
			employment.setEnd(end);
			employment.setFromParty(owner);
			employment.setToParty(partyRepo.findOne(company.getId()));
			employment.setFromRole(employee);
			employment.setToRole(employer);
			employment.setStatus(PartyRelationshipStatusType.ACTIVE);
			employment.setType(PartyRelationshipType.EMPLOYMENT_RELATIONSHIP);
			
			owner.getRelationships().add(employment);
			
			partyRepo.saveAndFlush(owner);
		}
	}

	@Secured("ROLE_EMPLOYMENT_UPDATE")
	public void edit(Employment employment)
	{
		repository.saveAndFlush(employment);
	}

	@Secured("ROLE_EMPLOYMENT_DELETE")
	public void delete(String id)
	{
		if(!Strings.isNullOrEmpty(id))
		{
			Employment emp = repository.findOne(id);
			if(emp != null)
			{
				Iterator<PartyRelationship> frm = emp.getFromParty().getRelationships().iterator();
				while (frm.hasNext())
				{
					PartyRelationship rel = (PartyRelationship) frm.next();
					if(rel.getId().equals(id))
						frm.remove();
				}
				
				Iterator<PartyRelationship> tom = emp.getToParty().getRelationships().iterator();
				while (tom.hasNext())
				{
					PartyRelationship rel = (PartyRelationship) tom.next();
					if(rel.getId().equals(id))
						tom.remove();
				}
				
				partyRepo.saveAndFlush(emp.getFromParty());
				partyRepo.saveAndFlush(emp.getToParty());
			}
		}
	}
	
	private boolean isNotExist(Employment employment)
	{
		return repository.findAll(employment.getFromParty().getId(), employment.getToParty().getId()).isEmpty();
	}
	
	private Employer createEmployer(Party party)
	{
		List<Employer> list = employerRepo.findAllByPartyIdAndType(party.getId(), PartyRoleType.EMPLOYER);
		
		if(!list.isEmpty())
			return list.get(0);
		
		return new Employer();
	}
	
	private Employee createEmployee(Party party)
	{
		return new Employee();
	}
}
