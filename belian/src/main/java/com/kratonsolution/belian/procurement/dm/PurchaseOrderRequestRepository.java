/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PurchaseOrderRequestRepository extends JpaRepository<PurchaseOrderRequest, String>
{
	@Query("FROM PurchaseOrderRequest po WHERE po.organization.id =:company ORDER BY po.date DESC")
	public List<PurchaseOrderRequest> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("FROM PurchaseOrderRequest po WHERE "
			+ "po.organization.id =:company "
			+ "AND po.approverStatus = 'SUBMITTED' "
			+ "AND po.requestStatus = 'INCOMPLETE' "
			+ "ORDER BY po.date DESC")
	public List<PurchaseOrderRequest> findAllIncomplete(@Param("company")String company);
}
