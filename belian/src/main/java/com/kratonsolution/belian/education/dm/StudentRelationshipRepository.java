/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface StudentRelationshipRepository extends JpaRepository<StudentRelationship, String>
{
	@Query("FROM StudentRelationship ship WHERE "
			+ "ship.organization.party.id IN(:company) "
			+ "ORDER BY ship.student.party.name ASC,ship.student.grade ASC")
	public List<StudentRelationship> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(ship) "
			+ "FROM StudentRelationship ship WHERE "
			+ "ship.organization.party.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM StudentRelationship ship WHERE "
			+ "(ship.student.party.identity LIKE %:key% "
			+ "OR ship.student.party.name LIKE %:key% "
			+ "OR ship.student.grade =:key) "
			+ "AND ship.organization.party.id IN(:company) "
			+ "ORDER BY ship.student.party.name ASC,ship.student.grade ASC")
	public List<StudentRelationship> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(ship) FROM StudentRelationship ship WHERE "
			+ "(ship.student.party.identity LIKE %:key% "
			+ "OR ship.student.party.name LIKE %:key% "
			+ "OR ship.student.grade =:key) "
			+ "AND ship.organization.party.id IN(:company) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("FROM StudentRelationship stu WHERE "
			+ "stu.student.party.id =:person "
			+ "AND stu.organization.party.id =:company")
	public StudentRelationship findOne(@Param("person")String person,@Param("company")String company);
	

	@Query("FROM StudentRelationship ship WHERE "
			+ "(ship.student.party.identity LIKE %:key% "
			+ "OR ship.student.party.name LIKE %:key%) "
			+ "AND ship.organization.party.id IN(:company) ")
	public List<StudentRelationship> findAll(@Param("company")List<String> company,@Param("key")String key);
}
