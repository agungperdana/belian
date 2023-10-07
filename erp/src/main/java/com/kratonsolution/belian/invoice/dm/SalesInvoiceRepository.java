
package com.kratonsolution.belian.invoice.dm;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, String>
{
	@Query("SELECT DISTINCT inv FROM SalesInvoice inv INNER JOIN inv.statuses stat WHERE "
			+ "inv.billedFromParty.id =:company "
			+ "AND inv.billedToParty.id =:customer "
//			+ "AND stat.type NOT IN('PAID','VOID') "
			+ "ORDER BY inv.date DESC ")
	public List<SalesInvoice> findAllUnpaid(@Param("company")String company,@Param("customer")String customer);
	
	@Query("SELECT DISTINCT inv FROM SalesInvoice inv INNER JOIN inv.statuses stat WHERE "
			+ "inv.billedFromParty.id =:company "
			+ "AND inv.billedToParty.id =:customer "
//			+ "AND stat.type NOT IN('PAID','VOID') "
			+ "AND inv.number LIKE :key "
			+ "ORDER BY inv.date DESC ")
	public List<SalesInvoice> findAllUnpaid(@Param("company")String company,@Param("customer")String customer,@Param("key")String key);
	
	@Query("FROM SalesInvoice inv WHERE "
			+ "inv.billedFromParty.id =:company "
			+ "AND inv.date BETWEEN :start AND :end "
			+ "AND inv.billedToParty.id =:customer "
			+ "ORDER BY inv.date DESC ")
	public List<SalesInvoice> findAll(@Param("company")String company,@Param("customer")String customer,@Param("start")Date from,@Param("end")Date to);
	
	@Query("FROM SalesInvoice inv WHERE "
			+ "inv.billedFromParty.id =:company "
			+ "ORDER BY inv.date DESC ")
	public List<SalesInvoice> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(inv) FROM SalesInvoice inv WHERE "
			+ "inv.billedFromParty.id =:company ")
	public Long count(@Param("company")String company);
	
	@Query("FROM SalesInvoice inv WHERE "
			+ "inv.billedFromParty.id =:company "
			+ "AND inv.number LIKE :key "
			+ "ORDER BY inv.date DESC ")
	public List<SalesInvoice> findAll(Pageable pageable,@Param("company")String company,@Param("key")String key);
	
	@Query("SELECT COUNT(inv) FROM SalesInvoice inv WHERE "
			+ "inv.billedFromParty.id =:company "
			+ "AND inv.number LIKE :key ")
	public Long count(@Param("company")String company,@Param("key")String key);

	@Query("SELECT DISTINCT item.invoice FROM InvoiceItem item WHERE item.id IN(:ids) ")
	public SalesInvoice getOne(@Param("ids")Collection<String> ids);
}
