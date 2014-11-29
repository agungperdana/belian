/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ProductCategoryRepository extends MongoRepository<ProductCategory,String>
{
	public ProductCategory findOneByName(String name);
}
