/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class InventoryItemService
{
	@Autowired
	private InventoryItemRepository repository;
	
	@Secured("ROLE_INVITEM_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_INVITEM_READ")
	public int size(String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.count(key).intValue();
		else
			return size();
	}
	
	@Secured("ROLE_INVITEM_READ")
	public InventoryItem findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_INVITEM_READ")
	public InventoryItem findOne(String product,String facility)
	{
		return repository.findOne(product,facility);
	}
	
	@Secured("ROLE_INVITEM_READ")
	public InventoryItem findOne(String product,String facility,Date expired)
	{
		if(expired == null)
			findOne(product, facility);
	
		return repository.findOne(product, facility, expired);
	}
	
	@Secured("ROLE_INVITEM_READ")
	public List<InventoryItem> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_INVITEM_READ")
	public List<InventoryItem> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize,new Sort(Direction.ASC,"product.name"))).getContent();
	}
	
	@Secured("ROLE_INVITEM_READ")
	public List<InventoryItem> findAll(int pageIndex,int pageSize,String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(new PageRequest(pageIndex, pageSize),key);
		else
			return findAll(pageIndex, pageSize);
	}
	
	@Secured("ROLE_INVITEM_CREATE")
	public void add(InventoryItem item)
	{
		InventoryItem ondb = repository.findOne(item.getProduct().getId(), item.getFacility().getId());
		if(ondb != null)
			throw new RuntimeException("Inventory Item already exist,please use stock adjustment to change on hand quantity.");
		
		repository.save(item);
	}
	
	@Secured("ROLE_INVITEM_UPDATE")
	public void edit(InventoryItem item)
	{
		repository.saveAndFlush(item);
	}
	
	@Secured("ROLE_INVITEM_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
