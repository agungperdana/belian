/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

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
public interface VisitRepository extends JpaRepository<Visit, String>
{
	@Query("FROM Visit visit WHERE visit.organization.id =:company ORDER BY visit.date DESC ")
	public List<Visit> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(visit) FROM Visit visit WHERE visit.organization.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("FROM Visit visit WHERE visit.organization.id =:company "
			+ "AND (visit.doctor.value LIKE %:key% OR visit.patient.value LIKE %:key%) "
			+ "ORDER BY visit.date DESC  ")
	public List<Visit> findAll(Pageable pageable,@Param("company")String company,@Param("key")String key);
	
	@Query("SELECT COUNT(visit) FROM Visit visit WHERE visit.organization.id =:company "
			+ "AND (visit.doctor.value LIKE %:key% OR visit.patient.value LIKE %:key%) ")
	public Long count(@Param("company")String company,@Param("key")String key);
	
	@Query("FROM Visit visit WHERE visit.organization.id =:company AND visit.doctor.id =:doctor ORDER BY visit.date DESC ")
	public List<Visit> byPractitioner(@Param("company")String company,@Param("doctor")String doctor);
	
	@Query("FROM Visit visit WHERE "
			+ "visit.organization.id =:company "
			+ "AND visit.doctor.id =:doctor "
			+ "AND visit.date =:date "
			+ "ORDER BY visit.code ASC ")
	public List<Visit> findAllToday(@Param("company")String company,@Param("doctor")String doctor,@Param("date")Date date);
	
	@Query("FROM Visit visit WHERE "
			+ "visit.organization.id =:company "
			+ "AND visit.date =:date "
			+ "ORDER BY visit.code ASC ")
	public List<Visit> findAllToday(@Param("company")String company,@Param("date")Date date);
}
