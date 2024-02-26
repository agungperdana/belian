/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.StockHistory;

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
	
	@Autowired
	private Language lang;
	
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
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
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
		InventoryItem ondb = repository.findOne(item.getProduct().getId(),item.getFacility().getId(),item.getContainer().getId(),item.getExpiredDate());
		if(ondb != null)
			throw new RuntimeException(lang.get("inventory.message.exist"));

		StockHistory history = new StockHistory();
		history.setDate(DateTimes.currentDate());
		history.setIn(item.getOnhand());
		history.setItem(item);
		history.getLog().setCreated(DateTimes.timestamp());

		item.getHistorys().add(history);
		
		repository.save(item);
	}
	
	@Secured("ROLE_INVITEM_UPDATE")
	public void edit(InventoryItem item)
	{
		repository.saveAndFlush(item);
	}
	
	@Secured("ROLE_INVITEM_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
