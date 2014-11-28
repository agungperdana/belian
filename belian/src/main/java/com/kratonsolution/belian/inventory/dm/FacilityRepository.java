/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface FacilityRepository extends MongoRepository<Facility, String>
{
	public Facility findOneByCode(String code);
	
	public Facility findOneByName(String name);
	
	public List<Facility> findAllByType(String type);
}
