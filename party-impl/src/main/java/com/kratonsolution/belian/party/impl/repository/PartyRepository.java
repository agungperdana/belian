package com.kratonsolution.belian.party.impl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.party.impl.model.Party;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface PartyRepository extends JpaRepository<Party,String>
{	
	@Query("FROM Party agent WHERE agent.id !=:id ORDER BY agent.name ASC")
	public List<Party> findAllExcept(@Param("id")String id);
	
	@Query("FROM Party agent WHERE agent.name LIKE %:name% ORDER BY agent.name ASC")
	public List<Party> findAll(@Param("name")String name);
	
	public Optional<Party> findOneByCode(String code);
}
