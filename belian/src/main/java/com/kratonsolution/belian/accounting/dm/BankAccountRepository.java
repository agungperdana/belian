/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, String>
{
	public BankAccount findOneByNumber(String number);
}
