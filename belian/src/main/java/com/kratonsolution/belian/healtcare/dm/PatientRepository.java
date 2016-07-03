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
public interface PatientRepository extends JpaRepository<Patient, String>
{
	public Patient findOneByBpjsCard(String bpjsCardNumber);
	
	@Query("FROM Patient pat WHERE pat.party.id =:person")
	public Patient findOne(@Param("person")String person);

	@Query("SELECT rel.patient FROM PatientRelationship rel "
			+ "WHERE rel.patient.party.id =:person "
			+ "AND rel.organization.party.id =:company")
	public Patient findOne(@Param("person")String person,@Param("company")String company);
	
	@Query("FROM PatientRelationship rel "
			+ "WHERE rel.organization.party.id =:company "
			+ "ORDER BY rel.patient.party.name ASC")
	public List<PatientRelationship> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(rel) FROM "
			+ "PatientRelationship rel "
			+ "WHERE rel.organization.party.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("SELECT rel.patient FROM PatientRelationship rel WHERE "
			+ "rel.patient.party.name LIKE :name% "
			+ "AND rel.organization.party.id =:company "
			+ "ORDER BY rel.patient.party.name ASC")
	public List<Patient> findAll(@Param("name")String name,@Param("company")String company);

	@Query("SELECT rel.patient FROM PatientRelationship rel WHERE "
			+ "rel.organization.party.id =:company "
			+ "ORDER BY rel.patient.party.name ASC")
	public List<Patient> findAll(@Param("company")String company);
	
	public Patient findOneByPartyId(String id);
}