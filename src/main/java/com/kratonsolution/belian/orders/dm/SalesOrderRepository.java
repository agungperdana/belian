
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
public interface SalesOrderRepository extends JpaRepository<SalesOrder, String>
{
	@Query("FROM SalesOrder so WHERE so.partyTakingOrder.id IN(:companys) ORDER BY so.number ASC")
	public List<SalesOrder> findAll(Pageable pageable,@Param("companys")List<String> companys);
	
	@Query("SELECT COUNT(so) FROM SalesOrder so WHERE so.partyTakingOrder.id IN(:companys)")
	public Long count(@Param("companys")List<String> companys);
	
	@Query("FROM SalesOrder so WHERE "
			+ "so.partyTakingOrder.id IN(:companys) "
			+ "AND (so.number LIKE %:key% "
			+ "OR so.partyPlacingOrder.value LIKE %:key% "
			+ "OR so.billToAddress.value LIKE %:key% "
			+ "OR so.billToContact.value LIKE %:key% "
			+ "OR so.shipToParty.value LIKE %:key% "
			+ "OR so.shipToAddress.value LIKE %:key% "
			+ "OR so.shipToContact.value LIKE %:key%) "
			+ "ORDER BY so.number ASC")
	public List<SalesOrder> findAll(Pageable pageable,@Param("companys")List<String> companys,@Param("key")String key);
	
	@Query("SELECT COUNT(so) FROM SalesOrder so WHERE "
			+ "so.partyTakingOrder.id IN(:companys) "
			+ "AND (so.number LIKE %:key% "
			+ "OR so.partyPlacingOrder.value LIKE %:key% "
			+ "OR so.billToAddress.value LIKE %:key% "
			+ "OR so.billToContact.value LIKE %:key% "
			+ "OR so.shipToParty.value LIKE %:key% "
			+ "OR so.shipToAddress.value LIKE %:key% "
			+ "OR so.shipToContact.value LIKE %:key%) ")
	public Long count(@Param("companys")List<String> companys,@Param("key")String key);
	
	@Query("FROM SalesOrder sales WHERE "
			+ "sales.partyTakingOrder.id =:company "
			+ "AND sales.type = 'DROPSHIP' "
			+ "AND sales.partyPlacingOrder.id =:customer "
			+ "ORDER BY sales.orderDate ASC ")
	public List<SalesOrder> findAllInvoiceable(@Param("company")String company,@Param("customer")String customer);

	@Query("FROM SalesOrderItem item WHERE "
			+ "item.order.partyTakingOrder.id =:company "
			+ "AND item.type = 'WORK' "
			+ "AND item.workeffort IS FALSE")
	public List<SalesOrderItem> findAllForWorkEffort(@Param("company")String company);
}
