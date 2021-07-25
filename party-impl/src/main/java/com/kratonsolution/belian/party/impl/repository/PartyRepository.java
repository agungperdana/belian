package com.kratonsolution.belian.party.impl.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.party.api.model.PartyType;
import com.kratonsolution.belian.party.impl.model.Party;

import lombok.NonNull;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface PartyRepository extends JpaRepository<Party,String>, JpaSpecificationExecutor<Party> {		
	
	public Party findOneByCode(@NonNull String code);
	
	@Query("SELECT COUNT(party) FROM Party party WHERE party.type = ?1")
	public Long count(@NonNull PartyType type);
	
	public List<Party> findAllByType(@NonNull PartyType type);
	
	public List<Party> findAllByType(@NonNull PartyType type, Pageable pageable);
	
	@Query("FROM Party party WHERE party.code LIKE ?1 OR "
			+ "party.name LIKE ?1 OR "
			+ "party.type LIKE ?1 "
			+ "ORDER BY party.code, party.name ASC ")
	public List<Party> getAll(@NonNull String key, Pageable pageable);
	
	@Query("FROM Party party ORDER BY party.code, party.name ASC ")
	public List<Party> getAll(Pageable pageable);
	
}
