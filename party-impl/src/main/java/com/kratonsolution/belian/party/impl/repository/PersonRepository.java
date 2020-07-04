package com.kratonsolution.belian.party.impl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.party.impl.model.Person;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface PersonRepository extends JpaRepository<Person, String>
{
	@Query("FROM Person person WHERE person.party.code = ?1")
	public Optional<Person> findByCode(@NonNull String partyCode);
}
