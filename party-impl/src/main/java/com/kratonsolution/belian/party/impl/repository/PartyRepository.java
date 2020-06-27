package com.kratonsolution.belian.party.impl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.party.impl.model.Party;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface PartyRepository extends JpaRepository<Party,String>
{		
	public Optional<Party> findOneByCode(String code);
}
