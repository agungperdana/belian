/**
 * 
 */
package com.kratonsolution.belian.sales.srv;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.sales.dm.DirectSales;
import com.kratonsolution.belian.sales.dm.DirectSalesRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CashSalesService
{
	@Autowired
	private DirectSalesRepository repository;
	
	@Secured("ROLE_CASHSALES_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public DirectSales findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<DirectSales> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<DirectSales> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	public void add(DirectSales sales)
	{
		sales.setId(UUID.randomUUID().toString());
		repository.save(sales);
	}
	
	@Secured("ROLE_CASHSALES_UPDATE")
	public void edit(DirectSales sales)
	{
		repository.saveAndFlush(sales);
	}
	
	@Secured("ROLE_CASHSALES_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
