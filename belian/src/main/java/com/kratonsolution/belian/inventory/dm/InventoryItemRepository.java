/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface InventoryItemRepository extends JpaRepository<InventoryItem, String>
{
	public List<InventoryItem> findAllByFacilityId(String facilityId);
	
	@Query("FROM InventoryItem item WHERE item.product.id =:product AND item.facility.id =:facility ")
	public InventoryItem findOne(@Param("product")String product,@Param("facility")String facility);
}
