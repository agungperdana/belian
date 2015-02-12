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

import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.dm.TaxRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class TaxService
{
	@Autowired
	private TaxRepository repository;
	
	@Secured("ROLE_TAX_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_TAX_READ")
	public Tax findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_TAX_READ")
	public List<Tax> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_TAX_READ")
	public List<Tax> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_TAX_CREATE")
	public void add(Tax currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_TAX_UPDATE")
	public void edit(Tax currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_TAX_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
