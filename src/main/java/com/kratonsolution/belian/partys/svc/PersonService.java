
package com.kratonsolution.belian.partys.svc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.partys.dm.Gender;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.partys.dm.PersonRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PersonService extends AbstractService
{	
	@Autowired
	private PersonRepository repository;

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public Person getOne(String id)
	{
		return repository.getOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PERSON_READ","ROLE_SYSTEM_READ"})
	public Person getOneByName(String name)
	{
		return repository.getOneByName(name);
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
		Person person = getOne(id);
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
		return repository.getOneByName(Person.ANONYMOUS);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public Person getOneByIdentity(String identity)
	{
		return repository.getOneByCode(identity);
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
	public Person getOne(String code,String name,Date birthdate,Gender gender)
	{
		return repository.getOne(code, name, birthdate, gender);
	}
}
