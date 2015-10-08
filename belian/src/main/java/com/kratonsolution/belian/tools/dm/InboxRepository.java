/**
 * 
 */
package com.kratonsolution.belian.tools.dm;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface InboxRepository extends JpaRepository<Inbox, String>
{
	public List<Inbox> findAllByOwnerId(String owner,PageRequest request);
}
