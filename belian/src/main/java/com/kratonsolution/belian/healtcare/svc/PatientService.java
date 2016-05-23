/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

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
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;
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
		return (int)repository.count();
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public Patient findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public Patient findPerson(String id)
	{
		return repository.findOneByFromId(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public List<Patient> findAll()
	{
		return repository.findAll();
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public List<Patient> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
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
			Iterator<PartyRole> iterator = person.getPartyRoles().iterator();
			while (iterator.hasNext())
			{
				PartyRole role = (PartyRole) iterator.next();
				if(role.getId().equals(id))
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
			return repository.findAllWith(nameOrIdentity);
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
