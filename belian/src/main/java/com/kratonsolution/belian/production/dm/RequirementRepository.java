/**
 * 
 */
package com.kratonsolution.belian.production.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface RequirementRepository extends JpaRepository<Requirement, String>
{
	@Query("FROM Requirement mnt WHERE "
			+ "mnt.organization.id IN(:company) "
			+ "ORDER BY mnt.date DESC ")
	public List<Requirement> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(mnt) FROM Requirement mnt WHERE "
			+ "mnt.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM Requirement mnt WHERE "
			+ "mnt.organization.id IN(:company) "
			+ "AND mnt.name LIKE %:key% "
			+ "ORDER BY mnt.date DESC ")
	public List<Requirement> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(mnt) FROM Requirement mnt WHERE "
			+ "mnt.organization.id IN(:company) "
			+ "AND mnt.name LIKE %:key% ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
}
