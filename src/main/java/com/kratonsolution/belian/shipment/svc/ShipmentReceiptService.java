package com.kratonsolution.belian.shipment.svc;

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
import com.kratonsolution.belian.inventory.svc.StockService;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentItemReceiptInfo;
import com.kratonsolution.belian.shipment.dm.ShipmentItemRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentReceipt;
import com.kratonsolution.belian.shipment.dm.ShipmentReceiptItem;
import com.kratonsolution.belian.shipment.dm.ShipmentReceiptRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ShipmentReceiptService extends AbstractService
{
	@Autowired
	private ShipmentReceiptRepository repository;
	
	@Autowired
	private ShipmentRepository shipmentRepo;
	
	@Autowired
	private StockService stockService;

	@Autowired
	private ShipmentItemRepository itemRepo;
	
	@Autowired
	private OrderItemRepository orderRepo;
	
	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public ShipmentReceipt findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public List<ShipmentReceipt> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_READ")
	public List<ShipmentReceipt> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_CREATE")
	public void add(ShipmentReceipt receipt)
	{
		//save actual gs doc
		receipt.setNumber(gen.generate(receipt.getDate(), receipt.getOrganization().getId(), Code.SHR));
		repository.save(receipt);
	
		//update inventory
		stockService.addStock(receipt.getItems());
		
		//update shipmentitem information
		for(ShipmentReceiptItem item:receipt.getItems())
		{
			ShipmentItem shipmentItem = itemRepo.findById(item.getShipmentItem().getId()).orElse(null);
			if(shipmentItem != null)
			{
				ShipmentItemReceiptInfo info = new ShipmentItemReceiptInfo();
				info.setAmount(item.getAccepted());
				info.setDate(DateTimes.timestamp());
				info.setShipmentItem(shipmentItem);
				
				shipmentItem.getReceiptInfos().add(info);
				
				itemRepo.saveAndFlush(shipmentItem);
			}
		}
		
		Shipment shipment = shipmentRepo.findById(receipt.getShipment().getId()).orElse(null);
		if(shipment != null)
		{
			shipment.setDelivered(true);
			shipmentRepo.saveAndFlush(shipment);
		}
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_UPDATE")
	public void edit(ShipmentReceipt receipt)
	{
		repository.saveAndFlush(receipt);
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_DELETE")
	public void delete(String id)
	{
		ShipmentReceipt receipt = findById(id);
		if(receipt != null)
		{
			stockService.removeStock(receipt.getItems());
		
			//update shipmentitem information
			for(ShipmentReceiptItem item:receipt.getItems())
			{
				ShipmentItem shipmentItem = itemRepo.findById(item.getShipmentItem().getId()).orElse(null);
				if(shipmentItem != null)
				{
					shipmentItem.removeReceiptInfo(item.getAccepted());
					itemRepo.saveAndFlush(shipmentItem);
				}
			}
		}
		
		repository.delete(receipt);
		
		Shipment shipment = shipmentRepo.findById(receipt.getShipment().getId()).orElse(null);
		if(shipment != null)
		{
			shipment.setDelivered(false);
			shipmentRepo.saveAndFlush(shipment);
		}
	}
	
	@Secured("ROLE_SHIPMENT_RECEIPT_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
}
