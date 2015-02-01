/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface PersonRepository extends MongoRepository<Person, String>
{
	public Person findOneByName(String name);
	
	public List<Person> findAllByRolesTypeName(String name);
	
	public List<Person> findAllByNameNot(String name);
}
