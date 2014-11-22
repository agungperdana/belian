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
public interface OrganizationRepository extends MongoRepository<Organization, String>
{
	public List<Organization> findAllByRolesName(String roleName);
}
