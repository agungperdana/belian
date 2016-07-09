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
			+ "AND (reg.customer.identity LIKE %:key% "
			+ "OR reg.customer.name LIKE %:key% "
			+ "OR reg.number LIKE %:key%) "
			+ "ORDER BY reg.date DESC")
	public List<CourseRegistration> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(reg) FROM CourseRegistration reg WHERE "
			+ "reg.organization.id IN(:company) "
			+ "AND (reg.customer.identity LIKE %:key% "
			+ "OR reg.customer.name LIKE %:key% "
			+ "OR reg.number LIKE %:key%) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("FROM CourseRegistration reg WHERE "
			+ "reg.organization.id IN(:company) "
			+ "ORDER BY reg.date DESC")
	public List<CourseRegistration> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(reg) FROM CourseRegistration reg WHERE reg.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM CourseRegistration reg WHERE "
			+ "reg.organization.id IN(:company) "
			+ "AND reg.paid IS FALSE "
			+ "AND (reg.customer.identity LIKE %:key% "
			+ "OR reg.customer.name LIKE %:key% "
			+ "OR reg.number LIKE %:key%) "
			+ "ORDER BY reg.date DESC")
	public List<CourseRegistration> findAllUnpaid(@Param("company")List<String> company,@Param("key")String key);
}
