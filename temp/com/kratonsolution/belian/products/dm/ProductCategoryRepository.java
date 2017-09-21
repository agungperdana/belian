/**
 * 
 */
package com.kratonsolution.belian.products.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String>
{
	public ProductCategory findOneByName(String name);
}
