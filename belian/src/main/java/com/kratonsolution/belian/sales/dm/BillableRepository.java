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
public interface BillableRepository extends JpaRepository<Billable, String>
{
	public List<Billable> findAllByDateAndOrganizationIdAndPaid(Date date,String companyId,boolean paid);
	
	@Query("SELECT COUNT(billing) FROM Billable billing WHERE billing.date =:date AND billing.organization.id =:companyId AND billing.paid is false ORDER BY billing.number ASC")
	public Long getUnpaodCount(@Param("date")Date date,@Param("company")String companyId);
	
	public List<Billable> findAllByOrganizationId(Pageable pageable,String organization);
	
	@Query("SELECT COUNT(bill) FROM Billable bill WHERE bill.organization.id =:org")
	public Long count(String organizationId);

	@Query("FROM Billable bil WHERE bil.date =:date AND bil.organization.id =:company AND (bil.number LIKE :key% OR bil.customer.name LIKE :key%) ORDER BY bil.number DESC")
	public List<Billable> findAll(@Param("date")Date date,@Param("company")String companyId,@Param("key")String key);
	
	public List<Billable> findAllByDateAndOrganizationId(Date date,String company);
	
	@Query("FROM Billable bil WHERE bil.organization.id =:company AND (bil.number LIKE :key% OR bil.customer.name LIKE :key%) ORDER BY bil.number DESC")
	public List<Billable> findAll(@Param("company")String companyId,@Param("key")String param);
	
	@Query("FROM Billable bil WHERE bil.organization.id =:company ORDER BY bil.number DESC")
	public List<Billable> findAll(String companyId);
}
