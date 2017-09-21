/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PartyRepository extends JpaRepository<Party,String>
{	
	@Query("FROM Party agent WHERE agent.id !=:id ORDER BY agent.name ASC")
	public List<Party> findAllExcept(@Param("id")String id);
	
	@Query("FROM Party agent WHERE agent.name LIKE %:name% ORDER BY agent.name ASC")
	public List<Party> findAll(@Param("name")String name);
}
