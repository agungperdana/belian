package com.kratonsolution.belian.stockadjustment.impl.repository;

import java.util.List;

import com.kratonsolution.belian.stockadjustment.impl.orm.StockAdjustment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface StockAdjustmentRepository extends JpaRepository<StockAdjustment, String>
{
	@Query("FROM StockAdjustment stock WHERE "
			+ "stock.organization.id IN(:company) "
			+ "ORDER BY stock.date DESC")
	public List<StockAdjustment> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("FROM StockAdjustment stock WHERE "
			+ "stock.organization.id IN(:company) "
			+ "AND (stock.organization.value LIKE %:key% "
			+ "OR stock.facility.value LIKE %:key% "
			+ "OR stock.log.creator LIKE %:key%) "
			+ "ORDER BY stock.date DESC")
	public List<StockAdjustment> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(stock) FROM StockAdjustment stock WHERE stock.organization.id IN(:company)")
	public Long count(@Param("company")List<String> company);
	
	@Query("SELECT COUNT(stock) FROM StockAdjustment stock WHERE "
			+ "stock.organization.id IN(:company) "
			+ "AND (stock.organization.value LIKE %:key% "
			+ "OR stock.facility.value LIKE %:key% "
			+ "OR stock.log.creator LIKE %:key%) "
			+ "ORDER BY stock.date DESC")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
}
