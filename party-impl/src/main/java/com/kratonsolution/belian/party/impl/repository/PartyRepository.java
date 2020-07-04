package com.kratonsolution.belian.party.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.party.impl.model.Party;

import lombok.NonNull;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface PartyRepository extends JpaRepository<Party,String> {		
	
	public Party findOneByCode(@NonNull String code);
}
