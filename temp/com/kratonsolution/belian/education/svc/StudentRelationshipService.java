/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.education.dm.Student;
import com.kratonsolution.belian.education.dm.StudentRelationship;
import com.kratonsolution.belian.education.dm.StudentRelationshipRepository;
import com.kratonsolution.belian.education.dm.StudentRepository;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.InternalOrganizationRepository;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.partys.dm.PartyRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StudentRelationshipService
{
	@Autowired
	private StudentRelationshipRepository repository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private InternalOrganizationRepository orgRepo;
	
	@Autowired
	private PartyRepository partyRepo;
	
	@Autowired
	private CodeGenerator generator;
	
	@Autowired
	private SessionUtils utils;
		
	@Secured({"ROLE_STUDENT_READ","ROLE_SYSTEM_READ"})
	public StudentRelationship findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_STUDENT_READ","ROLE_SYSTEM_READ"})
	public List<StudentRelationship> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_STUDENT_READ","ROLE_SYSTEM_READ"})
	public List<StudentRelationship> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, pageSize), utils.getOrganizationIds());
	}
	
	@Secured({"ROLE_STUDENT_READ","ROLE_SYSTEM_READ"})
	public List<StudentRelationship> findAll(int pageIndex,int pageSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);
		
		return repository.findAll(new PageRequest(pageIndex, pageSize), utils.getOrganizationIds(),key);
	}
	
	@Secured({"ROLE_STUDENT_READ","ROLE_SYSTEM_READ"})
	public List<StudentRelationship> findAll(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll();
		
		return repository.findAll(utils.getOrganizationIds(),key);
	}
	
	@Secured({"ROLE_STUDENT_READ"})
	public int getSize()
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.count(utils.getOrganizationIds()).intValue();

		return 0;
	}
	
	@Secured({"ROLE_STUDENT_READ"})
	public int getSize(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return getSize();
		
		return repository.count(utils.getOrganizationIds(), key).intValue();
	}
	
	@Secured("ROLE_STUDENT_CREATE")
	public void add(StudentRelationship relation)
	{
		StudentRelationship out = repository.findOne(relation.getStudent().getParty().getId(), relation.getOrganization().getParty().getId());
		if(out == null)
		{
			Student student = studentRepository.findOneByPartyId(relation.getStudent().getParty().getId());
			if(student == null)
				studentRepository.save(relation.getStudent());
			else
				relation.setStudent(student);
			
			InternalOrganization organization = orgRepo.findOneByPartyId(relation.getOrganization().getParty().getId());
			if(organization == null)
				orgRepo.save(relation.getOrganization());
			else
				relation.setOrganization(organization);
			
			repository.save(relation);
			
			relation.getStudent().getParty().setIdentity(generator.studentID(relation.getOrganization().getParty().getId()));
			partyRepo.save(relation.getStudent().getParty());
		}
	}
	
	@Secured("ROLE_STUDENT_UPDATE")
	public void edit(StudentRelationship relation)
	{
		Student student = studentRepository.findOne(relation.getStudent().getId());
		if(student != null)
		{
			student.setEnd(relation.getStudent().getEnd());
			student.setParentName(relation.getStudent().getParentName());
			student.setSchoolName(relation.getStudent().getSchoolName());
			student.setSource(relation.getStudent().getSource());
			
			studentRepository.save(student);
		}
		
		repository.saveAndFlush(relation);
	}
	
	@Secured("ROLE_STUDENT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
