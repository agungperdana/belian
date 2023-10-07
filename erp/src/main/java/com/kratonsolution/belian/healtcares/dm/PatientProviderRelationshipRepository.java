
package com.kratonsolution.belian.healtcares.dm;

import java.util.List;

import com.kratonsolution.belian.party.impl.orm.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public interface PatientProviderRelationshipRepository extends JpaRepository<PatientProviderRelationship, String>
{
	@Query("FROM PatientProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PatientProviderRelationship> findAll(@Param("company")String company);
	
	@Query("FROM PatientProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PatientProviderRelationship> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(prov) FROM PatientProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company ")
	public Long count(@Param("company")String company);
	
	@Query("FROM PatientProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "AND prov.fromParty.name LIKE :key "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PatientProviderRelationship> findAll(@Param("company")String company,@Param("key")String key);
	
	@Query("FROM PatientProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "AND prov.fromParty.name LIKE :key "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PatientProviderRelationship> findAll(Pageable pageable,@Param("company")String company,@Param("key")String key);
	
	@Query("SELECT COUNT(prov) FROM PatientProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "AND prov.fromParty.name LIKE :key ")
	public Long count(@Param("company")String company,@Param("key")String key);

	@Query("FROM PatientProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "AND (prov.fromParty.name =:name OR prov.fromParty.code =:code) "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PatientProviderRelationship> findAll(@Param("code")String code,
													 @Param("name")String name,
													 @Param("company")String company);
	
	@Query("SELECT prov.fromParty FROM PatientProviderRelationship prov WHERE prov.id =:id ")
	public Person findPerson(@Param("id")String id);
}
