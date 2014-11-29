/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ProductRepository extends MongoRepository<Product, String>
{
	public Product findOneByName(String name);
}
