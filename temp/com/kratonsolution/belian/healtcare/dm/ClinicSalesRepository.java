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
public interface ClinicSalesRepository extends JpaRepository<ClinicSales, String>
{
	@Query("FROM ClinicSales med WHERE "
			+ "(med.sales.identity LIKE %:key% "
			+ "OR med.sales.name LIKE %:key% "
			+ "OR med.customer.identity LIKE %:key% "
			+ "OR med.customer.name LIKE %:key%) "
			+ "AND med.organization.id IN(:company)"
			+ "ORDER BY med.date DESC")
	public List<ClinicSales> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(med) FROM ClinicSales med WHERE "
			+ "(med.sales.identity LIKE %:key% "
			+ "OR med.sales.name LIKE %:key% "
			+ "OR med.customer.identity LIKE %:key% "
			+ "OR med.customer.name LIKE %:key%) "
			+ "AND med.organization.id IN(:company)")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("FROM ClinicSales med WHERE med.organization.id IN(:company) ORDER BY med.date DESC")
	public List<ClinicSales> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("FROM ClinicSales med WHERE "
			+ "med.organization.id =:company "
			+ "AND med.date =:date "
			+ "AND med.paid IS true "
			+ "AND med.status != 'Finished' "
			+ "ORDER BY med.date DESC")
	public List<ClinicSales> findAllPaid(@Param("date")Date date,@Param("company")String company);
	
	@Query("FROM ClinicSales med WHERE "
			+ "med.organization.id =:company "
			+ "AND (med.date BETWEEN :start AND :end) "
			+ "AND med.paid IS true "
			+ "ORDER BY med.date DESC")
	public List<ClinicSales> findAllPaid(@Param("company")String company,@Param("start")Date start,@Param("end")Date end);
	
	@Query("SELECT COUNT(med) FROM ClinicSales med WHERE "
			+ "med.organization.id =:company "
			+ "AND med.date =:date "
			+ "AND med.paid IS true "
			+ "AND med.status != 'Finished' "
			+ "ORDER BY med.date DESC")
	public Long count(@Param("date")Date date,@Param("company")String company);
	
	@Query("SELECT COUNT(med) FROM ClinicSales med WHERE med.organization.id IN(:company)")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM ClinicSales med WHERE "
			+ "med.organization.id =:company AND "
			+ "med.status = 'Registered' AND "
			+ "med.status.paid IS true "
			+ "AND med.date =:date "
			+ "ORDER BY med.date DESC")
	public List<ClinicSales> findAllPaidRegistered(@Param("date")Date date,@Param("company")String company);
}
