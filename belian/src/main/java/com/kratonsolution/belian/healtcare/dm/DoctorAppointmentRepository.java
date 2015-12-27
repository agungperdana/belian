/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, String>
{
	@Query("FROM DoctorAppointment app WHERE app.date =:date AND app.company.id =:company AND app.doctor.party.id =:doctor AND (app.status != 'CANCELED' AND app.status != 'DONE') ORDER BY app.queue ASC")
	public List<DoctorAppointment> findAllTodayByDoctor(@Param("date")Date date,@Param("company")String companyId,@Param("doctor")String doctorId);
}
