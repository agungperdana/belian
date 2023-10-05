
package com.kratonsolution.belian.invoice.svc;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.kratonsolution.belian.party.impl.orm.Party;
import com.kratonsolution.belian.party.impl.orm.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.dm.InvoiceItem;
import com.kratonsolution.belian.invoice.dm.InvoiceItemType;
import com.kratonsolution.belian.invoice.dm.InvoiceStatus;
import com.kratonsolution.belian.invoice.dm.InvoiceStatusType;
import com.kratonsolution.belian.invoice.dm.OrderItemBilling;
import com.kratonsolution.belian.invoice.dm.SalesInvoice;
import com.kratonsolution.belian.invoice.dm.SalesInvoiceRepository;
import com.kratonsolution.belian.invoice.dm.ShipmentItemBilling;
import com.kratonsolution.belian.invoice.dm.WorkEffortBilling;
import com.kratonsolution.belian.invoice.dm.WorkEffortBillingRepository;
import com.kratonsolution.belian.orders.dm.OrderAdjustment;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.dm.OrderItemInvoiceInfo;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.orders.dm.OrderTerm;
import com.kratonsolution.belian.orders.dm.OrderTermType;
import com.kratonsolution.belian.orders.dm.SalesOrder;
import com.kratonsolution.belian.payments.dm.PaymentApplication;
import com.kratonsolution.belian.payments.dm.PaymentApplicationRepository;
import com.kratonsolution.belian.shipment.dm.Shipment;
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
 * @since 1.0.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SalesInvoiceService extends AbstractService
{
	@Autowired
	private SalesInvoiceRepository repository;

	@Autowired
	private PaymentApplicationRepository appRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Autowired
	private ShipmentItemRepository shipmentItemRepo;
	
	@Autowired
	private PartyRepository partyRepo;
	
	@Autowired
	private WorkEffortRepository effortRepo;
	
	@Autowired
	private WorkEffortBillingRepository effortBillingRepo;
	
	@Secured("ROLE_SALES_INVOICE_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		return repository.count(utils.getOrganization().getId()).intValue();
	}

	@Secured("ROLE_SALES_INVOICE_READ")
	public int size(String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganization().getId()).intValue();
	}

	@Secured("ROLE_SALES_INVOICE_READ")
	public SalesInvoice getOne(String id)
	{
		return repository.getOne(id);
	}

	@Secured("ROLE_SALES_INVOICE_READ")
	public List<SalesInvoice> findAll()
	{
		return repository.findAll();
	}

	@Secured("ROLE_SALES_INVOICE_READ")
	public List<SalesInvoice> findAllUnpaid(String customer,String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		if(Strings.isNullOrEmpty(key))
			return repository.findAllUnpaid(utils.getOrganization().getId(),customer);
		
		return repository.findAllUnpaid(utils.getOrganization().getId(),customer,key);
	}

	@Secured("ROLE_SALES_INVOICE_READ")
	public List<SalesInvoice> findAll(String company,String customer,Date from,Date to)
	{
		if(Strings.isNullOrEmpty(company))
			return new ArrayList<>();

		return repository.findAll(company,customer,from,to);
	}
	
	@Secured("ROLE_SALES_INVOICE_READ")
	public List<SalesInvoice> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId());
	}

	@Secured("ROLE_SALES_INVOICE_READ")
	public List<SalesInvoice> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId(),key);
	}

	@Secured("ROLE_SALES_INVOICE_CREATE")
	public void add(SalesInvoice invoice)
	{
		invoice.setNumber(gen.generate(invoice.getDate(),invoice.getBilledFromParty().getId(),Code.SIV));
		repository.save(invoice);
	}

	@Secured("ROLE_SALES_INVOICE_UPDATE")
	public void edit(SalesInvoice invoice)
	{
		repository.saveAndFlush(invoice);
	}
	
	@Secured("ROLE_SALES_INVOICE_UPDATE")
	public void addItem(InvoiceItem invoiceItem)
	{
		repository.saveAndFlush((SalesInvoice)invoiceItem.getInvoice());
		
		if(invoiceItem.getType().equals(InvoiceItemType.INVOICE_PRODUCT) || invoiceItem.getType().equals(InvoiceItemType.INVOICE_PRODUCT_FEATURE) )
		{
			for(OrderItemBilling billing:invoiceItem.getOrderItemBillings())
			{
				OrderItem orderItem = orderItemRepo.getOne(billing.getOrderItem().getId());
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
				ShipmentItem shipmentItem = shipmentItemRepo.getOne(billing.getShipmentItem().getId());
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
				
				WorkEffort effort = effortRepo.getOne(billing.getEffort().getId());
				if(effort != null)
				{
					for(WorkOrderItemFulfillment fulfillment:effort.getItemFulfillments())
					{
						OrderItem item = orderItemRepo.getOne(fulfillment.getOrderItem().getId());
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

	@Secured("ROLE_SALES_INVOICE_DELETE")
	public void delete(String id)
	{
		SalesInvoice invoice = getOne(id);
		if(invoice != null)
		{
			if(invoice.isPaid())
				throw new RuntimeException("Please Delete receipt first!");
			
			for(InvoiceItem invoiceItem:invoice.getItems())
				cleanRef(invoiceItem);
		}
		
		repository.delete(invoice);
	}
	
	@Secured("ROLE_SALES_INVOICE_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
	
	@Secured("ROLE_SALES_INVOICE_DELETE")
	public void delItem(Collection<String> ids)
	{
		if(ids != null && !ids.isEmpty())
		{
			SalesInvoice invoice = repository.getOne(ids);
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
				OrderItem orderItem = orderItemRepo.getOne(billing.getOrderItem().getId());
				if(orderItem != null)
				{
					orderItem.removeInvoiceInfo(billing.getAmount());
					orderItemRepo.saveAndFlush(orderItem);
				}
			}
			
			for(ShipmentItemBilling billing:invoiceItem.getShipmentItemBillings())
			{
				ShipmentItem shipmentItem = shipmentItemRepo.getOne(billing.getShipmentItem().getId());
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
				WorkEffort effort = effortRepo.getOne(billing.getEffort().getId());
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
		SalesInvoice invoice = repository.getOne(id);
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
		SalesInvoice invoice = repository.getOne(id);
		
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
	
	@Secured("ROLE_SALES_INVOICE_CREATE")
	public Invoice generate(Shipment shipment)
	{
		/**
		 * Create invoice 
		 */
		SalesInvoice invoice = new SalesInvoice();
		invoice.setDate(shipment.getEntryDate());

		invoice.setBilledToParty(shipment.getShipToParty());
		invoice.setBilledToAddress(shipment.getShipToAddress());
		invoice.setBilledToContact(shipment.getShipToContact());

		invoice.setBilledFromParty(shipment.getShipFromParty());
		invoice.setBilledFromAddress(shipment.getShipFromAddress());
		invoice.setBilledFromContact(shipment.getShipFromContact());

		add(invoice);
		
		for(ShipmentItem item:shipment.getItems())
		{
			for(ShipmentOrder order:item.getOrders())
			{
				OrderItem out = orderItemRepo.getOne(order.getId());
				if(out != null)
				{
					InvoiceItem invoiceItem = new InvoiceItem();
					invoiceItem.setAmount(order.getQuantity().multiply(out.getUntitPrice()));
					invoiceItem.setInvoice(invoice);
					invoiceItem.setFeature(out.getFeature());
					invoiceItem.setProduct(out.getProduct());
					invoiceItem.setQuantity(order.getQuantity());
					invoiceItem.setType(out.getFeature() != null?InvoiceItemType.INVOICE_PRODUCT_FEATURE:InvoiceItemType.INVOICE_PRODUCT);

					invoice.getItems().add(invoiceItem);

					ShipmentItemBilling billing = new ShipmentItemBilling();
					billing.setItem(invoiceItem);
					billing.setShipment(shipment.toRef());
					billing.setShipmentItem(item.toRef());

					invoiceItem.getShipmentItemBillings().add(billing);
				
					addItem(invoiceItem);
				}
			}
		}
		
		return invoice;
	}
	
	@Secured("ROLE_SALES_INVOICE_CREATE")
	public Invoice generate(SalesOrder salesOrder)
	{
		/**
		 * Create invoice 
		 */
		SalesInvoice invoice = new SalesInvoice();
		invoice.setDate(salesOrder.getEntryDate());
		invoice.addSendStatus();
		invoice.setBilledToParty(salesOrder.getBillToParty());
		invoice.setBilledToAddress(salesOrder.getBillToAddress());
		invoice.setBilledToContact(salesOrder.getBillToContact());
		
		Party source = partyRepo.getOne(salesOrder.getPartyTakingOrder().getId());
		if(source != null)
		{
			invoice.setBilledFromParty(source.toRef());
			invoice.setBilledFromAddress(source.getFirstAddress());
			invoice.setBilledFromContact(source.getFirstContact());
		}
		
		for(OrderTerm orderTerm:salesOrder.getTerms())
		{
			if(orderTerm.getType().equals(OrderTermType.CREDIT_TERM))
			{
				invoice.addPaymentTerm(orderTerm.getAmount());
				break;
			}
		}

		for(OrderAdjustment adjustment:salesOrder.getAdjustments())
		{
			InvoiceItem invoiceItem = new InvoiceItem();
			invoiceItem.setAmount(adjustment.getAmount());
			invoiceItem.setInvoice(invoice);
			invoiceItem.setQuantity(BigDecimal.ONE);

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
		
		for(OrderItem item:salesOrder.getItems())
		{
			InvoiceItem invoiceItem = new InvoiceItem();
			invoiceItem.setAmount(item.getQuantity().multiply(item.getUntitPrice()));
			invoiceItem.setInvoice(invoice);
			invoiceItem.setFeature(item.getFeature());
			invoiceItem.setProduct(item.getProduct());
			invoiceItem.setQuantity(item.getQuantity());
			invoiceItem.setType(item.getFeature() != null?InvoiceItemType.INVOICE_PRODUCT_FEATURE:InvoiceItemType.INVOICE_PRODUCT);

			invoice.getItems().add(invoiceItem);

			OrderItemBilling billing = new OrderItemBilling();
			billing.setAmount(invoiceItem.getAmount());
			billing.setItem(invoiceItem);
			billing.setOrder(salesOrder.toRef());
			billing.setOrderItem(item.toRef());
			billing.setQuantity(item.getQuantity());

			invoiceItem.getOrderItemBillings().add(billing);
			
			addItem(invoiceItem);
		}
		
		return invoice;
	}
}
