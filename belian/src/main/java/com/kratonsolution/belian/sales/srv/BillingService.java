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
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.payment.dm.ReceiptRepository;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.dm.BillableRepository;
import com.kratonsolution.belian.sales.dm.PaymentApplication;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BillingService
{
	@Autowired
	private Language lang;
	
	@Autowired
	private BillableRepository repository;
	
	@Autowired
	private CashierShiftService cashierShiftService;
	
	@Autowired
	private ReceiptRepository receiptRepo;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Billable findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Billable> findAll()
	{
		return repository.findAll(new Sort(Sort.Direction.ASC,"code"));
	}
	
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Billable> findAll(int pageindex,int itemSize)
	{
		List<Billable> list = new ArrayList<Billable>();
	
		if(utils.getOrganization() != null)
			list.addAll(repository.findAllByOrganizationId(new PageRequest(pageindex, itemSize),utils.getOrganization().getId()));
			
		return list;
	}
	
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Billable> findAllByDateAndOrganizationIdAndPaid(Date date,String companyId,boolean paid)
	{
		return repository.findAllByDateAndOrganizationIdAndPaid(date, companyId, paid);
	}
	
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Billable> forCashier()
	{
		if(cashierShiftService.findToday() != null)
			return repository.forCashier(DateTimes.currentDate(), utils.getOrganizationIds());
		
		return new ArrayList<>();
	}
	
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Billable> forCashier(String key)
	{
		if(cashierShiftService.findToday() != null)
			return repository.forCashier(DateTimes.currentDate(), utils.getOrganizationIds(),key);
	
		return new ArrayList<>();
	}
	
	@Secured("ROLE_BILLING_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;

		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_BILLING_READ")
	public int unpaidSize(Date date,String companyId)
	{
		return repository.getUnpaodCount(date, companyId).intValue();
	}
	
	@Secured("ROLE_BILLING_CREATE")
	public void add(Billable billing)
	{
		repository.save(billing);
	}
	
	@Secured({"ROLE_BILLING_UPDATE","ROLE_CASHIER_UPDATE"})
	public void edit(Billable billing)
	{
		repository.save(billing);
	}
	
	@Secured({"ROLE_BILLING_UPDATE","ROLE_CASHIER_UPDATE"})
	public void paid(Billable billing)
	{
		if(!billing.match())
			throw new RuntimeException(lang.get("cashier.message.notmatch"));
		
		for(PaymentApplication application:billing.getReceipts())
			receiptRepo.save(application.getReceipt());
		
		billing.setPaid(true);

		repository.saveAndFlush(billing);
	}
	
	@Secured("ROLE_BILLING_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_BILLING_DELETE")
	public void delete(Billable billing)
	{
		if(billing != null)
			repository.delete(billing);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	public List<Billable> findAllCurrent(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return forCashier();
		else
			return forCashier(key);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	public List<Billable> findAll(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return repository.findAll(utils.getOrganization().getId());
		else
			return repository.findAll(utils.getOrganization().getId(),key);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_BILLING_READ","ROLE_CASHIER_READ"})
	public List<Billable> findAllUnpaid(String company,String person)
	{
		return repository.findAllUnpaid(company, person);
	}
}
