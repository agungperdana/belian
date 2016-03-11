/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface StockAdjustmentRepository extends JpaRepository<StockAdjustment, String>
{
	@Query("FROM StockAdjustment stock WHERE stock.organization.id =:company ORDER BY stock.date DESC")
	public List<StockAdjustment> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(stock) FROM StockAdjustment stock WHERE stock.organization.id =:company")
	public Long count(@Param("company")String company);
}
