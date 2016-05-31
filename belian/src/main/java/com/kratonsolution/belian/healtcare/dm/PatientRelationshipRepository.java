/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PatientRelationshipRepository extends JpaRepository<PatientRelationship, String>
{
	@Query("FROM PatientRelationship rel WHERE rel.patient.id =:patient AND rel.organization.party.id =:company ")
	public PatientRelationship findOne(@Param("patient")String patient,@Param("company")String company);

	@Query("FROM PatientRelationship rel WHERE "
			+ "rel.patient.party.name Like :name% "
			+ "AND rel.organization.party.id =:company "
			+ "ORDER BY rel.patient.party.name ASC")
	public List<PatientRelationship> findAll(@Param("name")String name,@Param("company")String company);
}
