/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CourseAttendanceRepository extends JpaRepository<CourseAttendance, String>
{
//	@Query("FROM CourseAttendance att WHERE "
//			+ "att.organization.id IN(:company) "
//			+ "ORDER BY att.date DESC")
//	public List<CourseAttendance> findAll(Pageable pageable,@Param("company")List<String> company);
//	
//	@Query("SELECT COUNT(att) FROM CourseAttendance att WHERE "
//			+ "att.organization.id IN(:company) ")
//	public Long count(@Param("company")List<String> company);
//	
//	@Query("FROM CourseAttendance att WHERE "
//			+ "att.organization.id IN(:company) "
//			+ "AND (att.product.name LIKE %:key% OR "
//			+ "att.room.code LIKE %:key% OR att.room.name LIKE %:key% "
//			+ "OR att.period.name LIKE %:key%) "
//			+ "ORDER BY att.date DESC")
//	public List<CourseAttendance> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
//	
//	@Query("SELECT COUNT(att) FROM CourseAttendance att WHERE "
//			+ "att.organization.id IN(:company) "
//			+ "AND (att.product.name LIKE %:key% OR "
//			+ "att.room.code LIKE %:key% OR att.room.name LIKE %:key% "
//			+ "OR att.period.name LIKE %:key%) ")
//	public Long count(@Param("company")List<String> company,@Param("key")String key);
}
