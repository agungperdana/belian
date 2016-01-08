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
import com.kratonsolution.belian.common.SessionUtils;
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
	
	@Autowired
	private SessionUtils utils;
	
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
		List<Billing> list = new ArrayList<Billing>();
	
		if(utils.getOrganization() != null)
			list.addAll(repository.findAllByOrganizationId(new PageRequest(pageindex, itemSize),utils.getOrganization().getId()));
			
		return list;
	}
	
	@Secured("ROLE_BILLING_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Billing> findAllByDateAndOrganizationIdAndPaid(Date date,String companyId,boolean paid)
	{
		return repository.findAllByDateAndOrganizationIdAndPaid(date, companyId, paid);
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
	
	@Secured("ROLE_BILLING_DELETE")
	public void delete(Billing module)
	{
		if(module != null)
			repository.delete(module);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_BILLING_READ")
	public List<Billing> findAllCurrent(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return repository.findAllByDateAndOrganizationId(new Date(System.currentTimeMillis()),utils.getOrganization().getId());
		else
			return repository.findAll(new Date(System.currentTimeMillis()),utils.getOrganization().getId(),key);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_BILLING_READ")
	public List<Billing> findAll(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return repository.findAll(utils.getOrganization().getId());
		else
			return repository.findAll(utils.getOrganization().getId(),key);
	}
}
