/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PersonRepository extends JpaRepository<Person, String>
{
	public Person findOneByName(String name);
		
	public Person findOneByIdentity(String identity);
	
	public List<Person> findAllByNameNot(String name);
	
	@Query("FROM Person person WHERE person.name LIKE :name%")
	public List<Person> findAllByName(@Param("name")String name);
	
	@Query("FROM Person person WHERE person.identity LIKE :identity%")
	public List<Person> findAllByIdentity(@Param("identity")String identity);
	
	@Query("FROM Person person WHERE "
			+ "person.identity LIKE %:key% "
			+ "OR person.name LIKE %:key% "
			+ "ORDER By person.identity ASC,person.name ASC")
	public List<Person> findAll(@Param("key")String key);
	
	@Query("FROM Person person WHERE "
			+ "person.identity LIKE %:key% "
			+ "OR person.name LIKE %:key% "
			+ "ORDER By person.identity ASC,person.name ASC")
	public List<Person> findAll(Pageable pageable,@Param("key")String key);
	
	@Query("SELECT COUNT(person) FROM Person person WHERE "
			+ "person.identity LIKE %:key% "
			+ "OR person.name LIKE %:key% ")
	public Long count(@Param("key")String key);
}
