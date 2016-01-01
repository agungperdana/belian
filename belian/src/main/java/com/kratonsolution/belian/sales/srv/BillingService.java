/**
 * 
 */
package com.kratonsolution.belian.sales.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.sales.dm.Billing;
import com.kratonsolution.belian.sales.dm.BillingRepository;

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
	private BillingRepository repository;
	
	@Secured("ROLE_BILLING_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Billing findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_BILLING_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Billing> findAll()
	{
		return repository.findAll(new Sort(Sort.Direction.ASC,"code"));
	}
	
	@Secured("ROLE_BILLING_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Billing> findAll(int pageindex,int itemSize)
	{
		return repository.findAll(new PageRequest(pageindex, itemSize)).getContent();
	}
	
	@Secured("ROLE_BILLING_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_BILLING_CREATE")
	public void add(Billing module)
	{
		repository.save(module);
	}
	
	@Secured("ROLE_BILLING_UPDATE")
	public void edit(Billing module)
	{
		repository.save(module);
	}
	
	@Secured("ROLE_BILLING_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
