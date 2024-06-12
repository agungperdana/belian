package com.kratonsolution.belian.productcategory.impl.repository;

import java.util.List;

import com.kratonsolution.belian.productcategory.impl.orm.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String>
{
	public ProductCategory findByName(String name);
	
	@Query("FROM ProductCategory cat WHERE cat.parent IS NULL ORDER BY cat.name ASC ")
	public List<ProductCategory> findAllParent();
}
