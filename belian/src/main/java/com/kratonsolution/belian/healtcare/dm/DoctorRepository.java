/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DoctorRepository extends JpaRepository<Doctor, String>
{
	@Query("FROM Doctor doc WHERE doc.party.id =:person")
	public List<Doctor> findAllByPerson(@Param("person")String person);
	
	@Query("FROM Doctor doc WHERE doc.party.id =:to ORDER BY doc.party.name ASC")
	public List<Doctor> findAll(Pageable pageable,@Param("to")String to);
	
	@Query("FROM Doctor doc WHERE doc.party.id =:to ORDER BY doc.party.name ASC")
	public List<Doctor> findAll(@Param("to")String to);
	
	@Query("SELECT COUNT(doc) FROM Doctor doc WHERE doc.party.id =:to")
	public Long count(@Param("to")String to);
	
	@Query("FROM Doctor doc WHERE doc.party.name LIKE :name% AND doc.party.id =:to ORDER BY doc.party.name ASC")
	public List<Doctor> findAll(@Param("name")String name,@Param("to")String to);

	@Query("FROM Doctor doc WHERE doc.party.id =:from AND doc.party.id =:to")
	public Doctor findOne(@Param("from")String from,@Param("to")String to);
	
	@Query("FROM Doctor doc WHERE "
		  + "doc.party.id =:person "
		  + "AND ((:date BETWEEN doc.start AND doc.end) OR (doc.start <= :date AND doc.end IS NULL))")
	public Doctor findOne(@Param("person")String person,@Param("date")Date date);
}
