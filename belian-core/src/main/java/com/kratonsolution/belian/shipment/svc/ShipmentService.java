package com.kratonsolution.belian.shipment.svc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.orders.dm.Order;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.orders.dm.OrderItemShippingInfo;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyRepository;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentOrder;
import com.kratonsolution.belian.shipment.dm.ShipmentRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentStatus;
import com.kratonsolution.belian.shipment.dm.ShipmentStatusType;
import com.kratonsolution.belian.shipment.dm.ShipmentType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ShipmentService extends AbstractService
{
	@Autowired
	private ShipmentRepository repository;
	
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
	public Shipment findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<Shipment> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<Shipment> findAllIssuable()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Shipment>();
		
		return repository.findAllIssuable(utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<Shipment> findAllReceiptable(String supplier)
	{
		if(utils.getOrganization() == null || Strings.isNullOrEmpty(supplier))
			return new ArrayList<Shipment>();
		
		return repository.findAllReceiptable(utils.getOrganization().getId(),supplier);
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<Shipment> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<Shipment> findAll(int pageIndex,int pageSize,String key)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<Shipment> forSalesInvoice(String receiver)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Shipment>();
		
		return repository.findAllSalesInvoiceable(utils.getOrganization().getId(), receiver);
	}
	
	@Secured("ROLE_SHIPMENT_READ")
	public List<Shipment> forPurchaseInvoice(String sender)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Shipment>();
		
		return repository.findAllPurchseInvoiceable(sender,utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SHIPMENT_CREATE")
	public void add(Shipment shipment)
	{
		shipment.setNumber(gen.generate(shipment.getEntryDate(),utils.getOrganization().getId(),Code.SHP));
		repository.save(shipment);
	}
	
	@Secured("ROLE_SHIPMENT_UPDATE")
	public void edit(Shipment shipment)
	{
		repository.saveAndFlush(shipment);
	}
	
	@Secured("ROLE_SHIPMENT_UPDATE")
	public void addItem(ShipmentItem shipmentItem)
	{
		for(ShipmentOrder order:shipmentItem.getOrders())
		{
			OrderItem out = orderItemRepository.findById(order.getOrderItem().getId()).orElse(null);
			if(out != null)
			{
				OrderItemShippingInfo info = new OrderItemShippingInfo();
				info.setAmount(order.getQuantity());
				info.setDate(DateTimes.timestamp());
				info.setOrderItem(out);
				
				out.getShippingInfos().add(info);
				
				orderItemRepository.saveAndFlush(out);
			}
		}
		
		shipmentItem.getShipment().getItems().add(shipmentItem);
		
		edit(shipmentItem.getShipment());
	}
	
	@Secured("ROLE_SHIPMENT_DELETE")
	public void deleteItem(Shipment shipment,Collection<String> itemIds)
	{
		if(shipment != null && itemIds != null && !itemIds.isEmpty())
		{
			Shipment out = repository.findById(shipment.getId()).orElse(null);
			if(out != null)
			{
				Iterator<ShipmentItem> iterator = out.getItems().iterator();
				while (iterator.hasNext())
				{
					ShipmentItem item = (ShipmentItem) iterator.next();
					for(String id:itemIds)
					{
						if(id.equals(item.getId()))
						{
							removeOrderShipmentInfo(item);
							iterator.remove();
						}
					}
				}
			}
			
			repository.saveAndFlush(out);
		}
	}
	
	public void removeOrderShipmentInfo(ShipmentItem item)
	{
		//update order item
		for(ShipmentOrder order:item.getOrders())
		{
			OrderItem out = orderItemRepository.findById(order.getOrderItem().getId()).orElse(null);
			if(out != null)
			{
				out.removeShippingInfo(order.getQuantity());
				orderItemRepository.saveAndFlush(out);
			}
		}
	}
	
	@Secured("ROLE_SHIPMENT_DELETE")
	public void delete(String id)
	{
		Shipment shipment = repository.findById(id).orElse(null);
		if(shipment != null)
		{
			for(ShipmentItem item:shipment.getItems())
				removeOrderShipmentInfo(item);
			
			repository.delete(shipment);
		}
	}
	
	@Secured("ROLE_SHIPMENT_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
	
	@Secured("ROLE_SHIPMENT_CREATE")
	public Shipment fromOrder(Order order,ShipmentType type,ShipmentStatusType lastStatus)
	{
		if(order == null)
			throw new RuntimeException("Order cannot be empty!");
		
		Shipment shipment = new Shipment();
		shipment.setType(type);
		shipment.setEntryDate(order.getEntryDate());
		shipment.setEstArrivalDate(order.getEntryDate());
		shipment.setEstReadyDate(order.getEntryDate());
		shipment.setEstShipCost(BigDecimal.ZERO);
		shipment.setEstShipDate(order.getEntryDate());
		shipment.setActShipCost(BigDecimal.ZERO);
		shipment.setInstruction("Auto generated from order ");
		
		//sender
		Party sender = partyRepo.findById(order.getPartyTakingOrder().getId()).orElse(null);
		if(sender != null)
		{
			shipment.setShipFromParty(sender.toRef());
			shipment.setShipFromAddress(sender.getFirstAddress());
			shipment.setShipFromContact(sender.getFirstContact());
		}
		
		//receiver
		shipment.setShipToParty(order.getShipToParty());
		shipment.setShipToAddress(order.getShipToAddress());
		shipment.setShipToContact(order.getShipToContact());
		
		//item tobe shopped
		for(OrderItem item:order.getItems())
		{
			ShipmentItem shipmentItem = new ShipmentItem();
			shipmentItem.setProduct(item.getProduct());
			shipmentItem.setQuantity(item.getQuantity());
			shipmentItem.setShipment(shipment);

			ShipmentOrder shipmentOrder = new ShipmentOrder();
			shipmentOrder.setOrder(order.toRef());
			shipmentOrder.setOrderItem(item.toRef());
			shipmentOrder.setQuantity(item.getQuantity());
			shipmentOrder.setShipmentItem(shipmentItem);
			shipmentOrder.setUnitPrice(item.getUntitPrice());
			
			shipmentItem.getOrders().add(shipmentOrder);
			
			shipment.getItems().add(shipmentItem);
		}
		
		ShipmentStatus status = new ShipmentStatus();
		status.setDate(DateTimes.timestamp());
		status.setShipment(shipment);
		status.setType(lastStatus);
		
		shipment.getStatuses().add(status);
		
		add(shipment);
		
		return shipment;
	}
}
