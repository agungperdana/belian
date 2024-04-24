package com.kratonsolution.belian.payments.svc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.svc.SalesInvoiceService;
import com.kratonsolution.belian.payments.dm.PaymentApplication;
import com.kratonsolution.belian.payments.dm.PaymentMethodInfo;
import com.kratonsolution.belian.payments.dm.Receipt;
import com.kratonsolution.belian.payments.dm.ReceiptRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ReceiptService extends AbstractService
{
	@Autowired
	private ReceiptRepository repository;
	
	@Autowired
	private SalesInvoiceService invoiceService;
	
	@Secured("ROLE_RECEIPT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_RECEIPT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size(String key)
	{
		if(utils.getOrganization() == null)
			return 0;
		
		if(Strings.isNullOrEmpty(key))
			return size();
		
		return repository.count(utils.getOrganization().getId(),key).intValue();
	}
	
	@Secured("ROLE_RECEIPT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Receipt findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_RECEIPT_READ")
	public List<Receipt> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_RECEIPT_READ")
	public List<Receipt> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_RECEIPT_READ")
	public List<Receipt> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);
		
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId(),key);
	}
	
	@Secured("ROLE_RECEIPT_CREATE")
	public void add(Receipt receipt)
	{
		receipt.setNumber(gen.generate(receipt.getEfectiveDate(),receipt.getReceiver().getId(),Code.RCT));
		repository.saveAndFlush(receipt);
		
		for(PaymentApplication application:receipt.getApplications())
			invoiceService.setPaidStatus(application.getInvoice().getId());
	}
	
	@Secured("ROLE_RECEIPT_UPDATE")
	public void edit(Receipt receipt)
	{
		repository.saveAndFlush(receipt);
	}
	
	@Secured("ROLE_RECEIPT_DELETE")
	public void delete(String id)
	{
		Receipt receipt = repository.findById(id).orElse(null);
		if(receipt != null)
		{
			for(PaymentApplication application:receipt.getApplications())
				invoiceService.setUnPaidStatus(application.getInvoice().getId());
			
			repository.delete(receipt);
		}
	}
	
	@Secured("ROLE_RECEIPT_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
	
	@Secured("ROLE_RECEIPT_CREATE")
	public Receipt fromInvoice(Invoice invoice,PaymentMethodInfo info)
	{
		Receipt receipt = new Receipt();
		receipt.setAmount(invoice.getSubtotal());
		receipt.setCommend("Cash Payment");
		receipt.setEfectiveDate(invoice.getDate());
		receipt.setMethod(info.getPaymentMethod());
		receipt.setReference(info.getReference());
		receipt.setPayer(invoice.getBilledToParty());
		receipt.setReceiver(invoice.getBilledFromParty());

		PaymentApplication application = new PaymentApplication();
		application.setAmount(invoice.getSubtotal());
		application.setInvoice(invoice.toInvoiceRef());
		application.setPayment(receipt);

		receipt.getApplications().add(application);

		add(receipt);
		
		return receipt;
	}
}
