/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface UnitOfMeasureRepository extends MongoRepository<UnitOfMeasure, String>
{
	public UnitOfMeasure findOneByName(String name);
}
