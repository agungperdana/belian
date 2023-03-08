/**
 * 
 */
package com.kratonsolution.belian.orders.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrderItemService extends AbstractService
{
	@Autowired
	private OrderItemRepository repository;

	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public int size()
	{
		return (int)repository.count();
	}

	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public OrderItem findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public List<OrderItem> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public List<OrderItem> findAllReceivable(String supplier)
	{
		return repository.findAllReceivable(supplier,utils.getOrganization().getId());
	}

	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public List<OrderItem> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<OrderItem> findAllForWorkEfforts()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAllForWorkEfforts(utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public List<OrderItem> findAllForRequirement()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<OrderItem>();
		
		return repository.findAllWorkRequirements(utils.getOrganization().getId());
	}

	@Secured("ROLE_SHIPMENT_RECEIPT_CREATE")
	public void add(OrderItem order)
	{
		repository.save(order);
	}

	@Secured("ROLE_SHIPMENT_RECEIPT_UPDATE")
	public void edit(OrderItem order)
	{
		repository.saveAndFlush(order);
	}

	@Secured("ROLE_SHIPMENT_RECEIPT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
