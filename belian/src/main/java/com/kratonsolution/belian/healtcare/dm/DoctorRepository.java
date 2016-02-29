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
public interface DoctorRepository extends JpaRepository<Doctor, String>
{
	@Query("FROM Doctor doc WHERE doc.from.id =:person")
	public List<Doctor> findAllByPerson(@Param("person")String person);
	
	@Query("FROM Doctor doc WHERE doc.to.id =:to ORDER BY doc.from.name ASC")
	public List<Doctor> findAll(Pageable pageable,@Param("to")String to);
	
	@Query("FROM Doctor doc WHERE doc.to.id =:to ORDER BY doc.from.name ASC")
	public List<Doctor> findAll(@Param("to")String to);
	
	@Query("SELECT COUNT(doc) FROM Doctor doc WHERE doc.to.id =:to")
	public Long count(@Param("to")String to);
	
	@Query("FROM Doctor doc WHERE doc.from.name LIKE :name% AND doc.to.id =:to ORDER BY doc.from.name ASC")
	public List<Doctor> findAll(@Param("name")String name,@Param("to")String to);

	@Query("FROM Doctor doc WHERE doc.from.id =:from AND doc.to.id =:to")
	public Doctor findOne(@Param("from")String from,@Param("to")String to);
	
	@Query("SELECT doc.from FROM Doctor doc WHERE doc.id =:id")
	public Person findPerson(@Param("id")String id);
}
