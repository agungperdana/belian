/**
 * 
 */
package com.kratonsolution.belian.tools.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ReminderRepository extends JpaRepository<Inbox, String>
{

}
