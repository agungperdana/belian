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
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, String>
{
	@Query("FROM StudentAttendance att WHERE "
			+ "att.organization.id IN(:company) "
			+ "ORDER BY att.date DESC")
	public List<StudentAttendance> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(att) FROM StudentAttendance att WHERE "
			+ "att.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM StudentAttendance att WHERE "
			+ "att.organization.id IN(:company) "
			+ "AND (att.product.name LIKE %:key% OR "
			+ "att.room.code LIKE %:key% OR att.room.name LIKE %:key% "
			+ "OR att.period.name LIKE %:key%) "
			+ "ORDER BY att.date DESC")
	public List<StudentAttendance> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(att) FROM StudentAttendance att WHERE "
			+ "att.organization.id IN(:company) "
			+ "AND (att.product.name LIKE %:key% OR "
			+ "att.room.code LIKE %:key% OR att.room.name LIKE %:key% "
			+ "OR att.period.name LIKE %:key%) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
}
