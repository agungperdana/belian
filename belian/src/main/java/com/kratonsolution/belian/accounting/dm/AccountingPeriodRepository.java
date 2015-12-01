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
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface AccountingPeriodRepository extends JpaRepository<AccountingPeriod, String>
{
	@Query("FROM AccountingPeriod period WHERE period.parent IS NULL ORDER BY period.number ASC")
	public List<AccountingPeriod> findAllByParentIsNull();

	@Query("FROM AccountingPeriod period WHERE period.parent IS NOT NULL AND (:date BETWEEN period.from AND period.to)")
	public AccountingPeriod findForDate(@Param("date") Date date);
	
}
