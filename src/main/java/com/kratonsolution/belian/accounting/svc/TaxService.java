
package com.kratonsolution.belian.accounting.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.dm.TaxRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TaxService
{
	@Autowired
	private TaxRepository repository;
	
	@Secured("ROLE_TAX_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_TAX_READ","ROLE_SYSTEM_READ"})
	public Tax getOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.getOne(id);
		
		return null;
	}
	
	@Secured({"ROLE_TAX_READ","ROLE_SYSTEM_READ"})
	public List<Tax> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_TAX_READ")
	public List<Tax> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_TAX_CREATE")
	public void add(Tax tax)
	{
		tax.setId(UUID.randomUUID().toString());
		repository.save(tax);
	}
	
	@Secured("ROLE_TAX_UPDATE")
	public void edit(Tax tax)
	{
		repository.saveAndFlush(tax);
	}
	
	@Secured("ROLE_TAX_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.deleteById(id);
	}
}
