/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.InternalOrganizationRepository;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.dm.PatientRelationship;
import com.kratonsolution.belian.healtcare.dm.PatientRelationshipRepository;
import com.kratonsolution.belian.healtcare.dm.PatientRepository;
import com.kratonsolution.belian.partys.dm.PersonRepository;

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
	private InternalOrganizationRepository internalRepo;

	@Autowired
	private PatientRelationshipRepository relRepo;
	
	@Autowired
	private SessionUtils utils;

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public int size()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		return relRepo.count(utils.getOrganizationIds()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public int size(String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return relRepo.count(utils.getOrganizationIds(), key).intValue();
		else
			return size();
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
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public List<Patient> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();

		return repository.findAll(utils.getOrganization().getId());
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public List<PatientRelationship> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		return relRepo.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public List<PatientRelationship> findAll(int pageIndex,int pageSize,String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return relRepo.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds(),key);
		else
			return findAll(pageIndex, pageSize);
	}

	@Secured("ROLE_PATIENT_CREATE")
	public void add(Patient patient)
	{
		repository.save(patient);
	}
	
	@Secured("ROLE_PATIENT_CREATE")
	public void add(PatientRelationship relationship)
	{
		Patient patient = repository.findOne(relationship.getPatient().getParty().getId());
		if(patient == null)
			repository.save(relationship.getPatient());
		else
			relationship.setPatient(patient);
		
		InternalOrganization organization = internalRepo.findOneByPartyId(relationship.getOrganization().getParty().getId());
		if(organization == null)
			internalRepo.save(relationship.getOrganization());
		else
			relationship.setOrganization(organization);
		
		relRepo.save(relationship);
	}

	@Secured("ROLE_PATIENT_UPDATE")
	public void edit(PatientRelationship relationship)
	{
		relRepo.save(relationship);
	}

	@Secured("ROLE_PATIENT_DELETE")
	public void delete(String id)
	{
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
			return repository.findAll(nameOrIdentity,utils.getOrganization().getId());
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public Patient findOne(String person,String company)
	{
		if(utils.getOrganizations() == null)
			throw new RuntimeException("Default organization does not exist,please provide it first.");

		return repository.findOne(person,utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PATIENT_READ")
	public PatientRelationship findRelationshi(String id)
	{
		if(utils.getOrganizations() == null)
			throw new RuntimeException("Default organization does not exist,please provide it first.");

		return relRepo.findOne(id);
	}
}
