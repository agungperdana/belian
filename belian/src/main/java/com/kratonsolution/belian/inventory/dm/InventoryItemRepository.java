/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface InventoryItemRepository extends MongoRepository<InventoryItem, String>
{

}
