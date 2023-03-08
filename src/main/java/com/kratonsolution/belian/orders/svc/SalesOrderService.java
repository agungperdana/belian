
package com.kratonsolution.belian.orders.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.svc.PurchaseInvoiceService;
import com.kratonsolution.belian.invoice.svc.SalesInvoiceService;
import com.kratonsolution.belian.orders.dm.OrderItemType;
import com.kratonsolution.belian.orders.dm.PurchaseOrder;
import com.kratonsolution.belian.orders.dm.SalesOrder;
import com.kratonsolution.belian.orders.dm.SalesOrderItem;
import com.kratonsolution.belian.orders.dm.SalesOrderRepository;
import com.kratonsolution.belian.partys.svc.PartyService;
import com.kratonsolution.belian.payments.dm.PaymentMethodInfo;
import com.kratonsolution.belian.payments.dm.Receipt;
import com.kratonsolution.belian.payments.svc.ReceiptService;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductRepository;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentStatusType;
import com.kratonsolution.belian.shipment.dm.ShipmentType;
import com.kratonsolution.belian.shipment.svc.ShipmentIssuanceService;
import com.kratonsolution.belian.shipment.svc.ShipmentService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SalesOrderService extends AbstractService
{
	@Autowired
	private SalesOrderRepository repository;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private PartyService partyService;

	@Autowired
	private SalesInvoiceService salesInvoiceService;

	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private ShipmentIssuanceService issuanceService;

	@Autowired
	private PurchaseOrderService poService;

	@Autowired
	private PurchaseInvoiceService purchaseInvoiceService;

	@Secured("ROLE_SALES_ORDER_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		return repository.count(utils.getOrganizationIds()).intValue();
	}

	@Secured("ROLE_SALES_ORDER_READ")
	public int size(String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganizationIds(),key).intValue();
	}

	@Secured("ROLE_SALES_ORDER_READ")
	public SalesOrder getOne(String id)
	{
		return repository.getOne(id);
	}

	@Secured("ROLE_SALES_ORDER_READ")
	public List<SalesOrder> findAll()
	{
		return repository.findAll();
	}


	@Secured("ROLE_SALES_ORDER_READ")
	public List<SalesOrder> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganizationIds());
	}

	@Secured("ROLE_SALES_ORDER_READ")
	public List<SalesOrder> findAllInvoiceable(String customer)
	{
		if(utils.getOrganization() == null || Strings.isNullOrEmpty(customer))
			return new ArrayList<>();

		return repository.findAllInvoiceable(utils.getOrganization().getId(),customer);
	}

	@Secured("ROLE_SALES_ORDER_READ")
	public List<SalesOrder> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganizationIds(),key);
	}

	public List<SalesOrderItem> findAllForWorkEffort()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();

		return repository.findAllForWorkEffort(utils.getOrganization().getId());
	}

	@Secured("ROLE_SALES_ORDER_CREATE")
	public void add(SalesOrder order)
	{
		//generate document code & save the order
		order.setNumber(gen.generate(order.getEntryDate(),utils.getOrganization().getId(),Code.SO));
		repository.save(order);
	}
	
	@Secured("ROLE_SALES_ORDER_CREATE")
	public String pos(SalesOrder order,PaymentMethodInfo info)
	{
		add(order);
		
		return doPos(order,info);
	}

	@Secured("ROLE_SALES_ORDER_CREATE")
	public void addItem(SalesOrderItem orderItem)
	{
		Product product = productRepo.getOne(orderItem.getProduct().getId());
		if(product.isService())
			orderItem.setType(OrderItemType.WORK);

		SalesOrder out = repository.getOne(orderItem.getOrder().getId());
		if(out != null)
		{
			orderItem.setOrder(out);
			out.getItems().add(orderItem);

			repository.save(out);
		}
	}

	@Secured("ROLE_SALES_ORDER_UPDATE")
	public void edit(SalesOrder SalesOrder)
	{
		repository.saveAndFlush(SalesOrder);
	}

	@Secured("ROLE_SALES_ORDER_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}

	/**
	 * Point of sales with available stock.
	 * user order,shipping,invoicing & receipt
	 * happening almost at the same time and place
	 * 
	 * @param order
	 * @return
	 */
	@Secured("ROLE_SALES_ORDER_CREATE")
	public String doPos(SalesOrder order,PaymentMethodInfo info)
	{
		//generate shipment
		Shipment shipment = shipmentService.fromOrder(order,ShipmentType.CUSTOMER_SHIPMENT,ShipmentStatusType.DELIVERED);

		//generate shipment item
		issuanceService.fromShipment(shipment);

		//Create invoice
		Invoice invoice = salesInvoiceService.generate(order);

		//generate payment if term is 1 day
		if(order.isCash())
			return receiptService.fromInvoice(invoice,info).getId();
		else
			return invoice.getId();
	}

	/**
	 * Standard sales with drop shipment
	 * (shipping party deference from placing order party)
	 * 
	 * @param order
	 * @return
	 */
	@Secured("ROLE_SALES_ORDER_CREATE")
	public String doDropship(SalesOrder order,IDValueRef supplier,PaymentMethodInfo info)
	{
		//generate document code & save the order
		order.setNumber(gen.generate(order.getEntryDate(),utils.getOrganization().getId(),Code.SO));
		repository.save(order);

		//create invoice
		Invoice invoice = salesInvoiceService.generate(order);
		
		//create receipt
		Receipt receipt = receiptService.fromInvoice(invoice,info);
		
		//create purchase order
		PurchaseOrder po = poService.create(order, supplier);

		//invoice from purchase order
		purchaseInvoiceService.fromPurchaseOrder(po);

		return receipt.getId();
	}
}
