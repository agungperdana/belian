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
public interface OrderRepository extends JpaRepository<Order, String>
{
	@Query("SELECT DISTINCT ord FROM Order ord INNER JOIN ord.statuses stat WHERE "
			+ "stat.type IN('CREATED','RECEIVED','APPROVED','ACTIVE') "
			+ "AND ord.partyTakingOrder.id =:sender "
			+ "AND ord.partyPlacingOrder.id =:receiver "
			+ "ORDER BY ord.entryDate ASC ")
	public List<Order> findAllShipable(@Param("sender")String sender,@Param("receiver")String receiver);
}
