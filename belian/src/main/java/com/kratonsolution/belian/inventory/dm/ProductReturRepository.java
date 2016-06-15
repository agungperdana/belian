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
public interface ProductReturRepository extends JpaRepository<ProductRetur, String>
{
	@Query("FROM ProductRetur prod WHERE prod.organization.id =:company ORDER BY prod.date DESC")
	public List<ProductRetur> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(prod) FROM ProductRetur prod WHERE prod.organization.id =:company")
	public Long count(@Param("company")String company);
}
