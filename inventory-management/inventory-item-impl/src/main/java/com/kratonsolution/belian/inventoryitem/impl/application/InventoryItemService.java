package com.kratonsolution.belian.inventoryitem.impl.application;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.inventoryitem.impl.orm.InventoryItem;
import com.kratonsolution.belian.inventoryitem.impl.orm.StockHistory;
import com.kratonsolution.belian.inventoryitem.impl.repository.InventoryItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class InventoryItemService
{
	private InventoryItemRepository repository;
	
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
	public InventoryItem findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_INVITEM_READ")
	public InventoryItem findById(String product,String facility)
	{
		return repository.findById(product,facility);
	}
	
	@Secured("ROLE_INVITEM_READ")
	public InventoryItem findById(String product,String facility,Date expired)
	{
		if(expired == null)
			findById(product, facility);
	
		return repository.findById(product, facility, expired);
	}
	
	@Secured("ROLE_INVITEM_READ")
	public List<InventoryItem> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_INVITEM_READ")
	public List<InventoryItem> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_INVITEM_READ")
	public List<InventoryItem> findAll(int pageIndex,int pageSize,String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(PageRequest.of(pageIndex, pageSize),key);
		else
			return findAll(pageIndex, pageSize);
	}
	
	@Secured("ROLE_INVITEM_CREATE")
	public void add(InventoryItem item)
	{
		InventoryItem ondb = repository.findById(item.getProduct().getId(),item.getFacility().getId(),item.getContainer().getId(),item.getExpiredDate());
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
		repository.deleteById(id);
	}
}
