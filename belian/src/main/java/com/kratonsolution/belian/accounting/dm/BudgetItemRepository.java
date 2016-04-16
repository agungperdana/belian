/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface BudgetItemRepository extends JpaRepository<BudgetItem, String>
{
	@Query("FROM BudgetItem item WHERE item.budget.organization.id =:partyRequested "
			+ "AND item.budget.lastStatus.type = 'Approved' "
			+ "ORDER BY item.sequence ASC")
	public List<BudgetItem> findAllByOwner(@Param("partyRequested")String partyRequested);

	@Query("SELECT MAX(item.sequence) FROM BudgetItem item WHERE item.budget.id =:budget")
	public Integer lastSequence(@Param("budget")String budget);
	
	
}
