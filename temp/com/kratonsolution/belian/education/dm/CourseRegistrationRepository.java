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
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, String>
{
	@Query("FROM CourseRegistration reg WHERE "
			+ "reg.organization.id IN(:company) "
			+ "AND (reg.student.identity LIKE %:key% "
			+ "OR reg.student.name LIKE %:key% "
			+ "OR reg.number LIKE %:key%) "
			+ "ORDER BY reg.date DESC")
	public List<CourseRegistration> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(reg) FROM CourseRegistration reg WHERE "
			+ "reg.organization.id IN(:company) "
			+ "AND (reg.student.identity LIKE %:key% "
			+ "OR reg.student.name LIKE %:key% "
			+ "OR reg.number LIKE %:key%) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("FROM CourseRegistration reg WHERE "
			+ "reg.organization.id IN(:company) "
			+ "ORDER BY reg.date DESC")
	public List<CourseRegistration> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(reg) FROM CourseRegistration reg WHERE reg.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("SELECT itm.registration FROM CourseItem itm WHERE "
			+ "itm.product.id=:product "
			+ "AND itm.feature.id=:feature "
			+ "AND itm.registration.period.id=:period "
			+ "AND itm.registration.day.id=:day "
			+ "AND itm.registration.time.id=:time "
			+ "AND itm.registration.organization.id IN(:company) "
			+ "AND itm.registration.room IS NULL "
			+ "ORDER BY itm.registration.student.name ASC ")
	public List<CourseRegistration> findAllWithoutRoom(@Param("product")String product,
													   @Param("period")String period,
													   @Param("day")String day,@Param("time")String time,
													   @Param("feature")String feature,
													   @Param("company")List<String> company);
}
