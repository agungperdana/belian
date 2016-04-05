/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface BudgetRepository extends JpaRepository<Budget, String>
{
	@Query("FROM Budget budget WHERE budget.organization.id IN :companys")
	public List<Budget> findAll(Pageable pageable,@Param("companys")List<String> companys);
	
	@Query("SELECT COUNT(budget) FROM Budget budget WHERE budget.organization.id IN :companys")
	public int count(@Param("companys")List<String> companys);
}
