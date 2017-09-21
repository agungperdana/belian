/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface SimplePharmacyInvoiceRepository extends JpaRepository<SimplePharmacyInvoice, String>
{
	@Query("FROM SimplePharmacyInvoice clinic WHERE "
			+ "clinic.organization.id IN(:company) "
			+ "ORDER BY clinic.date DESC ")
	public List<SimplePharmacyInvoice> findAll(@Param("company")List<String> company);
	
	@Query("SELECT COUNT(clinic) FROM SimplePharmacyInvoice clinic WHERE "
			+ "clinic.organization.id IN(:company) "
			+ "ORDER BY clinic.date DESC ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM SimplePharmacyInvoice clinic WHERE "
			+ "clinic.organization.id IN(:company) "
			+ "ORDER BY clinic.date DESC ")
	public List<SimplePharmacyInvoice> findAll(Pageable pageable,@Param("company")List<String> company);
}
