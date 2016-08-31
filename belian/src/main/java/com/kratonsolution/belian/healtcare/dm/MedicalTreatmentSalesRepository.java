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
public interface MedicalTreatmentSalesRepository extends JpaRepository<MedicalTreatmentSales, String>
{
	@Query("FROM MedicalTreatmentSales sales WHERE "
			+ "sales.organization.id =:company "
			+ "AND sales.sales.id =:doctor "
			+ "AND (sales.date BETWEEN :start AND :end) "
			+ "ORDER BY sales.date DESC,sales.customer.name ASC ")
	public List<MedicalTreatmentSales> findAll(@Param("company")String company,
											   @Param("doctor")String doctor,
											   @Param("start")Date start,
											   @Param("end")Date end);
}
