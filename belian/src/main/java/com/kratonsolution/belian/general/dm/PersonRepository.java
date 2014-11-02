/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface PersonRepository extends MongoRepository<Person, String>
{
	public Person findOneByName(String name);
}
