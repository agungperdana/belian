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
public interface MedicalSalesRepository extends JpaRepository<MedicalSales, String>
{
	@Query("FROM MedicalSales med WHERE med.organization.id =:company ORDER BY med.date DESC")
	public List<MedicalSales> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("FROM MedicalSales med WHERE "
			+ "med.organization.id =:company "
			+ "AND med.date =:date "
			+ "AND med.paid IS true "
			+ "AND med.status != 'Finished' "
			+ "ORDER BY med.date ASC,med.time ASC")
	public List<MedicalSales> findAllPaid(@Param("date")Date date,@Param("company")String company);
	
	@Query("SELECT COUNT(med) FROM MedicalSales med WHERE "
			+ "med.organization.id =:company "
			+ "AND med.date =:date "
			+ "AND med.paid IS true "
			+ "AND med.status != 'Finished' "
			+ "ORDER BY med.date DESC")
	public Long count(@Param("date")Date date,@Param("company")String company);
	
	@Query("SELECT COUNT(med) FROM MedicalSales med WHERE med.organization.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("FROM MedicalSales med WHERE "
			+ "med.organization.id =:company AND "
			+ "med.status = 'Registered' AND "
			+ "med.status.paid IS true "
			+ "AND med.date =:date "
			+ "ORDER BY med.date ASC,med.time ASC")
	public List<MedicalSales> findAllPaidRegistered(@Param("date")Date date,@Param("company")String company);
}
