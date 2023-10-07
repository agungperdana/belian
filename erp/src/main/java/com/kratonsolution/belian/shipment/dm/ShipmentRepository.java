
package com.kratonsolution.belian.shipment.dm;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ShipmentRepository extends JpaRepository<Shipment, String>
{
	@Query("FROM Shipment shipment WHERE "
			+ "(shipment.shipFromParty.id =:companys "
			+ "AND (shipment.type = 'CUSTOMER_SHIPMENT' OR shipment.type = 'PURCHASE_RETUR_SHIPMENT')) "
			+ "OR (shipment.shipToParty.id =:companys "
			+ "AND (shipment.type = 'PURCHASE_SHIPMENT' OR shipment.type = 'CUSTOMER_RETUR')) "
			+ "ORDER BY shipment.number ASC")
	public List<Shipment> findAll(Pageable pageable,@Param("companys")String companys);
	
	@Query("FROM Shipment shipment WHERE "
			+ "(shipment.shipFromParty.id =:companys "
			+ "AND (shipment.type = 'CUSTOMER_SHIPMENT' "
			+ "OR shipment.type = 'PURCHASE_RETUR_SHIPMENT')) ")
	public List<Shipment> findAllIssuable(@Param("companys")String companys);
	
	@Query("FROM Shipment shipment WHERE "
			+ "shipment.shipFromParty.id =:supplier "
			+ "AND (shipment.type = 'PURCHASE_SHIPMENT' OR shipment.type = 'CUSTOMER_RETUR') "
			+ "AND shipment.shipToParty.id =:company "
			+ "ORDER BY shipment.entryDate ASC ")
	public List<Shipment> findAllReceiptable(@Param("company")String company,@Param("supplier")String supplier);
	
	@Query("SELECT COUNT(shipment) FROM Shipment shipment WHERE "
			+ "(shipment.shipFromParty.id =:companys "
			+ "AND (shipment.type = 'CUSTOMER_SHIPMENT' OR shipment.type = 'PURCHASE_RETUR_SHIPMENT')) "
			+ "OR (shipment.shipToParty.id =:companys "
			+ "AND (shipment.type = 'PURCHASE_SHIPMENT' OR shipment.type = 'CUSTOMER_RETUR')) ")
	public List<Shipment> findAll(@Param("companys")String companys);
	
	@Query("FROM Shipment shipment WHERE "
			+ "(shipment.shipFromParty.id =:companys "
			+ "AND (shipment.type = 'CUSTOMER_SHIPMENT' OR shipment.type = 'PURCHASE_RETUR_SHIPMENT')) "
			+ "OR (shipment.shipToParty.id =:companys "
			+ "AND (shipment.type = 'PURCHASE_SHIPMENT' OR shipment.type = 'CUSTOMER_RETUR')) "
			+ "AND shipment.number like :key "
			+ "AND shipment.shipToParty.value like :key "
			+ "AND shipment.shipFromParty.value like :key "
			+ "ORDER BY shipment.number ASC")
	public List<Shipment> findAll(Pageable pageable,@Param("companys")String companys,@Param("key")String key);
	
	@Query("SELECT COUNT(shipment) FROM Shipment shipment WHERE "
			+ "(shipment.shipFromParty.id =:companys "
			+ "AND (shipment.type = 'CUSTOMER_SHIPMENT' OR shipment.type = 'PURCHASE_RETUR_SHIPMENT')) "
			+ "OR (shipment.shipToParty.id =:companys "
			+ "AND (shipment.type = 'PURCHASE_SHIPMENT' OR shipment.type = 'CUSTOMER_RETUR')) "
			+ "AND shipment.number like :key "
			+ "AND shipment.shipToParty.value like :key "
			+ "AND shipment.shipFromParty.value like :key ")
	public List<Shipment> findAll(@Param("companys")String companys,@Param("key")String key);
	
	@Query("FROM Shipment ship WHERE "
			+ "ship.shipFromParty.id =:sender "
			+ "AND ship.type = 'CUSTOMER_SHIPMENT' "
			+ "AND ship.shipToParty.id =:receiver "
			+ "AND ship.flow = 'BEFORE_PAYMENT' "
			+ "ORDER BY ship.entryDate ASC ")
	public List<Shipment> findAllSalesInvoiceable(@Param("sender")String sender,@Param("receiver")String receiver);
	
	@Query("FROM Shipment ship WHERE "
			+ "ship.shipFromParty.id =:sender "
			+ "AND (ship.type = 'PURCHASE_SHIPMENT' OR ship.type = 'CUSTOMER_RETUR') "
			+ "AND ship.shipToParty.id =:receiver "
			+ "ORDER BY ship.entryDate ASC ")
	public List<Shipment> findAllPurchseInvoiceable(@Param("sender")String sender,@Param("receiver")String receiver);
	
	@Query("SELECT SUM(so.quantity) FROM ShipmentOrder so WHERE so.orderItem.id =:orderItem")
	public BigDecimal getTotalOrder(@Param("orderItem")String orderItem);
}
