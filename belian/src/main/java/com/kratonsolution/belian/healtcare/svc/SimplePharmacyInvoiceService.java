/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.SimplePharmacyInvoice;
import com.kratonsolution.belian.healtcare.dm.SimplePharmacyInvoiceRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SimplePharmacyInvoiceService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private SimplePharmacyInvoiceRepository repository;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_SIMPLE_PHARMACY_INVOICE_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Secured("ROLE_SIMPLE_PHARMACY_INVOICE_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public SimplePharmacyInvoice findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_SIMPLE_PHARMACY_INVOICE_READ")
	public List<SimplePharmacyInvoice> findAll()
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<SimplePharmacyInvoice>();

		return repository.findAll(utils.getOrganizationIds());
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_SIMPLE_PHARMACY_INVOICE_READ")
	public List<SimplePharmacyInvoice> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<SimplePharmacyInvoice>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Secured("ROLE_SIMPLE_PHARMACY_INVOICE_CREATE")
	public void add(SimplePharmacyInvoice invoice)
	{
		repository.save(invoice);
	}
	
	@Secured("ROLE_SIMPLE_PHARMACY_INVOICE_UPDATE")
	public void edit(SimplePharmacyInvoice invoice)
	{
		repository.saveAndFlush(invoice);
	}
	
	@Secured("ROLE_SIMPLE_PHARMACY_INVOICE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
