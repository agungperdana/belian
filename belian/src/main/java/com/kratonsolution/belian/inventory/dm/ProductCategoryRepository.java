/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String>
{
	public ProductCategory findOneByName(String name);
}
