/**
 * 
 */
package com.kratonsolution.belian.orders.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.orders.dm.Order;
import com.kratonsolution.belian.orders.dm.OrderRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrderService extends AbstractService
{
	@Autowired
	private OrderRepository repository;
	
	@Secured("ROLE_SHIPMENT_READ")
	public int size()
	{
		return (int)repository.count();
	}

	@Secured("ROLE_SHIPMENT_READ")
	public Order findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_SHIPMENT_READ")
	public List<Order> findAll()
	{
		return repository.findAll();
	}

	@Secured("ROLE_SHIPMENT_READ")
	public List<Order> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}

	@Secured("ROLE_SHIPMENT_READ")
	public List<Order> findAllShipable(String sender,String receiver)
	{
		return repository.findAllShipable(sender, receiver);
	}
	
	@Secured("ROLE_SHIPMENT_CREATE")
	public void add(Order order)
	{
		repository.save(order);
	}

	@Secured("ROLE_SHIPMENT_UPDATE")
	public void edit(Order order)
	{
		repository.saveAndFlush(order);
	}

	@Secured("ROLE_SHIPMENT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
