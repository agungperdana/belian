/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

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
	
	@Query("FROM Person p WHERE p.user IS NULL ORDER BY p.name ASC")
	public List<Person> findAllWhereUserIsNull();
	
	@Query("FROM Person person WHERE person.identity LIKE :identity%")
	public List<Person> findAllByIdentity(@Param("identity")String identity);
}
