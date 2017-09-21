/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.ProductRetur;
import com.kratonsolution.belian.inventory.dm.ProductReturItem;
import com.kratonsolution.belian.inventory.dm.ProductReturRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ProductReturService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private ProductReturRepository repository;
	
	@Autowired
	private InventoryStockService stockService;
	
	@Secured("ROLE_PRODUCT_RETUR_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PRODUCT_RETUR_READ")
	public ProductRetur findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PRODUCT_RETUR_READ")
	public List<ProductRetur> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PRODUCT_RETUR_READ")
	public List<ProductRetur> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_PRODUCT_RETUR_CREATE")
	public void add(ProductRetur retur)
	{
		repository.save(retur);
		
		for(ProductReturItem item:retur.getItems())
			stockService.issue(retur.getFacility(), item.getProduct(), item.getQuantity(), item.getExpiredDate());
	}
	
	@Secured("ROLE_PRODUCT_RETUR_UPDATE")
	public void edit(ProductRetur item)
	{
	}
	
	@Secured("ROLE_PRODUCT_RETUR_DELETE")
	public void delete(String id)
	{
		ProductRetur retur = findOne(id);
		if(retur != null)
		{
			for(ProductReturItem item:retur.getItems())
				stockService.receive(retur.getFacility(), item.getProduct(), item.getQuantity(), item.getExpiredDate());
				
			repository.delete(retur);
		}
	}
}
