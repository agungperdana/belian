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

import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CashSalesService
{
	@Autowired
	private CashSalesRepository repository;
	
	@Secured("ROLE_CASHSALES_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public CashSales findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<CashSales> loadAllUnpaid(int pageIndex,int pageSize)
	{
		return repository.loadAllUnpaid(new PageRequest(pageIndex, pageSize));
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	public void add(CashSales sales)
	{
		sales.setId(UUID.randomUUID().toString());
		repository.save(sales);
	}
	
	@Secured("ROLE_CASHSALES_UPDATE")
	public void edit(CashSales sales)
	{
		repository.saveAndFlush(sales);
	}
	
	@Secured("ROLE_CASHSALES_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
