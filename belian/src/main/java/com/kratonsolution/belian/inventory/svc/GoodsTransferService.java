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
import com.kratonsolution.belian.global.dm.RequestStatus;
import com.kratonsolution.belian.inventory.dm.GoodsTransfer;
import com.kratonsolution.belian.inventory.dm.GoodsTransferItem;
import com.kratonsolution.belian.inventory.dm.GoodsTransferRepository;
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
public class GoodsTransferService
{
	@Autowired
	private GoodsTransferRepository repository;
	
	@Autowired
	private TransferOrderRequestRepository requestRepository;
	
	@Autowired
	private InventoryItemRepository itemRepository;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_GOODS_TRANSFER_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_GOODS_TRANSFER_READ")
	public GoodsTransfer findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_GOODS_TRANSFER_READ")
	public List<GoodsTransfer> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_GOODS_TRANSFER_READ")
	public List<GoodsTransfer> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_GOODS_TRANSFER_CREATE")
	public void add(GoodsTransfer transfer)
	{
		repository.save(transfer);
		
		boolean done = true;
		for(GoodsTransferItem item:transfer.getItems())
		{
			issue(transfer, item);
			receive(transfer, item);
			done = item.getRequestedItem().isDone();
		}
		
		if(done)
		{
			transfer.getRequest().setRequestStatus(RequestStatus.COMPLETE);
			requestRepository.save(transfer.getRequest());
		}
	}
	
	@Secured("ROLE_GOODS_TRANSFER_UPDATE")
	public void edit(GoodsTransfer transfer)
	{
		repository.saveAndFlush(transfer);
	}
	
	@Secured("ROLE_GOODS_TRANSFER_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	private void issue(GoodsTransfer transfer, GoodsTransferItem item)
	{
		InventoryItem out = itemRepository.findOne(item.getProduct().getId(),transfer.getFacilityFrom().getId());
		if(out == null)
			throw new RuntimeException("Product not exist.");
		
		if(out.getOnhand().compareTo(item.getQuantity()) < 0)
			throw new RuntimeException("On hand quantity less than requested quantity.");
		
		out.setOnhand(out.getOnhand().subtract(item.getQuantity()));
		itemRepository.save(out);
	}
	
	private void receive(GoodsTransfer transfer, GoodsTransferItem item)
	{
		InventoryItem in = itemRepository.findOne(item.getProduct().getId(),transfer.getFacilityTo().getId());
		if(in == null)
		{
			in = new InventoryItem();
			in.setFacility(transfer.getFacilityTo());
			in.setProduct(item.getProduct());
			in.setOnhand(item.getQuantity());
		}
		else
			in.setOnhand(in.getOnhand().add(item.getQuantity()));
		
		itemRepository.save(in);
		
	}
}
