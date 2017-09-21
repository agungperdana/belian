/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, String>
{
	@Query("FROM OrderItem item WHERE "
			+ "item.order.partyTakingOrder.id =:supplier "
			+ "AND item.order.partyPlacingOrder.id =:company "
			+ "ORDER BY item.order.number ASC, item.order.orderDate ASC ")
	public List<OrderItem> findAllReceivable(@Param("supplier")String supplier,@Param("company")String company);
	
	@Query("FROM OrderItem item WHERE "
			+ "item.order.partyTakingOrder.id =:taking "
			+ "AND item.order.partyPlacingOrder.id =:placing "
			+ "ORDER BY item.order.number ASC, item.order.orderDate ASC ")
	public List<OrderItem> findAll(@Param("taking")String taking,@Param("placing")String placing);
	
	@Query("FROM OrderItem item WHERE "
			+ "item.order.partyTakingOrder.id =:taking "
			+ "AND item.order.partyPlacingOrder.id =:placing "
			+ "AND item.product.id =:product "
			+ "ORDER BY item.order.number ASC, item.order.orderDate ASC ")
	public List<OrderItem> findShipables(@Param("taking")String taking,@Param("placing")String placing,@Param("product")String product);

	@Query("FROM OrderItem item WHERE item.order.partyTakingOrder.id =:taking "
			+ "AND item.type = 'WORK' "
			+ "ORDER BY item.order.entryDate ASC ")
	public List<OrderItem> findAllWorkRequirements(@Param("taking")String taking);
	
	@Query("FROM OrderItem item WHERE "
			+ "item.order.partyTakingOrder.id =:company "
			+ "AND item.workeffort IS FALSE "
			+ "ORDER BY item.order.entryDate ASC")
	public List<OrderItem> findAllForWorkEfforts(@Param("company")String company);
}
