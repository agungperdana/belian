/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface RoleRepository extends MongoRepository<Role,String>
{
	public Role findOneByCode(String code);
	
	public Role findOneByName(String name);
}
