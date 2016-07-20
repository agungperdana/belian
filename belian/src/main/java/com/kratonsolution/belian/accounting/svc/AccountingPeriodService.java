/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AccountingPeriodService
{
	@Autowired
	private AccountingPeriodRepository repository;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public AccountingPeriod findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public List<AccountingPeriod> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public List<AccountingPeriod> findAllRoot()
	{
		return repository.findAllByParentIsNull();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public List<AccountingPeriod> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public AccountingPeriod findForDate(Date date)
	{
		return repository.findForDate(date);
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_CREATE")
	public void add(AccountingPeriod period)
	{
		period.setId(UUID.randomUUID().toString());
		repository.save(period);
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_UPDATE")
	public void edit(AccountingPeriod period)
	{
		repository.saveAndFlush(period);
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
