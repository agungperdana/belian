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

import com.kratonsolution.belian.accounting.dm.AccountingSettingAccount;
import com.kratonsolution.belian.accounting.dm.AccountingSettingAccountRepository;
import com.kratonsolution.belian.accounting.dm.AccountingSettingType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AccountingSettingAccountService
{
	@Autowired
	private AccountingSettingAccountRepository repository;
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_READ")
	public AccountingSettingAccount findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_READ")
	public AccountingSettingAccount findOneByOrganizationIdAndType(String organization,AccountingSettingType type)
	{
		return repository.findOneByOrganizationIdAndType(organization, type);
	}
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_READ")
	public List<AccountingSettingAccount> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_READ")
	public List<AccountingSettingAccount> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_READ")
	public List<AccountingSettingAccount> findAllByType(AccountingSettingType type)
	{
		return repository.findAllByType(type);
	}
	
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_CREATE")
	public void add(AccountingSettingAccount account)
	{
		account.setId(UUID.randomUUID().toString());
		repository.save(account);
	}
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_UPDATE")
	public void edit(AccountingSettingAccount account)
	{
		repository.saveAndFlush(account);
	}
	
	@Secured("ROLE_ACCOUNTING_SETTING_ACCOUNT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
