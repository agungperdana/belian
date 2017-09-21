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
public interface PharmacySalesRepository extends JpaRepository<PharmacySales, String>
{
	@Query("FROM PharmacySales med WHERE med.organization.id IN(:company) ORDER BY med.date DESC")
	public List<PharmacySales> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("FROM PharmacySales med WHERE "
			+ "med.organization.id IN(:company) "
			+ "AND med.date =:date "
			+ "AND med.paid IS true "
			+ "AND med.status != 'Finished' "
			+ "ORDER BY med.date DESC")
	public List<PharmacySales> findAllPaid(@Param("date")Date date,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(med) FROM PharmacySales med WHERE "
			+ "med.organization.id IN(:company) "
			+ "AND med.date =:date "
			+ "AND med.paid IS true "
			+ "AND med.status != 'Finished' "
			+ "ORDER BY med.date DESC")
	public Long count(@Param("date")Date date,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(med) FROM PharmacySales med WHERE med.organization.id IN(:company)")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM PharmacySales med WHERE "
			+ "med.organization.id IN(:company) AND "
			+ "med.status = 'Registered' AND "
			+ "med.status.paid IS true "
			+ "AND med.date =:date "
			+ "ORDER BY med.date DESC")
	public List<PharmacySales> findAllPaidRegistered(@Param("date")Date date,@Param("company")List<String> company);
}
