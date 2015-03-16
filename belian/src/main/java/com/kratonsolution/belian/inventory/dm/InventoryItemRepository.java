/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface InventoryItemRepository extends JpaRepository<InventoryItem, String>
{
	public List<InventoryItem> findAllByFacilityId(String facilityId);
}
