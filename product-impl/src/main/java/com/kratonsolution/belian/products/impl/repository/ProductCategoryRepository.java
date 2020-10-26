package com.kratonsolution.belian.products.impl.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.products.impl.model.ProductCategory;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String>, JpaSpecificationExecutor<ProductCategory> {

	public ProductCategory findOneByName(@NonNull String name);	
	
	public List<ProductCategory> findAllByNameLike(@NonNull String name, Pageable pageable);
	
	@Query("SELECT COUNT(prod) FROM ProductCategory prod WHERE prod.name LIKE :name")
	public Long count(@NonNull String name);
}
