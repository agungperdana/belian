package com.kratonsolution.belian.core.party.impl.application;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.AbstractService;
import com.kratonsolution.belian.core.party.impl.orm.Gender;
import com.kratonsolution.belian.core.party.impl.orm.Person;
import com.kratonsolution.belian.core.party.impl.repository.PersonRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class PersonService extends AbstractService
{	
	private PersonRepository repository;

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public Person findById(String id)
	{
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public Person findByName(String name)
	{
		return repository.findByName(name);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public boolean isExist(String code,String name)
	{
		if(Strings.isNullOrEmpty(code) || Strings.isNullOrEmpty(name))
			throw new RuntimeException(lang.get("message.field.param"));
		
		return !repository.findAll(code, name).isEmpty();
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public List<Person> findAll()
	{
		return repository.findAll();
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public List<Person> findAll(String key)
	{
		return repository.findAll();
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public List<Person> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize,Direction.ASC,"name")).getContent();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public List<Person> findAll(int pageIndex,int pageSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);
		else
			return repository.findAll(PageRequest.of(pageIndex, pageSize), key);
	}

	@Secured("ROLE_PERSON_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PERSON_READ")
	public int size(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return size();
		else
			return repository.count(key).intValue();
	}

	@Secured({"ROLE_PERSON_CREATE","ROLE_DOCTOR_CREATE"})
	public void add(Person person)
	{
		repository.save(person);
	}

	@Secured("ROLE_PERSON_UPDATE")
	public void edit(Person person)
	{
		repository.saveAndFlush(person);
	}

	@Secured("ROLE_PERSON_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
	
	@Secured("ROLE_PERSON_DELETE")
	public void delete(String id)
	{
		Person person = findById(id);
		if(person != null && !person.isSystem())
			repository.delete(person);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllBudgetReviewer(String forOrganization)
	{
		return new ArrayList<Person>();
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllByRolesType(String name)
	{
		return new ArrayList<Person>();
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllProspect(String company)
	{
		return null;
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllByUserIsNull()
	{
		return new ArrayList<>();
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public Person anonymous()
	{
		return repository.findByName(Person.ANONYMOUS);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public Person findByIdByIdentity(String identity)
	{
		return repository.findByCode(identity);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllByIdentity(String identity)
	{
		return repository.findAllByCode(identity);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllByName(String name)
	{
		return repository.findAllByName(name);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public Person findById(String code,String name,Date birthdate,Gender gender)
	{
		return repository.findById(code, name, birthdate, gender);
	}
}
