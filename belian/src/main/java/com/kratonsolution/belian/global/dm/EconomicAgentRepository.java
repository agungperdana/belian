/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface EconomicAgentRepository extends JpaRepository<EconomicAgent,String>
{	
	@Query("FROM EconomicAgent agent WHERE agent.id !=:id ORDER BY agent.name ASC")
	public List<EconomicAgent> findAllExcept(@Param("id")String id);
}
