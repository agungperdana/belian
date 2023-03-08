/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface VisitStatusRepository extends JpaRepository<VisitStatus, String>
{
	@Query("FROM VisitStatus status WHERE "
			+ "status.visit.organization.id =:company "
			+ "AND status.visit.date =:date "
			+ "AND status.visit.doctor.id =:doctor "
			+ "ORDER BY status.date ASC ")
	public List<VisitStatus> findAll(@Param("date")Date date,@Param("company")String company,@Param("doctor")String doctor);
	
	@Query("FROM VisitStatus status WHERE "
			+ "status.visit.organization.id =:company "
			+ "AND status.visit.date =:date "
			+ "ORDER BY status.date ASC ")
	public List<VisitStatus> findAll(@Param("date")Date date,@Param("company")String company);
}
