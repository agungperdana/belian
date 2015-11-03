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

import com.kratonsolution.belian.accounting.dm.AccountingSetting;
import com.kratonsolution.belian.accounting.dm.AccountingSettingRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AccountingSettingService
{
	@Autowired
	private AccountingSettingRepository repository;

	@Secured("ROLE_ACCOUNTING_SETTING_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}

	@Secured("ROLE_ACCOUNTING_SETTING_READ")
	public AccountingSetting findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_ACCOUNTING_SETTING_READ")
	public List<AccountingSetting> findAll()
	{
		return repository.findAll();
	}

	@Secured("ROLE_ACCOUNTING_SETTING_READ")
	public List<AccountingSetting> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}

	@Secured("ROLE_ACCOUNTING_SETTING_CREATE")
	public void add(AccountingSetting setting)
	{
		setting.setId(UUID.randomUUID().toString());
		repository.save(setting);
	}

	@Secured("ROLE_ACCOUNTING_SETTING_UPDATE")
	public void edit(AccountingSetting setting)
	{
		repository.saveAndFlush(setting);
	}

	@Secured("ROLE_ACCOUNTING_SETTING_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
