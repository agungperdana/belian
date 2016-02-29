/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;
import com.kratonsolution.belian.general.dm.PersonRole;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.dm.PatientRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PatientService
{
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private PatientRepository repository;
	
	@Autowired
	private SessionUtils utils;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public int size()
	{
		if(utils.getOrganization() != null)
			return repository.count(utils.getOrganization().getId()).intValue();
		
		return 0;
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public Patient findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public Patient findOneByName(String name)
	{
		if(utils.getOrganization() == null)
			return null;
		
		return repository.findOneByFromNameAndToId(name,utils.getOrganization().getId());
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public List<Patient> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Patient>();
		
		return repository.findAll(utils.getOrganization().getId());
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public List<Patient> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Patient>();
		
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_PATIENT_CREATE")
	public void add(Patient patient)
	{
		personRepo.save(patient.getFrom());
		repository.save(patient);
	}
	
	@Secured("ROLE_PATIENT_UPDATE")
	public void edit(Patient patient)
	{
		personRepo.save(patient.getFrom());
		repository.saveAndFlush(patient);
	}
	
	@Secured("ROLE_PATIENT_DELETE")
	public void delete(String id)
	{
		Person person = repository.findPerson(id);
		if(person != null)
		{
			Iterator<PersonRole> iterator = person.getRoles().iterator();
			while (iterator.hasNext())
			{
				PersonRole personRole = (PersonRole) iterator.next();
				if(personRole.getId().equals(id))
					iterator.remove();
			}
			
			personRepo.save(person);
		}
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public Patient findOneByBPJS(String number)
	{
		return repository.findOneByBpjsCard(number);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public List<Patient> findAll(String nameOrIdentity)
	{
		if(Strings.isNullOrEmpty(nameOrIdentity))
			return findAll();
		else
			return repository.findAll(nameOrIdentity, utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public Patient findOne(String person,String company)
	{
		if(utils.getOrganizations() == null)
			throw new RuntimeException("Default organization does not exist,please provide it first.");
		
		return repository.findOne(person,utils.getOrganization().getId());
	}
}
