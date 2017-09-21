/**
 * 
 */
package com.kratonsolution.belian.procurement.svc;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.procurement.dm.PORRole;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequest;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestItem;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PurchaseOrderRequestService
{
	@Autowired
	private PurchaseOrderRequestRepository repository;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_READ")
	public PurchaseOrderRequest findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_READ")
	public List<PurchaseOrderRequest> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_READ")
	public List<PurchaseOrderRequest> findAllIncomplete()
	{
		return repository.findAllIncomplete(utils.getOrganization().getId());
	}
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_READ")
	public List<PurchaseOrderRequest> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_CREATE")
	public void add(PurchaseOrderRequest order)
	{
		repository.save(order);
	}
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_UPDATE")
	public void edit(PurchaseOrderRequest order)
	{
		repository.saveAndFlush(order);
	}
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_UPDATE")
	public void edit(PurchaseOrderRequest order,Collection<PurchaseOrderRequestItem> items,Collection<PORRole> roles)
	{
		order.getItems().clear();
		order.getRoles().clear();

		repository.saveAndFlush(order);
		
		order.getItems().addAll(items);
		order.getRoles().addAll(roles);
		
		repository.saveAndFlush(order);
	}
	
	@Secured("ROLE_PURCHASE_ORDER_REQUEST_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
