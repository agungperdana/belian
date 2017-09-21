/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.sql.Time;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CourseAttendanceRepository extends JpaRepository<CourseAttendance, String>
{
	@Query("FROM CourseAttendance att WHERE "
			+ "att.organization.id IN(:company) "
			+ "ORDER BY att.date DESC")
	public List<CourseAttendance> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(att) FROM CourseAttendance att WHERE "
			+ "att.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM CourseAttendance att WHERE "
			+ "att.organization.id IN(:company) "
			+ "AND (att.schedule.requirement.room.name LIKE %:key% OR "
			+ "att.schedule.requirement.period.name LIKE %:key%) "
			+ "ORDER BY att.date DESC")
	public List<CourseAttendance> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(att) FROM CourseAttendance att WHERE "
			+ "att.organization.id IN(:company) "
			+ "AND (att.schedule.requirement.room.name LIKE %:key% OR "
			+ "att.schedule.requirement.period.name LIKE %:key%) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("FROM CourseAttendance att WHERE "
			+ "att.organization.id IN(:company) "
			+ "AND (att.schedule.start =:start AND att.schedule.end =:end) "
			+ "AND att.schedule.requirement.period.id =:period "
			+ "AND att.schedule.day IN(:day)"
			+ "ORDER BY att.date DESC")
	public List<CourseSchedule> findAll(@Param("company")List<String> company,
										@Param("period")String period,
										@Param("day")List<String> day,
										@Param("start")Time start,
										@Param("end")Time end);
}
