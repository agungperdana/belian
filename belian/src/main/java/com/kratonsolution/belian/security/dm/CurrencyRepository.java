/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface CurrencyRepository extends MongoRepository<Currency, String>
{
	public Currency findOneByCode(String code);
}
