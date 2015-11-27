/**
 * 
 */
package com.kratonsolution.belian.sales.srv;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.JournalSetting;
import com.kratonsolution.belian.accounting.dm.JournalSettingRepository;
import com.kratonsolution.belian.global.dm.EconomicEventType;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.sales.dm.CashEvent;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSales.Status;
import com.kratonsolution.belian.sales.dm.CashSalesLine;
import com.kratonsolution.belian.sales.dm.CashSalesPayment;
import com.kratonsolution.belian.sales.dm.CashSalesRepository;
import com.kratonsolution.belian.sales.dm.PaymentType;
import com.kratonsolution.belian.sales.dm.SaleEvent;
import com.kratonsolution.belian.sales.dm.TaxEvent;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CashSalesService
{
	@Autowired
	private CashSalesRepository repository;
	
	@Autowired
	private JournalSettingRepository journalRepository;
	
	@Autowired
	private InventoryItemRepository inventoryRepository;
	
	@Secured("ROLE_CASHSALES_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public int count(@Param("companys")List<String> companys)
	{
		return repository.count(companys);
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public CashSales findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> loadAllUnpaid(int pageIndex,int pageSize)
	{
		return repository.loadAllUnpaid(new PageRequest(pageIndex, pageSize));
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> loadAllOrderByStatus(int pageIndex,int pageSize,List<String> companys)
	{
		return repository.loadAllOrderByStatus(new PageRequest(pageIndex, pageSize),companys);
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> findAllByDate(Date date,List<String> companys)
	{
		return repository.findAllByDate(date,companys);
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> findAllByDateBetween(Date start,Date end,List<String> companys)
	{
		return repository.findAllByDateBetween(start,end,companys);
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	public void add(CashSales sales)
	{
		for(CashSalesLine line:sales.getDecrements())
		{
			SaleEvent sale = new SaleEvent();
			sale.setName("Stok out from sale event.");
			sale.setAmount(line.getQuantity());
			sale.setCustomer(line.getCashSales().getConsumer());
			sale.setDate(new Date(line.getCashSales().getDate().getTime()));
			sale.setProduct(line.getProduct());
			sale.setType(EconomicEventType.GIVE);
			sale.setSalesPerson(line.getCashSales().getProducer());

			line.setEvent(sale);
		}
		
		repository.save(sales);
	}
	
	@Secured("ROLE_CASHSALES_UPDATE")
	public void edit(CashSales sales)
	{
		repository.saveAndFlush(sales);
	}
	
	@Secured("ROLE_CASHSALES_UPDATE")
	public void addPayment(CashSales out)
	{
		out.setStatus(Status.PAID);
		
		repository.save(out);
		
		CashSalesPayment payment = new CashSalesPayment();
		payment.setAmount(out.getTotalBill());
		payment.setCashSales(out);
		payment.setType(PaymentType.CASH);
		
		JournalSetting journalSetting = journalRepository.findOneByOrganizationId(out.getOrganization().getId());
		if(journalSetting != null && journalSetting.getCashSales() != null && journalSetting.getTax() != null)
		{
			CashEvent cashEvent = new CashEvent();
			cashEvent.setName(journalSetting.getCashSales().getName());
			cashEvent.setAmount(out.getBill());
			cashEvent.setCashAccount(journalSetting.getCashSales());
			cashEvent.setCashier(out.getProducer());
			cashEvent.setCustomer(out.getConsumer());
			cashEvent.setType(EconomicEventType.GET);
			cashEvent.setDate(new Date(out.getDate().getTime()));
			cashEvent.setCurrency(out.getCurrency());
			
			TaxEvent taxEvent = new TaxEvent();
			taxEvent.setName(journalSetting.getTax().getName());
			taxEvent.setAmount(out.getTaxAmount());
			taxEvent.setTaxAccount(journalSetting.getTax());
			taxEvent.setCashier(out.getProducer());
			taxEvent.setCustomer(out.getConsumer());
			taxEvent.setType(EconomicEventType.GET);
			taxEvent.setDate(new Date(out.getDate().getTime()));
			taxEvent.setCurrency(out.getCurrency());
			
			payment.setCashEvent(cashEvent);
			payment.setTaxEvent(taxEvent);
		}
		
		out.getIncrements().add(payment);
		
		repository.save(out);
	}
	
	@Secured("ROLE_CASHSALES_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
