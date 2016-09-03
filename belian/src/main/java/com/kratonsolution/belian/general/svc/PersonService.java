/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PersonService
{	
	@Autowired
	private PersonRepository repository;

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public Person findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public Person findOneByName(String name)
	{
		return repository.findOneByName(name);
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
		if(Strings.isNullOrEmpty(key))
			return repository.findAll();
		
		return repository.findAll(key);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public List<Person> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public List<Person> findAll(int pageIndex,int pageSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
		else
			return repository.findAll(new PageRequest(pageIndex, pageSize), key);
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
	public void delete(String id)
	{
		repository.delete(id);
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
		return repository.findOneByName(Person.ANONYMOUS);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public Person findOneByIdentity(String identity)
	{
		return repository.findOneByIdentity(identity);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllByIdentity(String identity)
	{
		return repository.findAllByIdentity(identity);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllByName(String name)
	{
		return repository.findAllByName(name);
	}
}
