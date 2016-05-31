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
public interface DoctorRelationshipRepository extends JpaRepository<DoctorRelationship, String>
{
	@Query("SELECT rel.doctor FROM DoctorRelationship rel WHERE rel.organization.party.id =:company ORDER BY rel.doctor.party.name ASC")
	public List<Doctor> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(rel.doctor) FROM DoctorRelationship rel WHERE rel.organization.party.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("FROM DoctorRelationship rel WHERE rel.doctor.id =:doctor AND rel.organization.party.id =:company")
	public DoctorRelationship findOne(@Param("doctor")String doctor,@Param("company")String company);

	@Query("FROM DoctorRelationship rel WHERE rel.doctor.party.name LIKE :name% AND rel.organization.party.id =:company")
	public List<DoctorRelationship> findAll(@Param("name")String name,@Param("company")String company);
}
