
package com.kratonsolution.belian.shipment.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.partys.dm.PartyRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentOrder;
import com.kratonsolution.belian.shipment.dm.ShipmentOrderRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ShipmentOrderService extends AbstractService
{
	@Autowired
	private ShipmentOrderRepository repository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private PartyRepository partyRepo;
	
	@Secured("ROLE_SHIPMENT_READ")
	public int size(String key)
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public ShipmentOrder findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<ShipmentOrder> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_SHIPMENT_CREATE")
	public void add(ShipmentOrder shipment)
	{
		repository.save(shipment);
	}
	
	@Secured("ROLE_SHIPMENT_UPDATE")
	public void edit(ShipmentOrder shipment)
	{
		repository.saveAndFlush(shipment);
	}
}
