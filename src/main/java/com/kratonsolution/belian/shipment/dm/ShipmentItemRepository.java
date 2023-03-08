/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ShipmentItemRepository extends JpaRepository<ShipmentItem, String>
{	
	@Query("SELECT DISTINCT item FROM ShipmentItem item INNER JOIN item.shipment.statuses status WHERE "
			+ "status.type NOT IN('DELIVERED','CANCELED') "
			+ "AND item.shipment.type IN('PURCHASE_SHIPMENT','CUSTOMER_RETUR') "
			+ "AND item.shipment.shipToParty.id =:company "
			+ "AND item.shipment.shipFromParty.id =:supplier "
			+ "ORDER BY item.shipment.entryDate ASC, "
			+ "item.shipment.shipFromParty.value ASC, "
			+ "item.product.value ASC")
	public List<ShipmentItem> findAllReceiptable(@Param("company")String company,@Param("supplier")String supplier);
	
	@Query("SELECT DISTINCT item FROM ShipmentItem item INNER JOIN item.shipment.statuses status WHERE "
			+ "status.type NOT IN('DELIVERED','CANCELED') "
			+ "AND item.shipment.type IN('CUSTOMER_SHIPMENT','PURCHASE_RETUR_SHIPMENT') "
			+ "AND item.shipment.shipFromParty.id =:company "
			+ "AND item.shipment.shipToParty.id =:customer "
			+ "ORDER BY item.shipment.entryDate ASC, "
			+ "item.shipment.shipFromParty.value ASC, "
			+ "item.product.value ASC")
	public List<ShipmentItem> findAllIssuable(@Param("company")String company,@Param("customer")String customer);
}
