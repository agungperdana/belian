/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface AccountingPeriodRepository extends JpaRepository<AccountingPeriod, String>
{
	public List<AccountingPeriod> findAllByParentIsNull();
}
