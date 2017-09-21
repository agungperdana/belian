/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface TimeEntryRepository extends JpaRepository<TimeEntry, String>
{
	@Query("FROM TimeEntry en WHERE en.effort.owner.id =:company ORDER BY en.start DESC")
	public List<TimeEntry> findAll(@Param("company")String company);
}
