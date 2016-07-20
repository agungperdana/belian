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
import com.kratonsolution.belian.payment.dm.Receipt;
import com.kratonsolution.belian.payment.dm.ReceiptRepository;
import com.kratonsolution.belian.sales.dm.BillableRepository;
import com.kratonsolution.belian.sales.dm.PaymentApplication;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ReceiptService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private ReceiptRepository repository;
	
	@Autowired
	private BillableRepository billRepo;
		
	@Secured({"ROLE_RECEIPT_READ","ROLE_SYSTEM_READ"})
	public Receipt findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_RECEIPT_READ","ROLE_SYSTEM_READ"})
	public List<Receipt> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_RECEIPT_READ"})
	public int getSize()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Secured({"ROLE_RECEIPT_READ"})
	public int getSize(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return getSize();
		
		return repository.count(utils.getOrganizationIds(),key).intValue();
	}
	
	@Secured("ROLE_RECEIPT_CREATE")
	public void add(Receipt receipt)
	{
		if(utils.isSysAdmin())
			receipt.setStaff(null);
			
		repository.save(receipt);
		
		for(PaymentApplication application:receipt.getBillings())
		{
			application.getBillable().setPaid(true);
			billRepo.saveAndFlush(application.getBillable());
		}
	}
	
	@Secured("ROLE_RECEIPT_UPDATE")
	public void edit(Receipt receipt)
	{
		repository.saveAndFlush(receipt);
	}
	
	@Secured("ROLE_RECEIPT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_RECEIPT_READ")
	public List<Receipt> findAll(int pageIndex,int itemsSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganizationIds());
	}
	
	@Secured("ROLE_RECEIPT_READ")
	public List<Receipt> findAll(int pageIndex,int itemsSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, itemsSize);
		
		return repository.findAll(new PageRequest(pageIndex, itemsSize),utils.getOrganizationIds(),key);
	}
}
