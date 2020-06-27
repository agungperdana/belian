package com.kratonsolution.belian.party.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.party.impl.model.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface PersonRepository extends JpaRepository<Person, String>
{
	
}
