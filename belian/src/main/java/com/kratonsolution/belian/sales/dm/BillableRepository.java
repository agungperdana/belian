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
	
	@Query("FROM Billable bil WHERE bil.organization.id IN(:company) "
			+ "AND bil.date =:date "
			+ "AND bil.paid IS FALSE "
			+ "ORDER BY bil.number ASC")
	public List<Billable> forCashier(@Param("date")Date date,@Param("company")List<String> companyId);
	
	@Query("FROM Billable bil WHERE bil.organization.id IN(:company) "
			+ "AND bil.date =:date "
			+ "AND bil.paid IS FALSE "
			+ "AND (bil.number LIKE %:key% OR bil.customer.name LIKE %:key%)  "
			+ "ORDER BY bil.number ASC")
	public List<Billable> forCashier(@Param("date")Date date,@Param("company")List<String> companyId,@Param("key")String key);
	
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
	
	@Query("FROM Billable bil WHERE "
			+ "bil.organization.id =:company "
			+ "AND bil.date BETWEEN :start AND :end "
			+ "AND bil.sales.id =:sales "
			+ "ORDER BY bil.number DESC")
	public List<Billable> findAll(@Param("start")Date start,@Param("end")Date end,@Param("company")String company,@Param("sales")String sales);
	
	@Query("FROM Billable bil WHERE "
			+ "bil.organization.id =:company "
			+ "AND (bil.date BETWEEN :start AND :end) "
			+ "ORDER BY bil.date ASC,bil.number DESC")
	public List<Billable> findAll(@Param("start")Date start,@Param("end")Date end,@Param("company")String company);
	
	@Query("FROM Billable bil WHERE "
			+ "bil.organization.id =:company "
			+ "AND bil.paid IS TRUE "
			+ "AND (bil.date BETWEEN :start AND :end) "
			+ "ORDER BY bil.date ASC,bil.number DESC")
	public List<Billable> findAllPaid(@Param("start")Date start,@Param("end")Date end,@Param("company")String company);
	
	@Query("FROM Billable bil WHERE "
			+ "bil.organization.id =:company "
			+ "AND bil.sales.id =:sales "
			+ "ORDER BY bil.number DESC")
	public List<Billable> findAllBySales(@Param("company")String company,@Param("sales")String sales);
	
	@Query("FROM Billable bil WHERE "
			+ "bil.organization.id =:company "
			+ "ORDER BY bil.number DESC")
	public List<Billable> findAllByCompany(@Param("company")String company);
}
