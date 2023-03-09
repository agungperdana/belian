
package com.kratonsolution.belian.payments.svc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.svc.PurchaseInvoiceService;
import com.kratonsolution.belian.payments.dm.Disbursement;
import com.kratonsolution.belian.payments.dm.DisbursementRepository;
import com.kratonsolution.belian.payments.dm.PaymentApplication;
import com.kratonsolution.belian.payments.dm.PaymentMethodType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DisbursementService extends AbstractService
{
	@Autowired
	private DisbursementRepository repository;
	
	@Autowired
	private PurchaseInvoiceService invoiceService;
	
	@Secured("ROLE_DISBURSEMENT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_DISBURSEMENT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size(String key)
	{
		if(utils.getOrganization() == null)
			return 0;
		
		if(Strings.isNullOrEmpty(key))
			return size();
		
		return repository.count(utils.getOrganization().getId(),key).intValue();
	}
	
	@Secured("ROLE_DISBURSEMENT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Disbursement getOne(String id)
	{
		return repository.getOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DISBURSEMENT_READ")
	public List<Disbursement> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DISBURSEMENT_READ")
	public List<Disbursement> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DISBURSEMENT_READ")
	public List<Disbursement> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);
		
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId(),key);
	}
	
	@Secured("ROLE_DISBURSEMENT_CREATE")
	public void add(Disbursement disbursement)
	{
		disbursement.setNumber(gen.generate(disbursement.getEfectiveDate(),disbursement.getPayer().getId(),Code.DMT));
		repository.save(disbursement);
		
		for(PaymentApplication application:disbursement.getApplications())
			invoiceService.setPaidStatus(application.getInvoice().getId());
	}
	
	@Secured("ROLE_DISBURSEMENT_UPDATE")
	public void edit(Disbursement disbursement)
	{
		repository.saveAndFlush(disbursement);
	}
	
	@Secured("ROLE_DISBURSEMENT_DELETE")
	public void delete(String id)
	{
		Disbursement disbursement = repository.getOne(id);
		if(disbursement != null)
		{
			for(PaymentApplication application:disbursement.getApplications())
				invoiceService.setUnPaidStatus(application.getInvoice().getId());
			
			repository.delete(disbursement);
		}
	}
	
	@Secured("ROLE_DISBURSEMENT_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
	
	@Secured("ROLE_DISBURSEMENT_CREATE")
	public void fromInvoice(Invoice invoice)
	{
		if(invoice != null)
		{
			Disbursement disbursement = new Disbursement();
			disbursement.setAmount(invoice.getSubtotal());
			disbursement.setEfectiveDate(invoice.getDate());
			disbursement.setCommend("Auto generated from invoice");
			disbursement.setMethod(PaymentMethodType.CASH);
			disbursement.setPayer(invoice.getBilledToParty());
			disbursement.setReceiver(invoice.getBilledFromParty());
			
			PaymentApplication application = new PaymentApplication();
			application.setAmount(invoice.getSubtotal());
			application.setInvoice(invoice.toInvoiceRef());
			application.setPayment(disbursement);

			disbursement.getApplications().add(application);
			
			add(disbursement);
		}
	}
}
