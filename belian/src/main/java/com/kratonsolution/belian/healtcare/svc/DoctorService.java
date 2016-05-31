/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.ArrayList;
import java.util.Collection;
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
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.dm.DoctorRelationship;
import com.kratonsolution.belian.healtcare.dm.DoctorRelationshipRepository;
import com.kratonsolution.belian.healtcare.dm.DoctorRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DoctorService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private DoctorRepository repository;
	
	@Autowired
	private InternalOrganizationRepository internalRepository;
	
	@Autowired
	private DoctorRelationshipRepository doctorRepo;
	
	@Autowired
	private PersonService personService;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return doctorRepo.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_DOCTOR_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Doctor findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public Doctor findOneByName(String name)
	{
		if(utils.getOrganization() == null)
			return null;
		
		return repository.findOne(name,utils.getOrganization().getId());
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<Doctor> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Doctor>();

		return repository.findAll(utils.getOrganization().getId());
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<Doctor> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Doctor>();

		return doctorRepo.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_DOCTOR_CREATE")
	public void add(Doctor type)
	{
		repository.save(type);
	}
	
	@Secured("ROLE_DOCTOR_CREATE")
	public void add(DoctorRelationship relationship)
	{
		
		Doctor doctor = repository.findOne(relationship.getDoctor().getPerson().getId(),relationship.getDoctor().getStart());
		if(doctor == null)
			repository.save(relationship.getDoctor());
		else
			relationship.setDoctor(doctor);
		
		InternalOrganization organization = internalRepository.findOneByPartyId(utils.getOrganization().getId());
		if(organization == null)
		{
			relationship.getOrganization().setParty(utils.getOrganization());
			internalRepository.save(relationship.getOrganization());
		}
		else
			relationship.setOrganization(organization);
		
		doctorRepo.save(relationship);
	}
	
	@Secured("ROLE_DOCTOR_UPDATE")
	public void edit(Doctor doctor)
	{
		DoctorRelationship relationship = doctorRepo.findOne(doctor.getId(),utils.getOrganization().getId());
		if(relationship != null)
		{
			relationship.setEnd(doctor.getEnd());
			doctorRepo.save(relationship);
		}
	}
	
	@Secured("ROLE_DOCTOR_DELETE")
	public void delete(String id)
	{
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public Doctor findOne(String partyId,String companyId)
	{
		return repository.findOne(partyId, companyId);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<Doctor> findAllByCompanys(Collection<String> companys)
	{
		return new ArrayList<>();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<Doctor> findAllPartner(String id)
	{
		return new ArrayList<>();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_DOCTOR_READ","ROLE_SYSTEM_READ"})
	public List<Doctor> findAllByPerson(String id)
	{
		return repository.findAllByPerson(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<Doctor> findAll(String nameOrIdentity)
	{
		if(Strings.isNullOrEmpty(nameOrIdentity))
			return findAll();
		else
			return repository.findAll(nameOrIdentity, utils.getOrganization().getId());
	}
}
