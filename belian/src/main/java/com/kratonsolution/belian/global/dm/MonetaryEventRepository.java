/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface MonetaryEventRepository extends JpaRepository<MonetaryEvent, String>
{
	public List<MonetaryEvent> findAllByDate(Date date);
	
	public List<MonetaryEvent> findAllByDateBetween(Date start,Date end);
}
