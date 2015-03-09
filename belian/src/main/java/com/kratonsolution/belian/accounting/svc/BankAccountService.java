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

import com.kratonsolution.belian.accounting.dm.BankAccount;
import com.kratonsolution.belian.accounting.dm.BankAccountRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BankAccountService
{
	@Autowired
	private BankAccountRepository repository;
	
	@Secured("ROLE_BANKACCOUNT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_BANKACCOUNT_READ")
	public BankAccount findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_BANKACCOUNT_READ")
	public List<BankAccount> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_BANKACCOUNT_READ")
	public List<BankAccount> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_BANKACCOUNT_CREATE")
	public void add(BankAccount bank)
	{
		bank.setId(UUID.randomUUID().toString());
		repository.save(bank);
	}
	
	@Secured("ROLE_BANKACCOUNT_UPDATE")
	public void edit(BankAccount bank)
	{
		repository.saveAndFlush(bank);
	}
	
	@Secured("ROLE_BANKACCOUNT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
