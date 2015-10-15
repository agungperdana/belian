/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface PersonRepository extends JpaRepository<Person, String>
{
	public Person findOneByName(String name);
	
	public List<Person> findAllByRolesType(PartyRole.Type type);
	
	public List<Person> findAllByNameNot(String name);
	
	public List<Person> findAllByUserIsNull();
}
