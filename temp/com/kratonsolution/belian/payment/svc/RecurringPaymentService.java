/**
 * 
 */
package com.kratonsolution.belian.payment.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.payment.dm.RecurringPayment;
import com.kratonsolution.belian.payment.dm.RecurringPaymentRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RecurringPaymentService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private RecurringPaymentRepository repository;
		
	@Secured({"ROLE_RECURRING_PAYMENT_READ","ROLE_SYSTEM_READ"})
	public RecurringPayment findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_RECURRING_PAYMENT_READ","ROLE_SYSTEM_READ"})
	public List<RecurringPayment> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_RECURRING_PAYMENT_READ"})
	public int getSize()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Secured({"ROLE_RECURRING_PAYMENT_READ"})
	public int getSize(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return getSize();
		
		return repository.count(utils.getOrganizationIds(),key).intValue();
	}
	
	@Secured("ROLE_RECURRING_PAYMENT_CREATE")
	public void add(RecurringPayment payment)
	{
//		if(utils.isSysAdmin())
//			payment.setStaff(null);
			
		repository.save(payment);
	}
	
	@Secured("ROLE_RECURRING_PAYMENT_UPDATE")
	public void edit(RecurringPayment payment)
	{
		repository.saveAndFlush(payment);
	}
	
	@Secured("ROLE_RECURRING_PAYMENT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_RECURRING_PAYMENT_READ")
	public List<RecurringPayment> findAll(int pageIndex,int itemsSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganizationIds());
	}
	
	@Secured("ROLE_RECURRING_PAYMENT_READ")
	public List<RecurringPayment> findAll(int pageIndex,int itemsSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, itemsSize);
		
		return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganizationIds(),key);
	}
}
