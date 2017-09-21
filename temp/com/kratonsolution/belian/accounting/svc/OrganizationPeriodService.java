/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.OrganizationPeriod;
import com.kratonsolution.belian.accounting.dm.OrganizationPeriodRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationPeriodService
{
	@Autowired
	private OrganizationPeriodRepository repository;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public OrganizationPeriod findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public OrganizationPeriod findOne(String company,String period)
	{
		return repository.findOne(company,period);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public List<OrganizationPeriod> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public List<OrganizationPeriod> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_CREATE")
	public void add(OrganizationPeriod period)
	{
		period.setId(UUID.randomUUID().toString());
		repository.save(period);
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_UPDATE")
	public void edit(OrganizationPeriod period)
	{
		repository.saveAndFlush(period);
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_UPDATE")
	public void close(OrganizationPeriod period)
	{
		period.setClosed(true);
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_UPDATE")
	public void open(OrganizationPeriod period)
	{
		period.setClosed(false);
	}
}
