/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface WorkEffortBillingRepository extends JpaRepository<WorkEffortBilling, String>
{
	@Query("SELECT SUM(bill.amount) FROM WorkEffortBilling bill WHERE bill.effort.id =:effort ")
	public BigDecimal findPaid(@Param("effort")String id);
}
