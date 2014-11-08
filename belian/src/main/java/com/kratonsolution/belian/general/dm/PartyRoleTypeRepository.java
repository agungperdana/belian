/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface PartyRoleTypeRepository extends MongoRepository<PartyRoleType, String>
{
	public PartyRoleType findOneByName(String name);
}
