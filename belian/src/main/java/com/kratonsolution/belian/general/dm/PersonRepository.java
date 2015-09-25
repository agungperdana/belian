/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface PersonRepository extends JpaRepository<Person, String>
{
	public Person findOneByName(String name);
	
	public List<Person> findAllByRolesType(PartyRole.Type type);
	
	public List<Person> findAllByNameNot(String name);
	
//	@Query("SELECT DISTINCT(relation.party) FROM PartyRelationship relation WHERE relation.responsibleTo.id =:organization AND relation.responsibleAs.name = 'Budget Reviewer'")
//	public List<Person> findAllReviewer(@Param("organization") String organization);

//	@Query("SELECT DISTINCT(ship.party) FROM PartyRelationship ship WHERE ship.to IS NULL AND ship.responsibleTo.id =:org AND ship.relationshipType.name = 'Employment Prospect Relationship' ORDER BY ship.party.name ASC")
//	public List<Person> findAllProspect(@Param("org")String company);
}
