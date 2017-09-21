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
public interface CashPurchaseOrderRepository extends JpaRepository<CashPurchaseOrder, String>
{
	@Query("FROM CashPurchaseOrder po WHERE po.organization.id =:company ORDER BY po.date DESC")
	public List<CashPurchaseOrder> findAll(Pageable pageable,@Param("company")String company);
}
