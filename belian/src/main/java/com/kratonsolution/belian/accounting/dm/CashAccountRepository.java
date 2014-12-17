/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface CashAccountRepository extends MongoRepository<CashAccount, String>
{
	public CashAccount findOneByNumber(String number);
}
