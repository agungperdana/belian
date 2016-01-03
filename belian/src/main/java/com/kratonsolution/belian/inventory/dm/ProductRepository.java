/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.inventory.dm.Product.Type;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductRepository extends JpaRepository<Product, String>
{
	public Product findOneByName(String name);

	public Product findOneByNameOrId(String name,String id);
	
	public List<Product> findAllByTypeNot(Product.Type type);
	
	@Query("FROM Product prd WHERE prd.category.id =:category AND (:date BETWEEN prd.start AND prd.end) ORDER BY prd.name ASC")
	public List<Product> findAllActiveProductByCategory(@Param("category")String categoryId,@Param("date")Date date);

	
	public List<Product> findAllBySegmentationAndType(IndustrySegmentation segmentation,Type type);
	
	@Query("FROM Product prd WHERE prd.segmentation =:segmentation AND (prd.code LIKE :name% OR prd.name LIKE :name%) AND prd.type =:type ORDER BY prd.name ASC")
	public List<Product> findAllBySegmentationAndNameAndType(@Param("segmentation")IndustrySegmentation segmentation,@Param("name")String name,@Param("type")Type type);
}
