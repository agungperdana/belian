/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface TaxRepository extends MongoRepository<Tax, String>
{
	public Tax findOneByName(String name);
}
