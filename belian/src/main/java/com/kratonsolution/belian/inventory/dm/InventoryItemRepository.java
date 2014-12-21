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
public interface InventoryItemRepository extends MongoRepository<InventoryItem, String>
{
	public List<InventoryItem> findAllByFacilityId(String facilityId);
}
