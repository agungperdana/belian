/**
 * 
 */
package com.kratonsolution.belian.procurement.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.dm.TransferOrderRequestRepository;
import com.kratonsolution.belian.inventory.svc.InventoryStockService;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrderItem;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrderRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CashPurchaseOrderService
{
	@Autowired
	private CashPurchaseOrderRepository repository;
	
	@Autowired
	private TransferOrderRequestRepository requestRepository;
	
	@Autowired
	private InventoryStockService stockService;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_READ")
	public CashPurchaseOrder findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_READ")
	public List<CashPurchaseOrder> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_READ")
	public List<CashPurchaseOrder> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_CREATE")
	public void add(CashPurchaseOrder order)
	{
		if(order.getFacility() == null)
			throw new RuntimeException("Please choose facility first.");
		
		repository.save(order);
	
		for(CashPurchaseOrderItem item:order.getItems())
		{
			if(item.getProduct().getComponents().isEmpty())
				stockService.receive(order.getFacility(), item.getProduct(), item.getQuantity(), item.getExpiredDate());
			else
			{
				for(ProductComponent com:item.getProduct().getComponents())
					stockService.receive(order.getFacility(), com.getProduct(), com.getQuantity().multiply(item.getQuantity()), item.getExpiredDate());
			}
		}
	}
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_UPDATE")
	public void edit(CashPurchaseOrder order)
	{
		repository.saveAndFlush(order);
	}
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_DELETE")
	public void delete(String id)
	{
		CashPurchaseOrder order = findOne(id);
		if(order != null)
		{
			for(CashPurchaseOrderItem item:order.getItems())
				stockService.issue(order.getFacility(), item.getProduct(), item.getQuantity(), item.getExpiredDate());
		
			repository.delete(order);
		}
	}
}
