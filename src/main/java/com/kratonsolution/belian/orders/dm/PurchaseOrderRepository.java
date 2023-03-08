
package com.kratonsolution.belian.orders.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String>
{
	@Query("FROM PurchaseOrder po WHERE po.partyPlacingOrder.id IN(:companys) ORDER BY po.number ASC")
	public List<PurchaseOrder> findAll(Pageable pageable,@Param("companys")List<String> companys);
	
	@Query("SELECT COUNT(po) FROM PurchaseOrder po WHERE po.partyPlacingOrder.id IN(:companys)")
	public Long count(@Param("companys")List<String> companys);
	
	@Query("FROM PurchaseOrder po WHERE "
			+ "po.partyPlacingOrder.id IN(:companys) "
			+ "AND (po.number LIKE %:key% "
			+ "OR po.partyPlacingOrder.value LIKE %:key% "
			+ "OR po.billToAddress.value LIKE %:key% "
			+ "OR po.billToContact.value LIKE %:key% "
			+ "OR po.shipToParty.value LIKE %:key% "
			+ "OR po.shipToAddress.value LIKE %:key% "
			+ "OR po.shipToContact.value LIKE %:key%) "
			+ "ORDER BY po.number ASC")
	public List<PurchaseOrder> findAll(Pageable pageable,@Param("companys")List<String> companys,@Param("key")String key);
	
	@Query("SELECT COUNT(po) FROM PurchaseOrder po WHERE "
			+ "po.partyPlacingOrder.id IN(:companys) "
			+ "AND (po.number LIKE %:key% "
			+ "OR po.partyPlacingOrder.value LIKE %:key% "
			+ "OR po.billToAddress.value LIKE %:key% "
			+ "OR po.billToContact.value LIKE %:key% "
			+ "OR po.shipToParty.value LIKE %:key% "
			+ "OR po.shipToAddress.value LIKE %:key% "
			+ "OR po.shipToContact.value LIKE %:key%) ")
	public Long count(@Param("companys")List<String> companys,@Param("key")String key);
	
	@Query("SELECT DISTINCT po FROM PurchaseOrder po INNER JOIN po.statuses status WHERE "
			+ "po.partyPlacingOrder.id =:company "
			+ "AND po.partyTakingOrder.id =:supplier "
			+ "AND status.type NOT IN('CANCELED','ONHOLD','DONE','FULFILLED') "
			+ "ORDER BY po.orderDate ASC ")
	public List<PurchaseOrder> findAllInvoiceable(@Param("company")String company,@Param("supplier")String supplier);
}
