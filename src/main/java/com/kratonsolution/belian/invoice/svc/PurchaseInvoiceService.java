/**
 * 
 */
package com.kratonsolution.belian.invoice.svc;

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
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.dm.InvoiceItem;
import com.kratonsolution.belian.invoice.dm.InvoiceItemType;
import com.kratonsolution.belian.invoice.dm.InvoiceStatus;
import com.kratonsolution.belian.invoice.dm.InvoiceStatusType;
import com.kratonsolution.belian.invoice.dm.OrderItemBilling;
import com.kratonsolution.belian.invoice.dm.PurchaseInvoice;
import com.kratonsolution.belian.invoice.dm.PurchaseInvoiceRepository;
import com.kratonsolution.belian.invoice.dm.ShipmentItemBilling;
import com.kratonsolution.belian.invoice.dm.WorkEffortBilling;
import com.kratonsolution.belian.invoice.dm.WorkEffortBillingRepository;
import com.kratonsolution.belian.orders.dm.OrderAdjustment;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.dm.OrderItemInvoiceInfo;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.orders.dm.OrderType;
import com.kratonsolution.belian.orders.dm.PurchaseOrder;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyRepository;
import com.kratonsolution.belian.payments.dm.PaymentApplication;
import com.kratonsolution.belian.payments.dm.PaymentApplicationRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentItemRepository;
import com.kratonsolution.belian.shipment.dm.ShipmentOrder;
import com.kratonsolution.belian.workefforts.dm.WorkEffort;
import com.kratonsolution.belian.workefforts.dm.WorkEffortRepository;
import com.kratonsolution.belian.workefforts.dm.WorkOrderItemFulfillment;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PurchaseInvoiceService extends AbstractService
{
	@Autowired
	private PurchaseInvoiceRepository repository;

	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Autowired
	private ShipmentItemRepository shipmentItemRepo;
	
	@Autowired
	private WorkEffortRepository effortRepo;
	
	@Autowired
	private PartyRepository partyRepo;
	
	@Autowired
	private WorkEffortBillingRepository effortBillingRepo;
	
	@Autowired
	private PaymentApplicationRepository appRepo;
	
	@Secured("ROLE_PURCHASE_INVOICE_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		return repository.count(utils.getOrganization().getId()).intValue();
	}

	@Secured("ROLE_PURCHASE_INVOICE_READ")
	public int size(String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganization().getId()).intValue();
	}

	@Secured("ROLE_SALES_INVOICE_READ")
	public List<PurchaseInvoice> findAllUnpaid(String supplier,String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		if(Strings.isNullOrEmpty(key))
			return repository.findAllUnpaid(utils.getOrganization().getId(),supplier);
		
		return repository.findAllUnpaid(utils.getOrganization().getId(),supplier,key);
	}
	
	@Secured("ROLE_PURCHASE_INVOICE_READ")
	public PurchaseInvoice findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_PURCHASE_INVOICE_READ")
	public List<PurchaseInvoice> findAll()
	{
		return repository.findAll();
	}


	@Secured("ROLE_PURCHASE_INVOICE_READ")
	public List<PurchaseInvoice> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}

	@Secured("ROLE_PURCHASE_INVOICE_READ")
	public List<PurchaseInvoice> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId(),key);
	}

	@Secured("ROLE_PURCHASE_INVOICE_CREATE")
	public void add(PurchaseInvoice invoice)
	{
		invoice.setNumber(gen.generate(invoice.getDate(), invoice.getBilledFromParty().getId(), Code.PIV));
		repository.save(invoice);
	}

	@Secured("ROLE_PURCHASE_INVOICE_UPDATE")
	public void edit(PurchaseInvoice invoice)
	{
		repository.saveAndFlush(invoice);
	}
	
	@Secured("ROLE_PURCHASE_INVOICE_UPDATE")
	public void addItem(InvoiceItem invoiceItem)
	{
		repository.saveAndFlush((PurchaseInvoice)invoiceItem.getInvoice());
		
		if(invoiceItem.getType().equals(InvoiceItemType.INVOICE_PRODUCT) || invoiceItem.getType().equals(InvoiceItemType.INVOICE_PRODUCT_FEATURE) )
		{
			for(OrderItemBilling billing:invoiceItem.getOrderItemBillings())
			{
				OrderItem orderItem = orderItemRepo.findOne(billing.getOrderItem().getId());
				if(orderItem != null)
				{
					OrderItemInvoiceInfo info = new OrderItemInvoiceInfo();
					info.setAmount(billing.getAmount());
					info.setDate(DateTimes.timestamp());
					info.setOrderItem(orderItem);

					orderItem.getInvoiceInfos().add(info);
					
					orderItemRepo.saveAndFlush(orderItem);
				}
			}
			
			for(ShipmentItemBilling billing:invoiceItem.getShipmentItemBillings())
			{
				ShipmentItem shipmentItem = shipmentItemRepo.findOne(billing.getShipmentItem().getId());
				if(shipmentItem != null)
				{
					for(ShipmentOrder order:shipmentItem.getOrders())
					{
						if(order.getId().equals(billing.getShipmentOrder().getId()))
							order.setInvoiced(true);
					}
					
					shipmentItemRepo.saveAndFlush(shipmentItem);
				}
			}
		}
		else if(invoiceItem.getType().equals(InvoiceItemType.INVOICE_WORK_EFFORT))
		{
			for(WorkEffortBilling billing:invoiceItem.getWorkEffortBillings())
			{
				BigDecimal amt = BigDecimal.ZERO;
				
				WorkEffort effort = effortRepo.findOne(billing.getEffort().getId());
				if(effort != null)
				{
					for(WorkOrderItemFulfillment fulfillment:effort.getItemFulfillments())
					{
						OrderItem item = orderItemRepo.findOne(fulfillment.getOrderItem().getId());
						if(item != null)
							amt = amt.add(item.getQuantity().multiply(item.getUntitPrice()));
					}

					BigDecimal paid = effortBillingRepo.findPaid(effort.getId());
					
					if(amt.compareTo(paid) <= 0)
						effort.setInvoiced(true);
				
					effortRepo.saveAndFlush(effort);
				}
			}
		}
	}

	@Secured("ROLE_PURCHASE_INVOICE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_PURCHASE_INVOICE_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
		{
			PurchaseInvoice invoice = findOne(id);
			if(invoice != null && !invoice.isPaid())
			{
				for(InvoiceItem invoiceItem:invoice.getItems())
					cleanRef(invoiceItem);
			}
			
			repository.delete(invoice);
		}
	}
	
	@Secured("ROLE_PURCHASE_INVOICE_DELETE")
	public void delItem(Collection<String> ids)
	{
		if(ids != null && !ids.isEmpty())
		{
			PurchaseInvoice invoice = repository.findOne(ids);
			if(invoice != null)
			{
				Iterator<InvoiceItem> iterator = invoice.getItems().iterator();
				while (iterator.hasNext())
				{
					InvoiceItem item = (InvoiceItem) iterator.next();
					for(String id:ids)
					{
						if(id.equals(item.getId()))
						{
							cleanRef(item);
							iterator.remove();
							break;
						}
					}
				}
				
				repository.saveAndFlush(invoice);
			}
		}
	}
	
	private void cleanRef(InvoiceItem invoiceItem)
	{
		if(invoiceItem.getType().equals(InvoiceItemType.INVOICE_PRODUCT) || invoiceItem.getType().equals(InvoiceItemType.INVOICE_PRODUCT_FEATURE) )
		{
			for(OrderItemBilling billing:invoiceItem.getOrderItemBillings())
			{
				OrderItem orderItem = orderItemRepo.findOne(billing.getOrderItem().getId());
				if(orderItem != null)
				{
					orderItem.removeInvoiceInfo(billing.getAmount());
					orderItemRepo.saveAndFlush(orderItem);
				}
			}
			
			for(ShipmentItemBilling billing:invoiceItem.getShipmentItemBillings())
			{
				ShipmentItem shipmentItem = shipmentItemRepo.findOne(billing.getShipmentItem().getId());
				if(shipmentItem != null)
				{
					for(ShipmentOrder order:shipmentItem.getOrders())
					{
						if(order.getId().equals(billing.getShipmentOrder().getId()))
							order.setInvoiced(false);
					}
					
					shipmentItemRepo.saveAndFlush(shipmentItem);
				}
			}
		}
		else if(invoiceItem.getType().equals(InvoiceItemType.INVOICE_WORK_EFFORT))
		{
			for(WorkEffortBilling billing:invoiceItem.getWorkEffortBillings())
			{
				WorkEffort effort = effortRepo.findOne(billing.getEffort().getId());
				if(effort != null)
				{
					effort.setInvoiced(false);
					effortRepo.saveAndFlush(effort);
				}
			}
		}
	}
	
	public void setPaidStatus(String id)
	{
		PurchaseInvoice invoice = repository.findOne(id);
		if(invoice != null && !invoice.isPaid())
		{
			BigDecimal amt = BigDecimal.ZERO;
			for(PaymentApplication app:appRepo.findAllByInvoiceId(invoice.getId()))
				amt = amt.add(app.getAmount());
		
			if(invoice.getSubtotal().compareTo(amt) <= 0)
			{
				InvoiceStatus status = new InvoiceStatus();
				status.setDate(DateTimes.timestamp());
				status.setInvoice(invoice);
				status.setType(InvoiceStatusType.PAID);
				
				invoice.getStatuses().add(status);
			
				edit(invoice);
			}
		}
	}
	
	public void setUnPaidStatus(String id)
	{
		PurchaseInvoice invoice = repository.findOne(id);
		
		if(invoice != null && invoice.isPaid())
		{
			Iterator<InvoiceStatus> iterator = invoice.getStatuses().iterator();
			while (iterator.hasNext())
			{
				InvoiceStatus status = (InvoiceStatus) iterator.next();
				if(status.getType().equals(InvoiceStatusType.PAID))
				{
					iterator.remove();
					break;
				}
			}
			
			edit(invoice);
		}
	}
	
	@Secured("ROLE_PURCHASE_INVOICE_CREATE")
	public Invoice fromPurchaseOrder(PurchaseOrder order)
	{
		//generate invoice
		PurchaseInvoice invoice = new PurchaseInvoice();
		invoice.setDate(order.getEntryDate());
		invoice.setMessage("Auto Generate by System");
		invoice.setNote("POS Order");
		invoice.addSendStatus();
		invoice.addEnterer(utils.getPerson().toRef());
		
		if(order.getType().equals(OrderType.DROPSHIP) || order.getType().equals(OrderType.STANDARD))
			invoice.addPaymentTerm(BigDecimal.valueOf(30));
		else
			invoice.addPaymentTerm(BigDecimal.ONE);
		
		//payer
		Party payer = partyRepo.findOne(order.getPartyPlacingOrder().getId());
		if(payer != null)
		{
			invoice.setBilledToParty(payer.toRef());
			invoice.setBilledToAddress(payer.getFirstAddress());
			invoice.setBilledToContact(payer.getFirstContact());
		}
		
		//party reguesting for payment
		Party receiver = partyRepo.findOne(order.getPartyTakingOrder().getId());
		if(receiver != null)
		{
			invoice.setBilledFromParty(receiver.toRef());
			invoice.setBilledFromAddress(receiver.getFirstAddress());
			invoice.setBilledFromContact(receiver.getFirstContact());
		}

		for(OrderAdjustment adjustment:order.getAdjustments())
		{
			InvoiceItem invoiceItem = new InvoiceItem();
			invoiceItem.setAmount(adjustment.getAmount());
			invoiceItem.setInvoice(invoice);
			invoiceItem.setQuantity(BigDecimal.ONE);
			invoiceItem.setTaxable(false);

			switch (adjustment.getType())
			{
				case DISCOUNT:
					invoiceItem.setType(InvoiceItemType.DISCOUNT_ADJUSTMENT);
					break;
				case HANDLINGCHARGE:
					invoiceItem.setType(InvoiceItemType.SHIPPING_AND_HANDLING_CHARGE_ADJUSTMENT);
					break;
				case SHIPPINGCHARGE:
					invoiceItem.setType(InvoiceItemType.SHIPPING_AND_HANDLING_CHARGE_ADJUSTMENT);
					break;
				case OTHERCHARGE:
					invoiceItem.setType(InvoiceItemType.MISCELLANEOUS_CHARGE_ADJUSTMENT);
					break;
				case SURCHARGE:
					invoiceItem.setType(InvoiceItemType.SURCHARGE_ADJUSTMENT);
					break;
				case TAX:
					invoiceItem.setType(InvoiceItemType.TAX_ADJUSTMENT);
					break;
				default:
					invoiceItem.setType(InvoiceItemType.INVOICE_ADJUSTMENT);
					break;
			}

			invoice.getItems().add(invoiceItem);
		}

		add(invoice);
		
		for(OrderItem item:order.getItems())
		{
			InvoiceItem invoiceItem = new InvoiceItem();
			invoiceItem.setAmount(item.getQuantity().multiply(item.getUntitPrice()));
			invoiceItem.setInvoice(invoice);
			invoiceItem.setFeature(item.getFeature());
			invoiceItem.setProduct(item.getProduct());
			invoiceItem.setQuantity(item.getQuantity());
			invoiceItem.setType(item.getFeature() != null?InvoiceItemType.INVOICE_PRODUCT_FEATURE:InvoiceItemType.INVOICE_PRODUCT);
			invoiceItem.setTaxable(true);
			
			invoice.getItems().add(invoiceItem);

			OrderItemBilling billing = new OrderItemBilling();
			billing.setAmount(invoiceItem.getAmount());
			billing.setItem(invoiceItem);
			billing.setOrder(order.toRef());
			billing.setOrderItem(item.toRef());
			billing.setQuantity(item.getQuantity());

			invoiceItem.getOrderItemBillings().add(billing);
			
			addItem(invoiceItem);
		}
		
		return invoice;
	}
}
