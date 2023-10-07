
package com.kratonsolution.belian.invoice.dm;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, String>
{
	@Query("SELECT DISTINCT inv FROM PurchaseInvoice inv INNER JOIN inv.statuses stat WHERE "
			+ "inv.billedFromParty.id =:supplier "
			+ "AND inv.billedToParty.id =:company "
//			+ "AND stat.type NOT IN('PAID','VOID') "
			+ "ORDER BY inv.date DESC ")
	public List<PurchaseInvoice> findAllUnpaid(@Param("company")String company,@Param("supplier")String supplier);
	
	@Query("SELECT DISTINCT inv FROM PurchaseInvoice inv INNER JOIN inv.statuses stat WHERE "
			+ "inv.billedFromParty.id =:supplier "
			+ "AND inv.billedToParty.id =:company "
//			+ "AND stat.type NOT IN('PAID','VOID') "
			+ "AND inv.number LIKE :key "
			+ "ORDER BY inv.date DESC ")
	public List<PurchaseInvoice> findAllUnpaid(@Param("company")String company,@Param("supplier")String supplier,@Param("key")String key);
	
	@Query("FROM PurchaseInvoice inv WHERE "
			+ "inv.billedToParty.id =:company "
			+ "ORDER BY inv.date DESC ")
	public List<PurchaseInvoice> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(inv) FROM PurchaseInvoice inv WHERE "
			+ "inv.billedToParty.id =:company ")
	public Long count(@Param("company")String company);
	
	@Query("FROM PurchaseInvoice inv WHERE "
			+ "inv.billedToParty.id =:company "
			+ "AND inv.number LIKE :key "
			+ "ORDER BY inv.date DESC ")
	public List<PurchaseInvoice> findAll(Pageable pageable,@Param("company")String company,@Param("key")String key);
	
	@Query("SELECT COUNT(inv) FROM PurchaseInvoice inv WHERE "
			+ "inv.billedToParty.id =:company "
			+ "AND inv.number LIKE :key ")
	public Long count(@Param("company")String company,@Param("key")String key);

	@Query("SELECT DISTINCT item.invoice FROM InvoiceItem item WHERE item.id IN(:ids) ")
	public PurchaseInvoice getOne(@Param("ids")Collection<String> ids);
}
