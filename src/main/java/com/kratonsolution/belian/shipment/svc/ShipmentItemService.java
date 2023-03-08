/**
 * 
 */
package com.kratonsolution.belian.shipment.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentItemRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ShipmentItemService extends AbstractService
{
	@Autowired
	private ShipmentItemRepository repository;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Secured("ROLE_SHIPMENT_READ")
	public ShipmentItem findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<ShipmentItem> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<ShipmentItem> findAllReceiptable(String company,String supplier)
	{
		return repository.findAllReceiptable(company, supplier);
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<ShipmentItem> findAllIssuable(String company,String customer)
	{
		return repository.findAllIssuable(company, customer);
	}
	
	@Secured("ROLE_SHIPMENT_CREATE")
	public void add(ShipmentItem shipment)
	{
		//save actual gs doc
		repository.save(shipment);
	}
	
	@Secured("ROLE_SHIPMENT_UPDATE")
	public void edit(ShipmentItem shipment)
	{
		repository.saveAndFlush(shipment);
	}
	
	@Secured("ROLE_SHIPMENT_DELETE")
	public void delete(String id)
	{
	}
}
