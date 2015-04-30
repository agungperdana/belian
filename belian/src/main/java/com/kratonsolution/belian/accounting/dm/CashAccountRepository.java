/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author agungdodiperdana
 *
 */
public interface CashAccountRepository extends JpaRepository<CashAccount, String>
{
	public CashAccount findOneByNumber(String number);
	
	@Query("FROM CashAccount cash WHERE cash.owner.id =:owner")
	public CashAccount findOneByOwner(@Param("owner")String ownerId);
}
