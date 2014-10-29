/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ProductRepository extends MongoRepository<Product, String>
{
	public Product findOneByName(String name);

	public Product findOneByCode(String code);
	
	public Product findOneByRfid(String rfid);
}
