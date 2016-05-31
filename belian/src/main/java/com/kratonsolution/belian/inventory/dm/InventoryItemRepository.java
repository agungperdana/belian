/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.sql.Date;
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
	
	@Query("FROM InventoryItem item WHERE item.product.id =:product AND item.facility.id =:facility ORDER BY item.expiredDate ASC")
	public List<InventoryItem> findAll(@Param("product")String product,@Param("facility")String facility);
	
	@Query("FROM InventoryItem item WHERE item.product.id =:product AND item.facility.id =:facility AND item.expiredDate IS NULL")
	public InventoryItem findOne(@Param("product")String product,@Param("facility")String facility);
	
	@Query("FROM InventoryItem item WHERE item.product.id =:product AND item.facility.id =:facility AND item.expiredDate =:expired")
	public InventoryItem findOne(@Param("product")String product,@Param("facility")String facility,@Param("expired")Date expired);
}
