/**
 * 
 */
package com.kratonsolution.belian.tools.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ImportantRepository extends JpaRepository<Inbox, String>
{	
	@Query("FROM Inbox bx WHERE "
			+ "bx.receiver.id =:receiver "
			+ "AND bx.type = 'Important' "
			+ "ORDER BY bx.date DESC")
	public List<Inbox> findAll(Pageable pageable,@Param("receiver")String receiver);
	
	@Query("SELECT COUNT(bx) FROM Inbox bx WHERE bx.receiver.id =:receiver AND bx.type = 'Important'")
	public Long count(@Param("receiver")String receiver);
}
