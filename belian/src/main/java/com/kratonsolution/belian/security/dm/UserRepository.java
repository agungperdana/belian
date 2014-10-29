/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface UserRepository extends MongoRepository<User, String>
{
	public User findOneByName(String name);
}
