package com.kratonsolution.belian.healtcares.svc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.AbstractService;
import com.kratonsolution.belian.healtcares.dm.Patient;
import com.kratonsolution.belian.healtcares.dm.PatientProviderRelationship;
import com.kratonsolution.belian.healtcares.dm.PatientProviderRelationshipRepository;
import com.kratonsolution.belian.core.party.impl.orm.Gender;
import com.kratonsolution.belian.core.party.impl.orm.PartyRelationship;
import com.kratonsolution.belian.core.party.impl.orm.PartyRole;
import com.kratonsolution.belian.core.party.impl.repository.PartyRoleRepository;
import com.kratonsolution.belian.core.party.impl.orm.Person;
import com.kratonsolution.belian.core.party.impl.application.PersonService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class PatientProviderRelationshipService extends AbstractService
{
	private PersonService personService;
	
	private PatientProviderRelationshipRepository repository;
	
	private PartyRoleRepository roleRepo;
	
	@Secured("ROLE_PATIENT_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;

		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	/**
	 * @param code
	 * @param name
	 * Both param cannot be empty
	 */
	public boolean isExist(String code,String name)
	{
		if(Strings.isNullOrEmpty(code) || Strings.isNullOrEmpty(name))
			throw new RuntimeException("both field cannot be empty");
	
		if(utils.getOrganization() == null)
			return false;
		
		List<PatientProviderRelationship> list = repository.findAll(utils.getOrganization().getId(), code, name);
		return !list.isEmpty();
	}

	@Secured("ROLE_PATIENT_READ")
	public int size(String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganization().getId()).intValue();
	}

	@Secured("ROLE_PATIENT_READ")
	public PatientProviderRelationship findById(String id)
	{
		return repository.findById(id).orElse(null);
	}

	@Secured("ROLE_PATIENT_READ")
	public List<PatientProviderRelationship> findAll()
	{
		return repository.findAll();
	}

	@Secured("ROLE_PATIENT_READ")
	public List<PatientProviderRelationship> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId());
	}

	@Secured("ROLE_PATIENT_READ")
	public List<PatientProviderRelationship> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();

		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId(),key);
	}

	@Secured("ROLE_PATIENT_CREATE")
	public void add(PatientProviderRelationship patient)
	{
		repository.save(patient);
	}
	
	@Secured("ROLE_PATIENT_CREATE")
	public void add(Date start,String code,String name,Date birthDate,Gender gender)
	{
		/**
		 * Check if person with code & name exist,if not crate one
		 */
		if(!personService.isExist(code, name))
		{
			Person person = new Person();
			person.setCode(code);
			person.setName(name);
			person.setBirthDate(birthDate);
			person.setGender(gender);
			
			personService.add(person);
		}
		
		/**
		 * load person data from db
		 */
		Person person = personService.findById(code,name,birthDate,gender);
		if(person != null)
		{
			/**
			 * Check if this person already has patient as role else add it
			 */
			Patient patient = null;

			Iterator<PartyRole> iRole = person.getPartyRoles().iterator();
			while (iRole.hasNext())
			{
				PartyRole role = (PartyRole) iRole.next();
				if(role instanceof Patient)
				{
					patient = (Patient)role;
					break;
				}
			}
			
			/**
			 * in case role does not exist,create it
			 */
			if(patient == null)
			{
				patient = new Patient();
				patient.setStart(start);
				patient.setParty(person);
				
				person.getPartyRoles().add(patient);

				personService.edit(person);
			}
			
			/**
			 * check if realtionship already exist,else add it
			 */
			PatientProviderRelationship relationship = null;
			Iterator<PartyRelationship> iRelation = person.getRelationships().iterator();
			while (iRelation.hasNext())
			{
				PartyRelationship related = (PartyRelationship) iRelation.next();
				if(related instanceof PatientProviderRelationship && related.getToParty().getId().equals(utils.getOrganization().getId()))
				{
					relationship = (PatientProviderRelationship)related;
					break;
				}
			}
			
			/**
			 * in case realtionship does not exist,create it
			 */
			if(relationship == null)
			{
				relationship = new PatientProviderRelationship();
				relationship.setStart(start);
				relationship.setFromParty(person);
				relationship.setFromRole(roleRepo.findById(patient.getId()).orElse(null));
//				relationship.setToParty(utils.getOrganization());
			
				person.getRelationships().add(relationship);

				personService.edit(person);
			}
		}
	}

	@Secured("ROLE_PATIENT_UPDATE")
	public void edit(PatientProviderRelationship patient)
	{
		Person person = personService.findById(patient.getFromParty().getCode());
		if(person != null)
		{
			person.setCode(patient.getFromParty().getCode());
			person.setName(patient.getFromParty().getName());
			person.setBirthDate(patient.getFromParty().getBirthDate());
			person.setGender(((Person)patient.getFromParty()).getGender());
			
			Iterator<PartyRelationship> iterator = person.getRelationships().iterator();
			while (iterator.hasNext())
			{
				PartyRelationship prac = (PartyRelationship) iterator.next();
				if(prac.getId().equals(patient.getId()))
				{
					prac.setStart(patient.getStart());
					prac.setEnd(patient.getEnd());
					break;
				}
			}
			
			personService.edit(person);
		}
	}
	
	@Secured("ROLE_PATIENT_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
	
	@Secured("ROLE_PATIENT_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
}
