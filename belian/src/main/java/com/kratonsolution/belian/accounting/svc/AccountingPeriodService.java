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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AccountingPeriodService
{
	@Autowired
	private AccountingPeriodRepository repository;
	
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public AccountingPeriod findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public List<AccountingPeriod> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public List<AccountingPeriod> findAllRoot()
	{
		return repository.findAllByParentIsNull();
	}
	
	@Secured("ROLE_ACCOUNTINGPERIOD_READ")
	public List<AccountingPeriod> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
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
