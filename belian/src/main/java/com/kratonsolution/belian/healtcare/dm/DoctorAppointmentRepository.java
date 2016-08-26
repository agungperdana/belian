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
public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, String>
{
	@Query("FROM DoctorAppointment app WHERE "
			+ "app.date =:date "
			+ "AND app.company.id =:company "
			+ "AND app.doctor.doctor.party.id =:doctor "
			+ "AND (app.status != 'CANCELED' "
			+ "AND app.status != 'DONE') "
			+ "ORDER BY app.queue ASC")
	public List<DoctorAppointment> findAllTodayByDoctor(@Param("date")Date date,@Param("company")String companyId,@Param("doctor")String person);

	@Query("FROM DoctorAppointment app WHERE "
			+ "app.date =:date "
			+ "AND app.patient.party.name LIKE :customer% "
			+ "AND app.company.id =:company "
			+ "AND app.doctor.doctor.party.id =:doctor "
			+ "AND (app.status != 'CANCELED' AND app.status != 'DONE') "
			+ "ORDER BY app.queue ASC")
	public List<DoctorAppointment> findAll(@Param("date")Date date,@Param("company")String companyId,@Param("doctor")String doctorId,@Param("customer")String customer);
	
	@Query("FROM DoctorAppointment app WHERE "
			+ "app.company.id IN(:company) "
			+ "ORDER BY app.date DESC")
	public List<DoctorAppointment> findAll(Pageable pageable,@Param("company")List<String> companyId);
	
	@Query("SELECT COUNT(app) FROM DoctorAppointment app WHERE "
			+ "app.company.id IN(:company)")
	public Long count(@Param("company")List<String> companyId);
}
