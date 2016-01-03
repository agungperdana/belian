/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

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
public interface BillingRepository extends JpaRepository<Billing, String>
{
	public List<Billing> findAllByDateAndOrganizationIdAndPaid(Date date,String companyId,boolean paid);
	
	@Query("SELECT COUNT(billing) FROM Billing billing WHERE billing.date =:date AND billing.organization.id =:companyId AND billing.paid is false ORDER BY billing.number ASC")
	public Long getUnpaodCount(@Param("date")Date date,@Param("company")String companyId);
	
	public List<Billing> findAllByOrganizationId(Pageable pageable,String organization);
	
	@Query("SELECT COUNT(bill) FROM Billing bill WHERE bill.organization.id =:org")
	public Long count(String organizationId);
}
