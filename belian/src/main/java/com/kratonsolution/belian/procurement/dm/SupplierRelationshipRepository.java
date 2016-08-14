/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface SupplierRelationshipRepository extends JpaRepository<SupplierRelationship, String>
{
	@Query("FROM SupplierRelationship sup WHERE "
			+ "sup.organization.party.id IN(:company) "
			+ "ORDER BY sup.supplier.party.name ASC ")
	public List<SupplierRelationship> findAll(@Param("company")List<String> company);
	
	@Query("FROM SupplierRelationship sup WHERE "
			+ "sup.organization.party.id IN(:company) "
			+ "AND (sup.supplier.party.name LIKE %:key% "
			+ "OR sup.supplier.party.identity LIKE %:key%) "
			+ "ORDER BY sup.supplier.party.name ASC ")
	public List<SupplierRelationship> findAll(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("FROM SupplierRelationship sup WHERE "
			+ "sup.organization.party.id IN(:company) "
			+ "ORDER BY sup.supplier.party.name ASC ")
	public List<SupplierRelationship> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(sup) FROM SupplierRelationship sup WHERE "
			+ "sup.organization.party.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("SELECT COUNT(sup) FROM SupplierRelationship sup WHERE "
			+ "sup.organization.party.id IN(:company) "
			+ "AND (sup.supplier.party.name LIKE %:key% "
			+ "OR sup.supplier.party.identity LIKE %:key%) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("FROM SupplierRelationship sup WHERE "
			+ "sup.organization.party.id IN(:company) "
			+ "AND (sup.supplier.party.name LIKE %:key% "
			+ "OR sup.supplier.party.identity LIKE %:key%) "
			+ "ORDER BY sup.supplier.party.name ASC ")
	public List<SupplierRelationship> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);

	@Query("FROM SupplierRelationship sup WHERE "
			+ "sup.supplier.party.id =:party "
			+ "AND sup.organization.party.id =:company")
	public SupplierRelationship findOne(@Param("party")String party,@Param("company")String company);
}

