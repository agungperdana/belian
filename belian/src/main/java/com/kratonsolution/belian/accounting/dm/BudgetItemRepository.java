/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author agungdodiperdana
 *
 */
public interface BudgetItemRepository extends JpaRepository<BudgetItem, String>
{
	@Query("FROM BudgetItem item WHERE item.budget.partyRequested.id =:partyRequested ORDER BY item.sequence ASC")
	public List<BudgetItem> findAllByOwner(@Param("partyRequested")String partyRequested);
}
