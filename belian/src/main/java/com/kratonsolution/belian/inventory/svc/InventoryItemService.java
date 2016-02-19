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

import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;

/**
 * @author agungdodiperdana
 *
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
	public InventoryItem findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_INVITEM_READ")
	public List<InventoryItem> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_INVITEM_READ")
	public List<InventoryItem> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_INVITEM_CREATE")
	public void add(InventoryItem item)
	{
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
