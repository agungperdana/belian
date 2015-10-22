/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PersonRepository extends JpaRepository<Person, String>
{
	public Person findOneByName(String name);
		
	public List<Person> findAllByNameNot(String name);
	
	@Query("FROM Person p WHERE p.user IS NULL ORDER BY p.name ASC")
	public List<Person> findAllWhereUserIsNull();
}
