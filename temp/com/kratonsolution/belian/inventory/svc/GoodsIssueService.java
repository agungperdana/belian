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
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.GoodsIssue;
import com.kratonsolution.belian.inventory.dm.GoodsIssueItem;
import com.kratonsolution.belian.inventory.dm.GoodsIssueRepository;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.TransferOrderRequestRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class GoodsIssueService
{
	@Autowired
	private GoodsIssueRepository repository;
	
	@Autowired
	private TransferOrderRequestRepository requestRepository;
	
	@Autowired
	private InventoryItemRepository itemRepository;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_GOODS_ISSUE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_GOODS_ISSUE_READ")
	public GoodsIssue findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_GOODS_ISSUE_READ")
	public List<GoodsIssue> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_GOODS_ISSUE_READ")
	public List<GoodsIssue> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_GOODS_ISSUE_CREATE")
	public void add(GoodsIssue order)
	{
		repository.save(order);
		requestRepository.save(order.getRequest());
		
		for(GoodsIssueItem item:order.getItems())
		{
			InventoryItem inventoryItem = itemRepository.findOne(item.getItem().getProduct().getId(),order.getSource().getId());
			if(inventoryItem == null)
				throw new RuntimeException("Item not exist.");
			
			if(inventoryItem.getOnhand().compareTo(item.getQuantity()) < 0)
				throw new RuntimeException("Quantity on hand less than requested.");
			
			inventoryItem.setOnhand(inventoryItem.getOnhand().subtract(item.getQuantity()));
			
			itemRepository.save(inventoryItem);
		}
	}
	
	@Secured("ROLE_GOODS_ISSUE_UPDATE")
	public void edit(GoodsIssue order)
	{
		repository.saveAndFlush(order);
	}
	
	@Secured("ROLE_GOODS_ISSUE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
