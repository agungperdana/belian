/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.production.dm.TimeEntry;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface TimeEntryRepository extends JpaRepository<TimeEntry, String>
{
	@Query("FROM TimeEntry time WHERE "
			+ "time.worksheet.employee.party.id =:person "
			+ "AND (time.date BETWEEN :start AND :end) "
			+ "AND time.paid IS FALSE")
	public List<TimeEntry> findAllUnpaid(@Param("person")String person,@Param("start")Date start,@Param("end")Date end);
}
