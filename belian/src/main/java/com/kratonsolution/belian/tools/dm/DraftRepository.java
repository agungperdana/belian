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
public interface DraftRepository extends JpaRepository<Message, String>
{
	@Query("FROM Message mg WHERE "
			+ "mg.sender.id =:sender "
			+ "AND mg.type = 'Draft' "
			+ "ORDER BY mg.date DESC")
	public List<Message> findAll(Pageable pageable,@Param("sender")String sender);
	
	@Query("SELECT COUNT(mg) FROM Message mg WHERE "
			+ "mg.sender.id =:sender "
			+ "AND mg.type = 'Draft'")
	public Long count(@Param("sender")String sender);
}
