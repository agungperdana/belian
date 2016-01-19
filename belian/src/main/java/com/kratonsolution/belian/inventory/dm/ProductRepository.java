/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.general.dm.IndustrySegmentation;
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

	@Query("FROM Product prd WHERE prd.segmentation =:segment AND (prd.category.code =:category OR prd.category.name =:category) AND prd.type =:type AND ((:date BETWEEN prd.start AND prd.end) OR  (:date >= prd.start AND prd.end IS NULL)) ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date,@Param("category")String category,@Param("segment")IndustrySegmentation segmentation,@Param("type")Type type);
	
	@Query("FROM Product prd WHERE prd.segmentation =:segment AND (prd.category.code =:category OR prd.category.name =:category) AND prd.type =:type AND prd.name LIKE :name% AND ((:date BETWEEN prd.start AND prd.end) OR  (:date >= prd.start AND prd.end IS NULL)) ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date,@Param("category")String category,@Param("segment")IndustrySegmentation segmentation,@Param("type")Type type,@Param("name")String name);

	@Query("FROM Product prd WHERE :date BETWEEN prd.start AND prd.end ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date);
	
	@Query("FROM Product prd WHERE (:date BETWEEN prd.start AND prd.end) AND prd.name LIKE :name% ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date,@Param("name")String name);
}
