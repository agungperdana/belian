
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
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
	@Query("FROM InventoryItem item WHERE "
			+ "item.product.value LIKE :key "
			+ "OR item.facility.value LIKE :key "
			+ "OR item.container.value LIKE :key "
			+ "ORDER BY item.product ASC ")
	public List<InventoryItem> findAll(Pageable pageable,@Param("key")String key);
	
	@Query("SELECT COUNT(item) FROM InventoryItem item WHERE "
			+ "item.product.value LIKE :key "
			+ "OR item.facility.value LIKE :key "
			+ "OR item.container.value LIKE :key ")
	public Long count(@Param("key")String key);
	
	@Query("FROM InventoryItem item WHERE "
			+ "item.product.id =:product "
			+ "AND item.facility.id =:facility "
			+ "ORDER BY item.expiredDate ASC")
	public List<InventoryItem> findAll(@Param("product")String product,@Param("facility")String facility);
	
	@Query("FROM InventoryItem item WHERE "
			+ "item.product.id =:product "
			+ "AND item.facility.id =:facility "
			+ "AND item.expiredDate IS NULL")
	public InventoryItem getOne(@Param("product")String product,@Param("facility")String facility);
	
	@Query("FROM InventoryItem item WHERE "
			+ "item.product.id =:product "
			+ "AND item.facility.id =:facility "
			+ "AND item.container.id =:container "
			+ "AND item.expiredDate =:expiredDate ")
	public InventoryItem getOne(@Param("product")String product,
								 @Param("facility")String facility,
								 @Param("container")String container,
								 @Param("expiredDate")Date expiredDate);
	
	@Query("FROM InventoryItem item WHERE "
			+ "item.product.id =:product "
			+ "AND item.facility.id =:facility "
			+ "AND item.container.id =:container ")
	public InventoryItem getOne(@Param("product")String product,
								 @Param("facility")String facility,
								 @Param("container")String container);
	
	@Query("FROM InventoryItem item WHERE "
			+ "item.product.id =:product "
			+ "AND item.facility.id =:facility "
			+ "AND item.expiredDate =:expired")
	public InventoryItem getOne(@Param("product")String product,@Param("facility")String facility,@Param("expired")Date expired);
	
	@Query("FROM InventoryItem item WHERE "
			+ "item.facility.id IN(:warehouse) "
			+ "AND item.onhand > 0 "
			+ "AND item.expiredDate <=:expired")
	public List<InventoryItem> findAllExpired(@Param("warehouse")List<String> facilitys,@Param("expired")Date date);

	@Query("SELECT SUM(itm.onhand) FROM InventoryItem itm WHERE "
			+ "itm.facility.id IN(:warehouse) "
			+ "AND itm.product.id =:product ")
	public BigDecimal onHand(@Param("product")String product,@Param("warehouse")List<String> warehouse);
	
	@Query("FROM InventoryItem inv WHERE "
			+ "inv.facility.id =:facility "
			+ "AND inv.product.id =:product "
			+ "AND inv.onhand > 0 "
			+ "ORDER BY inv.expiredDate ASC ")
	public List<InventoryItem> allByFacilityAndProduct(@Param("facility")String facility,@Param("product")String product);
}
