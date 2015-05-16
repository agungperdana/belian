/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author agungdodiperdana
 *
 */
public interface AccountingPeriodRepository extends JpaRepository<AccountingPeriod, String>
{
	@Query("FROM AccountingPeriod period WHERE period.parent IS NULL ORDER BY period.number ASC")
	public List<AccountingPeriod> findAllByParentIsNull();
}
