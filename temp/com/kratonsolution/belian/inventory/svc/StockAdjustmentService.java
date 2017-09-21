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
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.StockAdjustment;
import com.kratonsolution.belian.inventory.dm.StockAdjustmentItem;
import com.kratonsolution.belian.inventory.dm.StockAdjustmentRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StockAdjustmentService
{
	@Autowired
	private StockAdjustmentRepository repository;
	
	@Autowired
	private InventoryItemRepository itemRepository;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public StockAdjustment findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public List<StockAdjustment> findAll()
	{
		return repository.findAll();
	}
	
	
	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public List<StockAdjustment> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
	
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Secured("ROLE_STOCK_ADJUSTMENT_CREATE")
	public void add(StockAdjustment adj)
	{
		repository.save(adj);
		
		for(StockAdjustmentItem item:adj.getItems())
		{
			InventoryItem inv = itemRepository.findOne(item.getProduct().getId(), adj.getFacility().getId());
			if(inv == null)
			{
				inv = new InventoryItem();
				inv.setFacility(adj.getFacility());
				inv.setProduct(item.getProduct());
			}
			
			inv.setOnhand(inv.getOnhand().add(item.getQuantity()));
			
			itemRepository.save(inv);
		}
	}
	
	@Secured("ROLE_STOCK_ADJUSTMENT_UPDATE")
	public void edit(StockAdjustment StockAdjustment)
	{
		repository.saveAndFlush(StockAdjustment);
	}
	
	@Secured("ROLE_STOCK_ADJUSTMENT_DELETE")
	public void delete(String id)
	{
		StockAdjustment stock = repository.findOne(id);
		if(stock != null)
		{
			for(StockAdjustmentItem item:stock.getItems())
			{
				InventoryItem inv = itemRepository.findOne(item.getProduct().getId(), stock.getFacility().getId());
				if(inv == null)
					throw new RuntimeException("Item not exist in inventory(s)");
				
				if(inv.getOnhand().compareTo(item.getQuantity()) < 0)
					throw new RuntimeException("Item quantity already used for transaction,cannot be removed.");
			
				inv.setOnhand(inv.getOnhand().subtract(item.getQuantity()));
				
				itemRepository.save(inv);
			}
			
			repository.delete(stock);
		}
	}
}
