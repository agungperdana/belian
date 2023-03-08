
package com.kratonsolution.belian.orders.svc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.invoice.svc.PurchaseInvoiceService;
import com.kratonsolution.belian.orders.dm.Order;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.dm.OrderItemType;
import com.kratonsolution.belian.orders.dm.OrderRole;
import com.kratonsolution.belian.orders.dm.OrderRoleType;
import com.kratonsolution.belian.orders.dm.OrderStatus;
import com.kratonsolution.belian.orders.dm.OrderTerm;
import com.kratonsolution.belian.orders.dm.OrderTermType;
import com.kratonsolution.belian.orders.dm.OrderType;
import com.kratonsolution.belian.orders.dm.PurchaseOrder;
import com.kratonsolution.belian.orders.dm.PurchaseOrderItem;
import com.kratonsolution.belian.orders.dm.PurchaseOrderRepository;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyRepository;
import com.kratonsolution.belian.payments.svc.DisbursementService;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductComponent;
import com.kratonsolution.belian.products.dm.ProductRepository;
import com.kratonsolution.belian.products.dm.ProductType;
import com.kratonsolution.belian.shipment.dm.ShipmentStatusType;
import com.kratonsolution.belian.shipment.dm.ShipmentType;
import com.kratonsolution.belian.shipment.svc.ShipmentReceiptService;
import com.kratonsolution.belian.shipment.svc.ShipmentService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PurchaseOrderService extends AbstractService
{
	@Autowired
	private PurchaseOrderRepository repository;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private PartyRepository partyRepo;
	
	@Autowired
	private ShipmentService shipmentService;
	
	@Autowired
	private ShipmentReceiptService receiptService;
	
	@Autowired
	private PurchaseInvoiceService invoiceService;
	
	@Autowired
	private DisbursementService disbursementService;
	
	@Secured("ROLE_PURCHASE_ORDER_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		return repository.count(utils.getOrganizationIds()).intValue();
	}

	@Secured("ROLE_PURCHASE_ORDER_READ")
	public int size(String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganizationIds(),key).intValue();
	}

	@Secured("ROLE_PURCHASE_ORDER_READ")
	public PurchaseOrder getOne(String id)
	{
		return repository.getOne(id);
	}

	@Secured("ROLE_PURCHASE_ORDER_READ")
	public List<PurchaseOrder> findAll()
	{
		return repository.findAll();
	}


	@Secured("ROLE_PURCHASE_ORDER_READ")
	public List<PurchaseOrder> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganizationIds());
	}

	@Secured("ROLE_PURCHASE_ORDER_READ")
	public List<PurchaseOrder> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganizationIds(),key);
	}

	@Secured("ROLE_PURCHASE_ORDER_READ")
	public List<PurchaseOrder> findAllInvoiceable(String supplier)
	{
		if(utils.getOrganization() == null || Strings.isNullOrEmpty(supplier))
			return new ArrayList<>();
		
		return repository.findAllInvoiceable(utils.getOrganization().getId(),supplier);
	}
	
	@Secured("ROLE_PURCHASE_ORDER_CREATE")
	public void add(PurchaseOrder order)
	{
		order.setNumber(gen.generate(order.getEntryDate(), utils.getOrganization().getId(), Code.PO));
		repository.save(order);
	}
	
	@Secured("ROLE_PURCHASE_ORDER_CREATE")
	public void cash(PurchaseOrder order)
	{
		OrderRole orderRole = new OrderRole();
		orderRole.setOrder(order);
		orderRole.setPerson(utils.getPerson().toRef());
		orderRole.setType(OrderRoleType.PROCESSOR);
		
		order.getPartyOrderRoles().add(orderRole);
		
		OrderStatus created = new OrderStatus();
		created.setDate(DateTimes.timestamp());
		created.setOrder(order);
		created.setType(StatusType.CREATED);
		
		OrderStatus done = new OrderStatus();
		done.setDate(DateTimes.timestamp());
		done.setOrder(order);
		done.setType(StatusType.DONE);
		
		order.getStatuses().add(created);
		order.getStatuses().add(done);
		
		OrderTerm term = new OrderTerm();
		term.setAmount(BigDecimal.ONE);
		term.setOrder(order);
		term.setType(OrderTermType.CREDIT_TERM);
		
		order.getTerms().add(term);
		
		add(order);
		
		shipmentService.fromOrder(order,ShipmentType.PURCHASE_SHIPMENT,ShipmentStatusType.SHIPPED);
		disbursementService.fromInvoice(invoiceService.fromPurchaseOrder(order));
	}
	
	@Secured("ROLE_PURCHASE_ORDER_CREATE")
	public void addItem(PurchaseOrderItem item)
	{
		Product product = productRepo.getOne(item.getProduct().getId());
		if(product != null && product.isService())
			item.setType(OrderItemType.WORK);
		
		PurchaseOrder out = repository.getOne(item.getOrder().getId());
		if(out != null)
		{
			item.setOrder(out);
			out.getItems().add(item);
			
			repository.save(out);
		}
	}

	@Secured("ROLE_PURCHASE_ORDER_UPDATE")
	public void edit(PurchaseOrder PurchaseOrder)
	{
		repository.saveAndFlush(PurchaseOrder);
	}

	@Secured("ROLE_PURCHASE_ORDER_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
	
	@Secured("ROLE_PURCHASE_ORDER_CREATE")
	public PurchaseOrder create(Order order,IDValueRef supplier)
	{
		if(supplier == null)
			throw new RuntimeException("Supplier cannot be empty!");
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setType(OrderType.DROPSHIP);
		purchaseOrder.setCurrency(utils.getCurrency().toRef());
		purchaseOrder.setEntryDate(order.getEntryDate());
		purchaseOrder.setOrderDate(order.getEntryDate());
		purchaseOrder.setPartyPlacingOrder(order.getPartyTakingOrder());
		purchaseOrder.setPartyTakingOrder(supplier);
		purchaseOrder.addMonthTerm();

		purchaseOrder.setShipToParty(order.getShipToParty());
		purchaseOrder.setShipToAddress(order.getShipToAddress());
		purchaseOrder.setShipToContact(order.getShipToContact());
		
		//payer
		Party payer = partyRepo.getOne(order.getPartyTakingOrder().getId());
		if(payer != null)
		{
			purchaseOrder.setBillToParty(payer.toRef());
			purchaseOrder.setBillToAddress(payer.getFirstAddress());
			purchaseOrder.setBillToContact(payer.getFirstContact());
		}
		
		//order item
		for(OrderItem item:order.getItems())
		{
			Product product = productRepo.getOne(item.getProduct().getId());
			if(product != null)
				createItem(purchaseOrder, item.getQuantity(),item.getUntitPrice(), product);
		}
		
		//order role
		OrderRole role = new OrderRole();
		role.setOrder(purchaseOrder);
		role.setPerson(utils.getPerson().toRef());
		role.setType(OrderRoleType.SALESPERSON);
		
		purchaseOrder.getPartyOrderRoles().add(role);
		
		add(purchaseOrder);
				
		return purchaseOrder;
	}

	private void createItem(PurchaseOrder purchaseOrder, BigDecimal quantity,BigDecimal unitPrice, Product product)
	{
		if(product.getType().equals(ProductType.FINISH_GOODS))
		{
			PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
			purchaseOrderItem.setOrder(purchaseOrder);
			purchaseOrderItem.setProduct(product.toRef());
			purchaseOrderItem.setQuantity(quantity);
			purchaseOrderItem.setType(OrderItemType.PRODUCT);
			purchaseOrderItem.setUntitPrice(unitPrice);
			purchaseOrderItem.setUom(product.getUom());
			
			purchaseOrder.getItems().add(purchaseOrderItem);
		}
		else
		{
			for(ProductComponent comp:product.getComponents())
				createItem(purchaseOrder, quantity.multiply(comp.getQuantity()),unitPrice, product);
		}
	}
}
