/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PatientRelationshipRepository extends JpaRepository<PatientRelationship, String>
{
	@Query("FROM PatientRelationship pat WHERE "
			+ "pat.organization.party.id IN(:company) "
			+ "ORDER BY pat.patient.party.name ASC")
	public List<PatientRelationship> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("FROM PatientRelationship pat WHERE "
			+ "(pat.patient.party.identity LIKE %:key% "
			+ "OR pat.patient.party.name LIKE %:key%) "
			+ "AND pat.organization.party.id IN(:company) "
			+ "ORDER BY pat.patient.party.name ASC")
	public List<PatientRelationship> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(pat) FROM PatientRelationship pat WHERE "
			+ "(pat.patient.party.identity LIKE %:key% "
			+ "OR pat.patient.party.name LIKE %:key%) "
			+ "AND pat.organization.party.id IN(:company) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(pat) FROM PatientRelationship pat WHERE "
			+ "pat.organization.party.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM PatientRelationship rel WHERE rel.patient.id =:patient AND rel.organization.party.id =:company ")
	public PatientRelationship findOne(@Param("patient")String patient,@Param("company")String company);

	@Query("FROM PatientRelationship rel WHERE "
			+ "rel.patient.party.name Like :name% "
			+ "AND rel.organization.party.id =:company "
			+ "ORDER BY rel.patient.party.name ASC")
	public List<PatientRelationship> findAll(@Param("name")String name,@Param("company")String company);
}
