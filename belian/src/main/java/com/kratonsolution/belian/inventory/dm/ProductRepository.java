/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductRepository extends JpaRepository<Product, String>
{
	public Product findOneByName(String name);
	
	public List<Product> findAllByTypeNot(Product.Type type);
	
	@Query("FROM Product prd WHERE prd.category.id =:category AND (:date BETWEEN prd.start AND prd.end) ORDER BY prd.name ASC")
	public List<Product> findAllActiveProductByCategory(@Param("category")String categoryId,@Param("date")Date date);

	public List<Product> findAllBySegmentation(IndustrySegmentation segmentation);
}
