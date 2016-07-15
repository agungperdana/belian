/**
 * 
 */
package com.kratonsolution.belian.production.dm;

import java.sql.Date;

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
}
