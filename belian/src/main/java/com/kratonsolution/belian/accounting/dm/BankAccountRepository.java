/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface BankAccountRepository extends MongoRepository<BankAccount, String>
{
	public BankAccount findOneByNumber(String number);
}
