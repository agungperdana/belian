
package com.kratonsolution.belian.accounting.svc;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@AllArgsConstructor
@Service
@Transactional(rollbackFor=Exception.class)
public class CurrencyService
{
	private CurrencyRepository repository;
	
	@Secured("ROLE_CURRENCY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_CURRENCY_READ","ROLE_SYSTEM_READ"})
	public Currency getOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.getOne(id);
		
		return null;
	}
	
	@Secured({"ROLE_CURRENCY_READ","ROLE_SYSTEM_READ"})
	public List<Currency> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CURRENCY_READ")
	public List<Currency> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_CURRENCY_CREATE")
	public void add(Currency currency)
	{
		currency.setId(UUID.randomUUID().toString());
		repository.save(currency);
	}
	
	@Secured("ROLE_CURRENCY_UPDATE")
	public void edit(Currency currency)
	{
		repository.saveAndFlush(currency);
	}
	
	@Secured("ROLE_CURRENCY_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.deleteById(id);
	}
}
