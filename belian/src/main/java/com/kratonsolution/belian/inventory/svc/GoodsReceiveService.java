/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.GoodsReceive;
import com.kratonsolution.belian.inventory.dm.GoodsReceiveItem;
import com.kratonsolution.belian.inventory.dm.GoodsReceiveRepository;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.ReceiveableRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class GoodsReceiveService
{
	@Autowired
	private GoodsReceiveRepository repository;
	
	@Autowired
	private ReceiveableRepository receiveableRepository;
	
	@Autowired
	private InventoryItemRepository itemRepository;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_GOODS_RECEIVE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_GOODS_RECEIVE_READ")
	public GoodsReceive findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_GOODS_RECEIVE_READ")
	public List<GoodsReceive> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_GOODS_RECEIVE_READ")
	public List<GoodsReceive> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_GOODS_RECEIVE_CREATE")
	public void add(GoodsReceive receive)
	{
		repository.save(receive);
		
//		receive.getReference().setStatus(Status.DONE);
//		receiveableRepository.save(receive.getReference());
		
		for(GoodsReceiveItem item:receive.getItems())
		{
			InventoryItem inv = itemRepository.findOne(item.getProduct().getId(), receive.getDestination().getId());
			if(inv == null)
			{
				inv = new InventoryItem();
				inv.setFacility(receive.getDestination());
				inv.setOnhand(item.getQuantity());
				inv.setProduct(item.getProduct());
			}
			else
				inv.setOnhand(inv.getOnhand().add(item.getQuantity()));
			
			itemRepository.save(inv);
		}
	}
	
	@Secured("ROLE_GOODS_RECEIVE_UPDATE")
	public void edit(GoodsReceive receive)
	{
		repository.saveAndFlush(receive);
	}
	
	@Secured("ROLE_GOODS_RECEIVE_DELETE")
	public void delete(String id)
	{
		GoodsReceive receive = findOne(id);
		if(receive != null)
		{
			for(GoodsReceiveItem item:receive.getItems())
			{
				InventoryItem inv = itemRepository.findOne(item.getProduct().getId(), receive.getDestination().getId());
				if(inv != null)
				{
					inv.setOnhand(inv.getOnhand().subtract(item.getQuantity()));
					if(inv.getOnhand().compareTo(BigDecimal.ZERO) < 0)
						inv.setOnhand(BigDecimal.ZERO);
					
					itemRepository.save(inv);
				}
			}
			
//			receive.getReference().setStatus(Status.NEW);
//
//			receiveableRepository.save(receive.getReference());
			repository.delete(receive);
		}
	}
}
