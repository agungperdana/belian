/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductRepository extends JpaRepository<Product, String>
{
	public Product findOneByName(String name);
	
	@Query("FROM Product prd WHERE "
			+ "prd.name LIKE %:key% "
			+ "ORDER BY prd.name ASC")
	public List<Product> findAll(Pageable pageable,@Param("key")String key);

	@Query("SELECT COUNT(prd) FROM Product prd WHERE prd.name LIKE %:key%")
	public Long count(@Param("key")String key);
	
	@Query("SELECT DISTINCT prd FROM Product prd INNER JOIN prd.classifications cat WHERE "
			+ "cat.category.id IN(:categorys) "
			+ "ORDER BY prd.name ASC")
	public List<Product> byCategorys(@Param("categorys")Collection<String> categorys);
	
	@Query("FROM Product prd WHERE prd.name LIKE :key% ORDER BY prd.name ASC")
	public List<Product> findAll(@NonNull @Param("key")String key);
	

}
