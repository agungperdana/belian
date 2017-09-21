/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.StockOpname;
import com.kratonsolution.belian.inventory.dm.StockOpnameItem;
import com.kratonsolution.belian.inventory.dm.StockOpnameRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StockOpnameService
{
	@Autowired
	private StockOpnameRepository repository;
	
	@Autowired
	private InventoryItemRepository itemRepository;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_STOCK_OPNAME_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_STOCK_OPNAME_READ")
	public StockOpname findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_STOCK_OPNAME_READ")
	public List<StockOpname> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_STOCK_OPNAME_READ")
	public List<StockOpname> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_STOCK_OPNAME_CREATE")
	public void add(StockOpname opname)
	{
		repository.save(opname);
		
		for(StockOpnameItem item:opname.getItems())
		{
			if(item.getOnhand().compareTo(item.getOpnamed()) != 0)
			{
				InventoryItem inv = itemRepository.findOne(item.getProduct().getId(), opname.getFacility().getId());
				if(inv != null)
				{
					inv.setOnhand(item.getOpnamed());
					itemRepository.save(inv);
				}
			}
		}
	}
	
	@Secured("ROLE_STOCK_OPNAME_UPDATE")
	public void edit(StockOpname opname)
	{
		
	}
	
	@Secured("ROLE_STOCK_OPNAME_DELETE")
	public void delete(String id)
	{
		StockOpname opname = repository.findOne(id);
		if(opname != null)
		{
			for(StockOpnameItem item:opname.getItems())
			{
				InventoryItem inv = itemRepository.findOne(item.getProduct().getId(), opname.getFacility().getId());
				if(inv != null)
				{
					if(inv.getOnhand().compareTo(item.getOpnamed()) != 0)
						throw new RuntimeException("Item inside inventory already changed or used.");
					
					inv.setOnhand(item.getOnhand());
					itemRepository.save(inv);
				}
			}
			
			repository.delete(opname);
		}
	}
}
