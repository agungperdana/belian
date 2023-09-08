
package com.kratonsolution.belian.healtcares.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.partys.dm.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PractitionerProviderRelationshipRepository extends JpaRepository<PractitionerProviderRelationship, String>
{
	@Query("FROM PractitionerProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PractitionerProviderRelationship> findAll(@Param("company")String company);
	
	@Query("FROM PractitionerProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PractitionerProviderRelationship> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(prov) FROM PractitionerProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company ")
	public Long count(@Param("company")String company);
	
	@Query("FROM PractitionerProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "AND prov.fromParty.name LIKE :key "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PractitionerProviderRelationship> findAll(@Param("company")String company,@Param("key")String key);
	
	@Query("FROM PractitionerProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "AND prov.fromParty.name LIKE :key "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PractitionerProviderRelationship> findAll(Pageable pageable,@Param("company")String company,@Param("key")String key);
	
	@Query("SELECT COUNT(prov) FROM PractitionerProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "AND prov.fromParty.name LIKE :key ")
	public Long count(@Param("company")String company,@Param("key")String key);
	
	@Query("FROM PractitionerProviderRelationship prov WHERE "
			+ "prov.toParty.id =:company "
			+ "AND (prov.fromParty.code LIKE :code OR prov.fromParty.name LIKE :name) "
			+ "ORDER BY prov.fromParty.name ASC ")
	public List<PractitionerProviderRelationship> findAll(@Param("company")String company,@Param("code")String code,@Param("name")String name);

	@Query("SELECT prov.fromParty FROM PractitionerProviderRelationship prov WHERE prov.id =:id ")
	public Person findPerson(@Param("id")String id);
}
