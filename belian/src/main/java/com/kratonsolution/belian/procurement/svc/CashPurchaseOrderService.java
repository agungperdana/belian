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
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.TransferOrderRequestRepository;
import com.kratonsolution.belian.procurement.dm.CashPurchaseOrder;
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
	private InventoryItemRepository itemRepository;
	
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
		repository.save(order);
	}
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_UPDATE")
	public void edit(CashPurchaseOrder order)
	{
		repository.saveAndFlush(order);
	}
	
	@Secured("ROLE_CASH_PURCHASE_ORDER_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
