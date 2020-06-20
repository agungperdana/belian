package com.kratonsolution.belian.party.impl.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.party.impl.model.Gender;
import com.kratonsolution.belian.party.impl.model.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface PersonRepository extends JpaRepository<Person, String>
{
	public Optional<Person> findOneByName(String name);
		
	public Optional<Person> findOneByCode(String code);
	
	public List<Person> findAllByNameNot(String name);
	
	@Query("FROM Person person WHERE person.name LIKE %:name%")
	public List<Person> findAllByName(@Param("name")String name);
	
	@Query("FROM Person person WHERE person.code LIKE %:code%")
	public List<Person> findAllByCode(@Param("code")String code);
	
	@Query("FROM Person person WHERE "
			+ "person.code =:code "
			+ "OR person.name =:name "
			+ "ORDER BY person.name ASC ")
	public List<Person> findAll(@Param("code")String code,@Param("name")String name);
	
	@Query("FROM Person person WHERE "
			+ "(person.code =:code "
			+ "OR person.name =:name) "
			+ "AND person.birthDate =:birthdate "
			+ "AND person.gender =:gender ")
	public Person findOne(@Param("code")String code,
								@Param("name")String name,
								@Param("birthdate")Date birthdate,
								@Param("gender")Gender gender);
	
	@Query("FROM Person person WHERE "
			+ "person.code LIKE %:key% "
			+ "OR person.name LIKE %:key% "
			+ "ORDER BY person.code ASC,person.name ASC")
	public List<Person> findAll(Pageable pageable,@Param("key")String key);
	
	@Query("SELECT COUNT(person) FROM Person person WHERE "
			+ "person.code LIKE %:key% "
			+ "OR person.name LIKE %:key% ")
	public Long count(@Param("key")String key);
}
