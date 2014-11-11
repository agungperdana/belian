/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ModuleRepository extends MongoRepository<Module, String>
{
	public Module findOneByName(String name);
}
