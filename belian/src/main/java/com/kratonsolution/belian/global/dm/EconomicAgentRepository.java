/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * @author Agung Dodi Perdana
 *
 */
public interface EconomicAgentRepository extends JpaRepository<EconomicAgent,String>
{	
	public List<EconomicAgent> findAllByRolesType(String name);
	
//	@Query("SELECT DISTINCT(rel.party) FROM PartyRelationship rel WHERE rel.responsibleAs.name =:name AND rel.responsibleTo.id =:id")
//	public List<EconomicAgent> findByRoleAndParty(@Param("name")String name,@Param("id")String responsibleTo);

	@Query("FROM EconomicAgent agent WHERE agent.id !=:id ORDER BY agent.name ASC")
	public List<EconomicAgent> findAllExcept(@Param("id")String id);
}
