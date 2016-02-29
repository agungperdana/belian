/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.general.dm.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PatientRepository extends JpaRepository<Patient, String>
{
	public Patient findOneByBpjsCard(String bpjsCardNumber);
	
	@Query("FROM Patient pat WHERE pat.from.id =:person AND pat.to.id =:to")
	public Patient findOne(@Param("person")String person,@Param("to")String to);

	@Query("FROM Patient pat WHERE pat.to.id =:to ORDER BY pat.from.name")
	public List<Patient> findAll(Pageable pageable,@Param("to")String to);
	
	@Query("FROM Patient pat WHERE pat.to.id =:to ORDER BY pat.from.name")
	public List<Patient> findAll(@Param("to")String to);
	
	@Query("SELECT COUNT(pat) FROM Patient pat WHERE pat.to.id =:to")
	public Long count(@Param("to")String to);
	
	@Query("FROM Patient pat WHERE pat.from.name LIKE :name% AND pat.to.id =:to ORDER BY pat.from.name ASC")
	public List<Patient> findAll(@Param("name")String name,@Param("to")String to);

	public Patient findOneByFromNameAndToId(String name,String to);
	
	@Query("SELECT pat.from FROM Patient pat WHERE pat.id =:id")
	public Person findPerson(@Param("id")String id);
}