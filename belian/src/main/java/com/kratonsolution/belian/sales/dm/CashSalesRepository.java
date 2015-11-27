/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CashSalesRepository extends JpaRepository<CashSales,String>
{
	@Query("FROM CashSales cash WHERE cash.status = 'UNPAID' ORDER BY cash.table ASC")
	public List<CashSales> loadAllUnpaid(Pageable pageable);
	
	@Query("FROM CashSales cash WHERE cash.organization.id IN :companys ORDER BY cash.table ASC,cash.status DESC")
	public List<CashSales> loadAllOrderByStatus(Pageable pageable,@Param("companys")List<String> companys);
	
	@Query("SELECT COUNT(cash) FROM CashSales cash WHERE cash.organization.id IN :companys")
	public int count(@Param("companys")List<String> companys);
	
	@Query("FROM CashSales cash WHERE cash.organization.id IN :companys AND cash.date >= :date AND cash.status = 'PAID'")
	public List<CashSales> findAllByDate(@Param("date")Date date,@Param("companys")List<String> companys);
	
	@Query("FROM CashSales cash WHERE (cash.date BETWEEN :start AND :end) AND cash.organization.id IN :companys AND cash.status = 'PAID'")
	public List<CashSales> findAllByDateBetween(@Param("start")Date start,@Param("end")Date end,@Param("companys")List<String> companys);
}
