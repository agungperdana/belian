/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.general.dm.IndustrySegmentation;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductRepository extends JpaRepository<Product, String>
{
	public Product findOneByName(String name);

	public Product findOneByNameOrId(String name,String id);
	
	public List<Product> findAllByTypeNot(ProductType type);
	
	@Query("FROM Product prd WHERE "
			+ "prd.code LIKE %:key% OR "
			+ "prd.name LIKE %:key% "
			+ "OR prd.category.name LIKE %:key% "
			+ "ORDER BY prd.code ASC,prd.name ASC")
	public List<Product> findAll(Pageable pageable,@Param("key")String key);
	
	@Query("SELECT COUNT(prd) FROM Product prd WHERE "
			+ "prd.code LIKE %:key% "
			+ "OR prd.name LIKE %:key%")
	public Long count(@Param("key")String key);
	
	@Query("FROM Product prd WHERE "
			+ "prd.category.id =:category "
			+ "AND (:date BETWEEN prd.start AND prd.end) "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAllActiveProductByCategory(@Param("category")String categoryId,@Param("date")Date date);
	
	@Query("FROM Product prd WHERE "
			+ "prd.category.segmentation =:segmentation "
			+ "AND (prd.code LIKE %:name% OR prd.name LIKE %:name%) "
			+ "AND prd.type =:type "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAllBySegmentationAndNameAndType(@Param("segmentation")IndustrySegmentation segmentation,
															 @Param("name")String name,
															 @Param("type")ProductType type);

	@Query("FROM Product prd WHERE "
			+ "prd.category.segmentation =:segment "
			+ "AND (prd.category.code =:category OR prd.category.name =:category) "
			+ "AND prd.type =:type "
			+ "AND ((:date BETWEEN prd.start AND prd.end) OR  (:date >= prd.start AND prd.end IS NULL)) "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date,
								 @Param("category")String category,
								 @Param("segment")IndustrySegmentation segmentation,
								 @Param("type")ProductType type);
	
	@Query("FROM Product prd WHERE "
			+ "prd.category.segmentation =:segment "
			+ "AND (prd.category.code =:category OR prd.category.name =:category) "
			+ "AND prd.type =:type "
			+ "AND prd.name LIKE %:name% "
			+ "AND ((:date BETWEEN prd.start AND prd.end) OR  (:date >= prd.start AND prd.end IS NULL)) "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date,
								 @Param("category")String category,
								 @Param("segment")IndustrySegmentation segmentation,
								 @Param("type")ProductType type,
								 @Param("name")String name);

	@Query("FROM Product prd WHERE :date BETWEEN prd.start AND prd.end ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date);
	
	@Query("FROM Product prd WHERE "
			+ "((:date BETWEEN prd.start AND prd.end) OR (prd.start <= :date AND prd.end IS NULL)) "
			+ "AND prd.name LIKE %:name% "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date,@Param("name")String name);
	
	@Query("FROM Product prd WHERE "
			+ "((:date BETWEEN prd.start AND prd.end) "
			+ "OR (prd.start <= :date AND prd.end IS NULL)) "
			+ "AND prd.name LIKE %:name% "
			+ "AND prd.category.segmentation =:segmentation "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date,
								 @Param("name")String name,
								 @Param("segmentation")IndustrySegmentation segmentation);

	@Query("FROM Product prd WHERE "
			+ "((:date BETWEEN prd.start AND prd.end) "
			+ "OR (prd.start <= :date AND prd.end IS NULL)) "
			+ "AND prd.name LIKE %:name% "
			+ "AND prd.category.segmentation =:segmentation "
			+ "AND prd.type =:type "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAllMedical(@Param("date")Date date,
								 @Param("name")String name,
								 @Param("segmentation")IndustrySegmentation segmentation,
								 @Param("type")ProductType type);
	
	@Query("FROM Product prd WHERE "
			+ "((:date BETWEEN prd.start AND prd.end) "
			+ "OR (prd.start <= :date AND prd.end IS NULL)) "
			+ "AND prd.category.segmentation =:segmentation "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAll(@Param("date")Date date,
								 @Param("segmentation")IndustrySegmentation segmentation);
	
	@Query("SELECT DISTINCT(sup.product) FROM ProductSupplier sup WHERE "
			+ "sup.supplier.id =:supplier "
			+ "AND ((:date BETWEEN sup.product.start AND sup.product.end) "
			+ "OR (sup.product.start <= :date AND sup.product.end IS NULL)) "
			+ "ORDER BY sup.product.name ASC ")
	public List<Product> findAllBySupplier(@Param("supplier")String supplierId,@Param("date")java.sql.Date date);
	
	@Query("FROM Product prod WHERE "
			+ "prod.name LIKE %:name% "
			+ "AND prod.type = 'SERVICE' "
			+ "AND prod.category.segmentation = 'MEDICAL' "
			+ "AND ((:date BETWEEN prod.start AND prod.end) OR (prod.start <= :date AND prod.end IS NULL)) "
			+ "ORDER BY prod.name ASC")
	public List<Product> findAllMedicalService(@Param("name")String name,@Param("date")Date date);
}
