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

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.InternalOrganizationRepository;
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
public class DoctorRelationshipService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private DoctorRelationshipRepository repository;
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private InternalOrganizationRepository internalRepository;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_DOCTOR_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public DoctorRelationship findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public DoctorRelationship findOneByName(String name)
	{
		if(utils.getOrganization() == null)
			return null;
		
		return repository.findOne(name,utils.getOrganization().getId());
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<DoctorRelationship> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<DoctorRelationship>();

		return repository.findAll();
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<DoctorRelationship> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<DoctorRelationship>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_DOCTOR_CREATE")
	public void add(DoctorRelationship relationship)
	{
		Doctor doctor = doctorRepo.findOne(relationship.getDoctor().getParty().getId(), relationship.getStart());
		if(doctor != null)
			relationship.setDoctor(doctor);
		else
			doctorRepo.save(relationship.getDoctor());
		
		InternalOrganization organization = internalRepository.findOne(relationship.getOrganization().getParty().getId(),relationship.getStart());
		if(organization != null)
			relationship.setOrganization(organization);
		else
			internalRepository.save(relationship.getOrganization());
		
		repository.save(relationship);
	}
	
	@Secured("ROLE_DOCTOR_UPDATE")
	public void edit(DoctorRelationship relationship)
	{
		repository.save(relationship);
	}
	
	@Secured("ROLE_DOCTOR_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public DoctorRelationship findOne(String partyId,String companyId)
	{
		return repository.findOne(partyId, companyId);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<DoctorRelationship> findAllByCompanys(Collection<String> companys)
	{
		return new ArrayList<>();
	}
}
