
package com.kratonsolution.belian.workefforts.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface WorkEffortRepository extends JpaRepository<WorkEffort, String>
{
	@Query("FROM WorkEffort work WHERE "
			+ "work.owner.id =:company "
			+ "ORDER BY work.creationDate DESC ")
	public List<WorkEffort> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(work) FROM WorkEffort work WHERE "
			+ "work.owner.id =:company ")
	public Long count(@Param("company")String company);
	
	@Query("FROM WorkEffort effort WHERE effort.owner.id =:company AND effort.invoiced = false ")
	public List<WorkEffort> findAllUninvoiced(@Param("company")String company);
}
