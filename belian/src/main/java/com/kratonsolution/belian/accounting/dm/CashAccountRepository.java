/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface CashAccountRepository extends JpaRepository<CashAccount, String>
{
	public CashAccount findOneByNumber(String number);
}
