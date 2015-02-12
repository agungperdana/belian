/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.CurrencyRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class CurrencyService
{
	@Autowired
	private CurrencyRepository repository;
	
	@Secured("ROLE_CURRENCY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_CURRENCY_READ")
	public Currency findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CURRENCY_READ")
	public List<Currency> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CURRENCY_READ")
	public List<Currency> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_CURRENCY_CREATE")
	public void add(Currency currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_CURRENCY_UPDATE")
	public void edit(Currency currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_CURRENCY_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
