/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CashSalesRepository extends JpaRepository<CashSales,String>
{
	@Query("FROM CashSales cash WHERE cash.status = 'UNPAID' ORDER BY cash.table ASC")
	public List<CashSales> loadAllUnpaid(Pageable pageable);
	
	@Query("FROM CashSales cash ORDER BY cash.table ASC,cash.status DESC")
	public List<CashSales> loadAllOrderByStatus(Pageable pageable);
}
