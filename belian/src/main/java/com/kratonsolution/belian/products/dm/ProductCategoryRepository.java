/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String>
{
	public ProductCategory findOneByName(String name);
	
	@Query("FROM ProductCategory cat WHERE cat.parent IS NULL ORDER BY cat.name ASC ")
	public List<ProductCategory> findAllParent();
}
