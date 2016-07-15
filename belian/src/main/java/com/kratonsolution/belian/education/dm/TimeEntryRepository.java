/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.production.dm.TimeEntry;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface TimeEntryRepository extends JpaRepository<TimeEntry, String>
{

}
