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

import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.accounting.dm.CashAccountRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CashAccountService
{
	@Autowired
	private CashAccountRepository repository;
	
	@Secured("ROLE_CASHACCOUNT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_CASHACCOUNT_READ")
	public CashAccount findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CASHACCOUNT_READ")
	public List<CashAccount> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CASHACCOUNT_READ")
	public List<CashAccount> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_CASHACCOUNT_READ")
	public CashAccount findOneByOwner(String ownerId)
	{
		return repository.findOne(ownerId);
	}
	
	
	@Secured("ROLE_CASHACCOUNT_CREATE")
	public void add(CashAccount cash)
	{
		cash.setId(UUID.randomUUID().toString());
		repository.save(cash);
	}
	
	@Secured("ROLE_CASHACCOUNT_UPDATE")
	public void edit(CashAccount cash)
	{
		repository.saveAndFlush(cash);
	}
	
	@Secured("ROLE_CASHACCOUNT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
