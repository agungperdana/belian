/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.ArrayList;
import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.InternalOrganizationRepository;
import com.kratonsolution.belian.global.dm.UserSetting;
import com.kratonsolution.belian.hr.dm.Employee;
import com.kratonsolution.belian.hr.dm.EmployeeRepository;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.dm.EmploymentRepository;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRole;
import com.kratonsolution.belian.security.svc.RoleService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EmploymentService
{
	@Autowired
	private EmploymentRepository repository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private InternalOrganizationRepository intOrgRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SessionUtils utils;
		
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
	public List<Employment> byCompany()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(utils.getOrganization().getId());
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public int getSize()
	{
		if(utils.isSysAdmin())
			return (int)repository.count();
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_EMPLOYMENT_CREATE")
	public void add(Employment employment)
	{
		Employee employee = employeeRepository.findOneByPartyId(employment.getEmployee().getParty().getId());
		if(employee != null)
			employment.setEmployee(employee);
		else
		{
			User user = new User();
			user.setDeleteable(false);
			user.setEnabled(true);
			user.setEmail(employment.getEmployee().getParty().getName());
			user.setPassword(new StrongPasswordEncryptor().encryptPassword(employment.getEmployee().getParty().getName()));

			UserSetting setting = new UserSetting();
			setting.setOrganizationId(employment.getInternalOrganization().getParty().getId());
			setting.setOrganizationName(employment.getInternalOrganization().getParty().getName());
			setting.setLanguage("in_ID");
			
			user.setSetting(setting);
			
			employment.getEmployee().setStart(employment.getStart());
			employment.getEmployee().setEnd(employment.getEnd());
			employment.getEmployee().setUser(user);
			
			
			for(Role role:roleService.findAll())
			{
				UserRole userRole = new UserRole();
				userRole.setEnabled(role.isMandatory());
				userRole.setRole(role);
				userRole.setUser(user);
				
				user.getRoles().add(userRole);
			}
			
			employeeRepository.save(employment.getEmployee());
		}
		
		InternalOrganization organization = intOrgRepository.findOneByPartyId(employment.getInternalOrganization().getParty().getId());
		if(organization != null)
			employment.setInternalOrganization(organization);
		else
		{
			employment.getInternalOrganization().setStart(employment.getStart());
			employment.getInternalOrganization().setEnd(employment.getEnd());
			
			intOrgRepository.save(employment.getInternalOrganization());
		}
		
		repository.save(employment);
	}
	
	@Secured("ROLE_EMPLOYMENT_UPDATE")
	public void edit(Employment employment)
	{
		repository.saveAndFlush(employment);
	}
	
	@Secured("ROLE_EMPLOYMENT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll(int pageIndex,int itemsSize)
	{
		if(utils.isSysAdmin())
			return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
		
		if(utils.getOrganization() != null)
			return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganization().getId());
		else
			return new ArrayList<>();
	}
}
