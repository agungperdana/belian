/**
 * 
 */
package com.kratonsolution.belian.sales.srv;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;
import com.kratonsolution.belian.accounting.dm.JournalSettingRepository;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.DirectSalesRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DirectSalesService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private DirectSalesRepository repository;
	
	@Autowired
	private JournalSettingRepository journalRepository;
	
	@Autowired
	private InventoryItemRepository inventoryRepository;
	
	@Autowired
	private OrganizationAccountRepository accountRepository;

	@Autowired
	private AccountingPeriodRepository periodRepository;
	
	@Secured("ROLE_CASHSALES_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId());
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
		if(utils.getOrganization() == null)
			return new ArrayList<CashSales>();
		
		return repository.findAll(new PageRequest(pageIndex, pageSize,new Sort(new Order(Direction.DESC, "date"),new Order(Direction.ASC, "paid"))),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> loadAllUnpaid(int pageIndex,int pageSize)
	{
		return repository.loadAllUnpaid(new PageRequest(pageIndex, pageSize));
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
		/**
		out.setStatus(Status.PAID);
		
		repository.save(out);
		
		CashSalesPayment payment = new CashSalesPayment();
		payment.setAmount(out.getTotalBill());
		payment.setCashSales(out);
		payment.setType(PaymentType.CASH);
		
		JournalSetting setting = journalRepository.findOneByOrganizationId(out.getOrganization().getId());
		if(setting != null && setting.getCash() != null && setting.getSales() != null && setting.getPpnPayable() != null)
		{
			JournalEntry journal = new JournalEntry();
			journal.setCoa(accountRepository.findOneByOrganizationId(out.getOrganization().getId()));
			journal.setAuto(true);
			journal.setCurrency(out.getCurrency());
			journal.setDate(out.getDate());
			journal.setNote("Auto Posting CashSales["+out.getNumber()+"]");
			journal.setOwner(out.getOrganization());
			journal.setPeriod(periodRepository.findForDate(out.getDate()));
			journal.setCredit(out.getTotalBill());
			journal.setDebet(out.getTotalBill());
			journal.addDetail(JournalEntryDetail.DEBET(setting.getCash(), out.getTotalBill(), "Cash Account"));
			journal.addDetail(JournalEntryDetail.CREDIT(setting.getSales(), out.getBill(), "Sales Account"));
			
			if(out.getTaxAmount().compareTo(BigDecimal.ZERO) > 0)
				journal.addDetail(JournalEntryDetail.CREDIT(setting.getPpnPayable(), out.getTaxAmount(), "PPN Payable Account"));
	
			payment.setJournal(journal);
		}

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
		*
		*/

	}
	
	@Secured("ROLE_CASHSALES_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
