/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author agungdodiperdana
 *
 */
public interface AccountingPeriodRepository extends JpaRepository<AccountingPeriod, String>
{
	@Query("FROM AccountingPeriod period WHERE period.parent IS NULL ORDER BY period.number ASC")
	public List<AccountingPeriod> findAllByParentIsNull();

	@Query("FROM AccountingPeriod period WHERE period.parent IS NOT NULL AND (period.from <= :date AND period.to >= :date)")
	public AccountingPeriod findForDate(@Param("date") Date date);
	
}
