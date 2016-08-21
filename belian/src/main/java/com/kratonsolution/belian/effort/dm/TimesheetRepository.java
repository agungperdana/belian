/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface TimesheetRepository extends JpaRepository<Timesheet, String>
{
	@Query("FROM Timesheet tm WHERE "
			+ "(:date BETWEEN tm.start AND tm.end) "
			+ "AND tm.employee.party.id =:employee ")
	public Timesheet findOne(@Param("date")Date date,@Param("employee")String employee);
	
	@Query("FROM Timesheet time WHERE "
			+ "time.organization.id IN(:company) "
			+ "ORDER BY time.start ASC ")
	public List<Timesheet> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(time) FROM Timesheet time WHERE "
			+ "time.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM Timesheet time WHERE "
			+ "time.organization.id IN(:company) "
			+ "AND (time.employee.party.identity LIKE %:key% "
			+ "OR time.employee.party.name LIKE %:key%) "
			+ "ORDER BY time.start ASC ")
	public List<Timesheet> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(time) FROM Timesheet time WHERE "
			+ "time.organization.id IN(:company) "
			+ "AND (time.employee.party.identity LIKE %:key% "
			+ "OR time.employee.party.name LIKE %:key%) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
}
