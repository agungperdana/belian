/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author agungdodiperdana
 *
 */
public interface PersonRepository extends JpaRepository<Person, String>
{
	public Person findOneByName(String name);
	
	public List<Person> findAllByRolesTypeName(String name);
	
	public List<Person> findAllByNameNot(String name);
	
	@Query("SELECT DISTINCT(relation.party) FROM PartyRelationship relation WHERE relation.responsibleTo.id =:organization AND relation.responsibleAs.name = 'Budget Reviewer'")
	public List<Person> findAllReviewer(@Param("organization") String organization);
}
