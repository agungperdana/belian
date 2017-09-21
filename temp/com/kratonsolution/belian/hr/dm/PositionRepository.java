/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PositionRepository extends JpaRepository<Position, String>
{
	@Query("FROM Position pos WHERE pos.id != :id")
	public List<Position> findAllNotEqual(@Param("id")String positionId);

	@Query("FROM Position pos WHERE "
			+ "pos.organization.id IN(:company) "
			+ "ORDER BY pos.start DESC,pos.type.title ASC")
	public List<Position> findAll(@Param("company")List<String> company);
	
	@Query("FROM Position pos WHERE "
			+ "pos.organization.id IN(:company) "
			+ "ORDER BY pos.start DESC,pos.type.title ASC")
	public List<Position> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(pos) FROM Position pos WHERE "
			+ "pos.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM Position pos WHERE "
			+ "pos.organization.id IN(:company) "
			+ "AND pos.type.title LIKE %:key% "
			+ "ORDER BY pos.start DESC,pos.type.title ASC")
	public List<Position> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(pos) FROM Position pos WHERE "
			+ "pos.organization.id IN(:company) "
			+ "AND pos.type.title LIKE %:key% "
			+ "ORDER BY pos.start DESC,pos.type.title ASC")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	
}
