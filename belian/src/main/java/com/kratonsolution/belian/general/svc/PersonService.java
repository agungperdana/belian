/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.dm.PersonRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PersonService
{	
	@Autowired
	private PersonRepository repository;
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public Person findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PERSON_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PERSON_CREATE")
	public void add(Person person)
	{
		person.setId(UUID.randomUUID().toString());
		repository.save(person);
	}
	
	@Secured("ROLE_PERSON_UPDATE")
	public void edit(Person person)
	{
		repository.save(person);
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
//		return repository.findAllReviewer(forOrganization);
		return new ArrayList<Person>();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllByRolesType(String name)
	{
		return repository.findAllByRolesType(PartyRole.Type.valueOf(name));
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllProspect(String company)
	{
//		return repository.findAllProspect(company);
		return null;
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public List<Person> findAllByUserIsNull()
	{
		return repository.findAllWhereUserIsNull();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PERSON_READ")
	public Person anonymous()
	{
		return repository.findOneByName(Person.ANONYMOUS);
	}
}
