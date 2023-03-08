/**
 * 
 */
package com.kratonsolution.belian.shipment.svc;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.svc.StockService;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuance;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuanceItem;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuanceRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuanceRole;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentItemIssuanceInfo;
import com.kratonsolution.belian.shipment.dm.ShipmentItemRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentOrder;
import com.kratonsolution.belian.shipment.dm.ShipmentRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentRoleType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ShipmentIssuanceService extends AbstractService
{
	@Autowired
	private ShipmentIssuanceRepository repository;
	
	@Autowired
	private StockService stockService;

	@Autowired
	private ShipmentItemRepository itemRepo;
	
	@Autowired
	private OrderItemRepository orderRepo;
	
	@Autowired
	private ShipmentRepository shipmentRepo;
	
	@Autowired
	private InventoryItemRepository invItemRepo;
	
	@Secured("ROLE_SHIPMENT_ISSUANCE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_SHIPMENT_ISSUANCE_READ")
	public ShipmentIssuance findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_SHIPMENT_ISSUANCE_READ")
	public List<ShipmentIssuance> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_SHIPMENT_ISSUANCE_READ")
	public List<ShipmentIssuance> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SHIPMENT_ISSUANCE_CREATE")
	public void add(ShipmentIssuance issuance)
	{
		issuance.setNumber(gen.generate(issuance.getDate(),issuance.getOrganization().getId(),Code.SHI));
		
		//save actual gs doc
		repository.save(issuance);
	
		//update inventory
		stockService.removeStock(issuance.getItems());
		
		//update shipmentitem information
		for(ShipmentIssuanceItem item:issuance.getItems())
		{
			ShipmentItem shipmentItem = itemRepo.findOne(item.getShipmentItem().getId());
			if(shipmentItem != null)
			{
				ShipmentItemIssuanceInfo info = new ShipmentItemIssuanceInfo();
				info.setAmount(item.getAccepted());
				info.setDate(DateTimes.timestamp());
				info.setShipmentItem(shipmentItem);

				shipmentItem.getIssuanceInfos().add(info);
				
				itemRepo.saveAndFlush(shipmentItem);
			}
		}
		
		Shipment shipment = shipmentRepo.findOne(issuance.getShipment().getId());
		if(shipment != null)
		{
			shipment.setShipped(true);
			shipmentRepo.saveAndFlush(shipment);
		}
	}
	
	@Secured("ROLE_SHIPMENT_ISSUANCE_UPDATE")
	public void edit(ShipmentIssuance issuance)
	{
		repository.saveAndFlush(issuance);
	}
	
	@Secured("ROLE_SHIPMENT_ISSUANCE_DELETE")
	public void delete(String id)
	{
		ShipmentIssuance issuance = findOne(id);
		if(issuance != null)
		{
			stockService.addStock(issuance.getItems());
		
			//update shipmentitem information
			for(ShipmentIssuanceItem item:issuance.getItems())
			{
				ShipmentItem shipmentItem = itemRepo.findOne(item.getShipmentItem().getId());
				if(shipmentItem != null)
				{
					shipmentItem.removeIssuanceInfo(item.getAccepted());
					itemRepo.saveAndFlush(shipmentItem);
				}
			}
		}
		
		repository.delete(issuance);
		
		Shipment shipment = shipmentRepo.findOne(issuance.getShipment().getId());
		if(shipment != null)
		{
			shipment.setShipped(false);
			shipmentRepo.saveAndFlush(shipment);
		}
	}
	
	@Secured("ROLE_SHIPMENT_ISSUANCE_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
	
	public void fromShipment(Shipment shipment)
	{
		if(shipment == null)
			throw new RuntimeException("Shipment cannot be empty");
			
		if(utils.getFacility() == null)
			throw new RuntimeException("Default facility doesnot exist,select it first at setting menu");
		
		ShipmentIssuance issuance = new ShipmentIssuance();
		issuance.setDate(DateTimes.currentDate());
		issuance.setDestination(shipment.getShipToParty());
		issuance.setNumber(gen.generate(DateTimes.currentDate(),shipment.getShipFromParty().getId(),Code.SHI));
		issuance.setOrganization(shipment.getShipFromParty());
		issuance.setShipment(shipment.toRef());
		
		ShipmentIssuanceRole role = new ShipmentIssuanceRole();
		role.setIssuance(issuance);
		role.setParty(utils.getPerson().toRef());
		role.setType(ShipmentRoleType.ISSUER);
		
		issuance.getRoles().add(role);
		
		for(ShipmentItem item:shipment.getItems())
		{
			for(ShipmentOrder shipOrder:item.getOrders())
			{
				BigDecimal temp = shipOrder.getQuantity();
				
				List<InventoryItem> invs = invItemRepo.allByFacilityAndProduct(utils.getFacility().getId(),item.getProduct().getId());
				for(InventoryItem inventoryItem:invs)
				{	
					if(temp.compareTo(BigDecimal.ZERO) > 0 && inventoryItem.getOnhand().compareTo(BigDecimal.ZERO) > 0)
					{
						ShipmentIssuanceItem issuanceItem = new ShipmentIssuanceItem();
						issuanceItem.setFacility(inventoryItem.getFacility());
						issuanceItem.setContainer(inventoryItem.getContainer());
						issuanceItem.setExpired(inventoryItem.getExpiredDate());
						issuanceItem.setIssuance(issuance);
						issuanceItem.setProduct(inventoryItem.getProduct());
						issuanceItem.setShipmentItem(item.toRef());

						issuance.getItems().add(issuanceItem);
						
						if(inventoryItem.getOnhand().compareTo(temp) >= 0)
						{
							issuanceItem.setQuantity(temp);
							temp = BigDecimal.ZERO;
						}
						else 
						{
							issuanceItem.setQuantity(inventoryItem.getOnhand());
							temp = temp.subtract(inventoryItem.getOnhand());
						}
					}
				}
			}
		}
		
		add(issuance);
	}
}
