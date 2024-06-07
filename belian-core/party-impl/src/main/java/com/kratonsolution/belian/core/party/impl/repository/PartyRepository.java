package com.kratonsolution.belian.core.party.impl.repository;

import java.util.List;

import com.kratonsolution.belian.core.party.impl.orm.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface PartyRepository extends JpaRepository<Party,String>
{	
	@Query("FROM Party agent WHERE agent.id !=:id ORDER BY agent.name ASC")
	public List<Party> findAllExcept(@Param("id")String id);
	
	@Query("FROM Party agent WHERE agent.name LIKE %:name% ORDER BY agent.name ASC")
	public List<Party> findAll(@Param("name")String name);
	
	public Party findByCode(String code);
}
