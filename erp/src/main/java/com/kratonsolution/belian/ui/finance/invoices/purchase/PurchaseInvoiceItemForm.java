
package com.kratonsolution.belian.ui.finance.invoices.purchase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Vector;

import com.google.common.base.Strings;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Observer;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.invoice.dm.InvoiceItem;
import com.kratonsolution.belian.invoice.dm.InvoiceItemType;
import com.kratonsolution.belian.invoice.dm.OrderItemBilling;
import com.kratonsolution.belian.invoice.dm.PurchaseInvoice;
import com.kratonsolution.belian.invoice.dm.ShipmentItemBilling;
import com.kratonsolution.belian.invoice.dm.WorkEffortBilling;
import com.kratonsolution.belian.invoice.dm.WorkEffortBillingRepository;
import com.kratonsolution.belian.invoice.svc.PurchaseInvoiceService;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.svc.OrderItemService;
import com.kratonsolution.belian.orders.svc.PurchaseOrderService;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentOrder;
import com.kratonsolution.belian.shipment.svc.ShipmentItemService;
import com.kratonsolution.belian.shipment.svc.ShipmentOrderService;
import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.finance.invoices.InvoiceItemList;
import com.kratonsolution.belian.ui.finance.invoices.InvoiceItemTypeList;
import com.kratonsolution.belian.ui.products.feature.ProductFeatureList;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;
import com.kratonsolution.belian.workefforts.dm.WorkEffort;
import com.kratonsolution.belian.workefforts.dm.WorkOrderItemFulfillment;
import com.kratonsolution.belian.workefforts.svc.WorkEffortService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseInvoiceItemForm extends AbstractForm
{	
	private PurchaseOrderService purchaseOrderService = Springs.get(PurchaseOrderService.class);
	
	private OrderItemService orderItemService = Springs.get(OrderItemService.class);
	
	private ShipmentItemService shipmentItemService = Springs.get(ShipmentItemService.class);
	
	private ShipmentOrderService shipmentOrderService = Springs.get(ShipmentOrderService.class);
	
	private ShipmentService shipmentService = Springs.get(ShipmentService.class);
	
	private WorkEffortService workEffortService = Springs.get(WorkEffortService.class);
	
	private PurchaseInvoiceService service = Springs.get(PurchaseInvoiceService.class);

	private WorkEffortBillingRepository effortBillingRepository = Springs.get(WorkEffortBillingRepository.class);
	
	private InvoiceItemTypeList itemTypeList = new InvoiceItemTypeList(false);
	
	private ProductBox product = new ProductBox(false);
	
	private ProductFeatureList featureList = new ProductFeatureList(false);
	
	private Textbox quantity = Components.blueText(BigDecimal.ONE,false);
	
	private Textbox amount = Components.blueText(BigDecimal.ZERO,false);
	
	private Checkbox taxable = Components.checkbox(false);
	
	private InvoiceItemList invoiceItemList = new InvoiceItemList(false);
	
	private Vlayout content = new Vlayout();
	
	private Grid orders = new Grid();
	
	private Grid shipments = new Grid();
	
	private Grid entrys = new Grid();
	
	private Grid efforts = new Grid();

	private PurchaseInvoice invoice;

	private ProductObserver observer = new ProductObserver();
	
	private Tabbox tabbox = new Tabbox();
	
	public PurchaseInvoiceItemForm(PurchaseInvoice invoice)
	{
		super();
		
		this.invoice = invoice;
		
		initToolbar();
		initForm();
		initDetails();
		
		product.addObserver(new ProductObserver());
		itemTypeList.addObserver(new TypeObserver());
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new PurchaseInvoiceEditContent(RowUtils.shield(invoice.getId())));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PurchaseInvoice out = service.findById(invoice.getId());
				if(out != null)
				{
					InvoiceItem invoiceItem = new InvoiceItem();
					invoiceItem.setInvoice(out);
					invoiceItem.setAmount(Components.decimal(amount));
					invoiceItem.setQuantity(Components.decimal(quantity));
					invoiceItem.setTaxable(taxable.isChecked());
					invoiceItem.setType(itemTypeList.getDomain());
					
					if(invoiceItem.getType().equals(InvoiceItemType.INVOICE_PRODUCT))
					{
						invoiceItem.setProduct(product.getDomainAsRef());
						
						for(Component com:orders.getRows().getChildren())
						{
							Row row = (Row)com;
							if(RowUtils.isChecked(row))
							{
								OrderItem orderItem = orderItemService.findById(RowUtils.id(row));
								if(orderItem != null)
								{
									OrderItemBilling billing = new OrderItemBilling();
									billing.setAmount(orderItem.getQuantity().multiply(orderItem.getUntitPrice()));
									billing.setItem(invoiceItem);
									billing.setOrderItem(orderItem.toRef());
									billing.setQuantity(orderItem.getQuantity());
									billing.setOrder(orderItem.getOrder().toRef());
									
									invoiceItem.getOrderItemBillings().add(billing);
								}
							}
						}
						
						for(Component com:shipments.getRows().getChildren())
						{
							Row row = (Row)com;
							if(RowUtils.isChecked(row))
							{
								ShipmentOrder order = shipmentOrderService.findById(RowUtils.id(row));
								if(order != null)
								{
									ShipmentItemBilling billing = new ShipmentItemBilling();
									billing.setItem(invoiceItem);
									billing.setShipment(order.getShipmentItem().getShipment().toRef());
									billing.setShipmentItem(order.getShipmentItem().toRef());
									billing.setShipmentOrder(order.toRef());
									
									invoiceItem.getShipmentItemBillings().add(billing);
								}
							}
						}
					}
					else if(invoiceItem.getType().equals(InvoiceItemType.INVOICE_PRODUCT_FEATURE))
					{
						invoiceItem.setFeature(featureList.getDomainAsRef());
						invoiceItem.setSoldWith(invoiceItemList.getDomain());
					}
					else if(invoiceItem.getType().equals(InvoiceItemType.INVOICE_WORK_EFFORT))
					{
						for(Component com:efforts.getRows().getChildren())
						{
							Row rw = (Row)com;
							if(RowUtils.isChecked(rw))
							{
								WorkEffort effort = workEffortService.findById(RowUtils.id(rw));
								if(effort != null)
								{
									WorkEffortBilling billing = new WorkEffortBilling();
									billing.setEffort(effort.toRef());
									billing.setItem(invoiceItem);
									billing.setAmount(RowUtils.decimal(rw, 9));
									billing.setPercent(RowUtils.decimal(rw, 10));
									
									if(billing.getPercent().compareTo(BigDecimal.ZERO) > 0)
										billing.setAmount(billing.getPercent().multiply(RowUtils.decimal(rw, 8)).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP));
									
									invoiceItem.getWorkEffortBillings().add(billing);
								}
							}
						}
					}
					
					out.getItems().add(invoiceItem);
					
					service.addItem(invoiceItem);
				}
				
				Flow.next(getParent(), new PurchaseInvoiceEditContent(RowUtils.shield(invoice.getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("invoices.grid.column.type")));
		row1.appendChild(itemTypeList);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("invoices.grid.column.product")));
		row2.appendChild(product);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("invoices.grid.column.feature")));
		row3.appendChild(featureList);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("invoices.grid.column.soldwith")));
		row4.appendChild(invoiceItemList);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("invoices.grid.column.quantity")));
		row5.appendChild(quantity);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("invoices.grid.column.amount")));
		row6.appendChild(amount);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("invoices.grid.column.taxable")));
		row7.appendChild(taxable);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		
		rows.getChildren().get(1).setVisible(false);
		rows.getChildren().get(2).setVisible(false);
		rows.getChildren().get(3).setVisible(false);
	
		appendChild(content);
	}
	
	private void initDetails()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("invoices.grid.column.shipmentitems")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().getLastChild().appendChild(shipments);
		
		orders.setWidth("100%");
		orders.setEmptyMessage(lang.get("message.grid.empty"));
		orders.appendChild(new Columns());
		orders.appendChild(new Rows());
		orders.getColumns().appendChild(new Column(null,null,"25px"));
		orders.getColumns().appendChild(new Column(lang.get("invoices.grid.column.date"),null,"85px"));
		orders.getColumns().appendChild(new Column(lang.get("invoices.grid.column.number"),null,"100px"));
		orders.getColumns().appendChild(new Column(lang.get("invoices.grid.column.product"),null,"100px"));
		orders.getColumns().appendChild(new Column(lang.get("invoices.grid.column.quantity"),null,"75px"));
		orders.getColumns().appendChild(new Column(lang.get("invoices.grid.column.price"),null,"125px"));
		orders.getColumns().appendChild(new Column());
		orders.getColumns().getLastChild().setVisible(false);
		orders.setSpan("3");
		
		shipments.setWidth("100%");
		shipments.setEmptyMessage(lang.get("message.grid.empty"));
		shipments.appendChild(new Columns());
		shipments.appendChild(new Rows());
		shipments.getColumns().appendChild(new Column(null,null,"25px"));
		shipments.getColumns().appendChild(new Column(lang.get("invoices.grid.column.date"),null,"85px"));
		shipments.getColumns().appendChild(new Column(lang.get("invoices.grid.column.number"),null,"125px"));
		shipments.getColumns().appendChild(new Column(lang.get("invoices.grid.column.product"),null,"100px"));
		shipments.getColumns().appendChild(new Column(lang.get("invoices.grid.column.quantity"),null,"75px"));
		shipments.getColumns().appendChild(new Column(lang.get("invoices.grid.column.price"),null,"125px"));
		shipments.getColumns().appendChild(new Column(lang.get("order.items.grid.column.amount"),null,"85px"));
		shipments.getColumns().appendChild(new Column());
		shipments.getColumns().getLastChild().setVisible(false);
		shipments.setSpan("3"); 
		
		efforts.setWidth("100%");
		efforts.setEmptyMessage(lang.get("message.grid.empty"));
		efforts.appendChild(new Columns());
		efforts.appendChild(new Rows());
		efforts.getColumns().appendChild(new Column(null,null,"25px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.grid.column.entrydate"),null,"80px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.grid.column.number"),null,"120px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.items.grid.column.product"),null,"125px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"55px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.items.grid.column.unitprice"),null,"85px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.items.grid.column.amount"),null,"85px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.items.grid.column.paid"),null,"85px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.items.grid.column.owed"),null,"85px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.items.grid.column.invamt"),null,"100px"));
		efforts.getColumns().appendChild(new Column(lang.get("order.items.grid.column.invpercent"),null,"85px"));
		efforts.getColumns().appendChild(new Column());
		efforts.getColumns().getLastChild().setVisible(false);
		efforts.setSpan("3");
	}
	
	private class TypeObserver implements Observer
	{
		@Override
		public void valueChange(IDValueRef value)
		{
			if(value != null && !Strings.isNullOrEmpty(value.getId()))
			{
				rows.getChildren().get(1).setVisible(false);
				rows.getChildren().get(2).setVisible(false);
				rows.getChildren().get(3).setVisible(false);
				
				InvoiceItemType type = InvoiceItemType.valueOf(value.getId());
				switch (type)
				{
					case INVOICE_PRODUCT:
						rows.getChildren().get(1).setVisible(true);
						rows.getChildren().get(2).setVisible(false);
						rows.getChildren().get(3).setVisible(false);
					break;
					case INVOICE_PRODUCT_FEATURE:
						featureList.setSelectedItem(null);
						
						rows.getChildren().get(1).setVisible(false);
						rows.getChildren().get(2).setVisible(true);
						rows.getChildren().get(3).setVisible(true);
					break;
					case INVOICE_WORK_EFFORT:
						initEfforts();
					break;
					default:
						
					break;
				}
			}
		}
	}
	
	private class ProductObserver implements Observer
	{		
		@Override
		public void valueChange(IDValueRef value)
		{
			initProduct();
		}
	}
	
	private void initEfforts()
	{
		OrderItemService orderItemService = Springs.get(OrderItemService.class);
		
		content.getChildren().clear();
		efforts.getRows().getChildren().clear();
		
		for(WorkEffort effort:workEffortService.findAllUninvoiced())
		{
			BigDecimal quan = BigDecimal.ZERO;
			BigDecimal amt = BigDecimal.ZERO;
			
			Vector<Row> rows = new Vector<>();
			
			for(WorkOrderItemFulfillment fulfillment:effort.getItemFulfillments())
			{
				OrderItem orderItem = orderItemService.findById(fulfillment.getOrderItem().getId());
				if(orderItem != null && orderItem.getOrder().getBillToParty().getId().equals(invoice.getBilledToParty().getId()))
				{
					Row row = new Row();
					row.appendChild(new Label());
					row.appendChild(new Label());
					row.appendChild(new Label(orderItem.getOrder().getNumber()));
					row.appendChild(new Label(orderItem.getProduct().getValue()));
					row.appendChild(Components.label(orderItem.getQuantity()));
					row.appendChild(Components.label(orderItem.getUntitPrice()));
					row.appendChild(Components.label(orderItem.getQuantity().multiply(orderItem.getUntitPrice())));
					row.appendChild(new Label());
					row.appendChild(new Label());
					row.appendChild(new Label());
					row.appendChild(new Label());
					row.appendChild(new Label());
					
					rows.add(row);
					
					quan = quan.add(orderItem.getQuantity());
					amt = amt.add(orderItem.getQuantity().multiply(orderItem.getUntitPrice()));
				}
			}

			if(!rows.isEmpty())
			{
				Checkbox check = Components.checkbox(false);
				check.addEventListener(Events.ON_CHECK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						calculate();
					}
				});
				
				BigDecimal paid = effortBillingRepository.findPaid(effort.getId());
				if(paid == null)
					paid = BigDecimal.ZERO;
				
				BigDecimal owed = amt.subtract(paid);
				
				Row row = new Row();
				row.appendChild(check);
				row.appendChild(new Label(DateTimes.format(effort.getCreationDate())));
				row.appendChild(new Label(effort.getNumber()));
				row.appendChild(new Label(effort.getName()));
				row.appendChild(Components.blueNumeric(quan));
				row.appendChild(new Label());
				row.appendChild(Components.blueNumeric(amt));
				row.appendChild(Components.blueNumeric(paid));
				row.appendChild(Components.blueNumeric(owed));
				row.appendChild(Components.fullspanDecimalbox(owed));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
				row.appendChild(new Label(effort.getId()));
				
				efforts.getRows().appendChild(row);
				
				for(Row rw:rows)
					efforts.getRows().appendChild(rw);
			}
		}
		
		content.appendChild(efforts);
	}
	
	private void initProduct()
	{
		if(product.getDomain() != null)
		{
			content.getChildren().clear();
			
			shipments.getRows().getChildren().clear();

			for(Shipment shipment:shipmentService.forPurchaseInvoice(invoice.getBilledFromParty().getId()))
			{
				if(shipment.isDelivered())
				{
					for(ShipmentItem item:shipment.getItems())
					{
						for(ShipmentOrder order:item.getOrders())
						{
							if(!order.isInvoiced())
							{
								OrderItem orderItem = orderItemService.findById(order.getOrderItem().getId());
								if(orderItem != null && product.getDomain().getId().equals(item.getProduct().getId()))
								{
									Checkbox check = Components.checkbox(false);
									check.addEventListener(Events.ON_CHECK, new EventListener<Event>()
									{
										@Override
										public void onEvent(Event arg0) throws Exception
										{
											calculate();
										}
									});
									
									Row row = new Row();
									row.appendChild(check);
									row.appendChild(new Label(DateTimes.format(orderItem.getOrder().getEntryDate())));
									row.appendChild(new Label(orderItem.getOrder().getNumber()));
									row.appendChild(new Label(orderItem.getProduct().getValue()));
									row.appendChild(Components.blueNumeric(order.getQuantity()));
									row.appendChild(Components.blueNumeric(order.getUnitPrice()));
									row.appendChild(Components.blueNumeric(order.getUnitPrice().multiply(order.getQuantity())));
									row.appendChild(new Label(order.getId()));
									
									shipments.getRows().appendChild(row);
								}								
							}
						}
					}
				}
			}
			
			content.appendChild(tabbox);
		}
	}
	
	private void calculate()
	{
		if(itemTypeList.getDomain() == null)
			throw new WrongValueException(itemTypeList,lang.get("message.field.empty"));
		
		BigDecimal quan = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;
		
		if(itemTypeList.getDomain().equals(InvoiceItemType.INVOICE_PRODUCT) || itemTypeList.getDomain().equals(InvoiceItemType.INVOICE_PRODUCT_FEATURE))
		{
			for(Component com:orders.getRows().getChildren())
			{
				Row row = (Row)com;
				
				if(RowUtils.isChecked(row))
				{
					quan = quan.add(RowUtils.decimal(row, 4));
					total = total.add(RowUtils.decimal(row, 4).multiply(RowUtils.decimal(row, 5)));
				}
			}
			
			for(Component com:shipments.getRows().getChildren())
			{
				Row row = (Row)com;
				
				if(RowUtils.isChecked(row))
				{
					quan = quan.add(RowUtils.decimal(row, 4));
					total = total.add(RowUtils.decimal(row, 6));
				}
			}
		}
		else if(itemTypeList.getDomain().equals(InvoiceItemType.INVOICE_WORK_EFFORT))
		{
			for(Component com:efforts.getRows().getChildren())
			{
				Row row = (Row)com;
				
				if(RowUtils.isChecked(row))
				{
					quan = quan.add(RowUtils.decimal(row, 4));
					
					BigDecimal amt = RowUtils.decimal(row, 8);
					BigDecimal in = RowUtils.decimal(row, 9);
					BigDecimal per = RowUtils.decimal(row, 10);
					
					if(in.compareTo(BigDecimal.ZERO) > 0)
						total = total.add(in);
					else
						total = total.add(amt.multiply(per).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP));
				}
			}
		}
		
		quantity.setText(Numbers.format(quan));
		amount.setValue(Numbers.format(total));
	}
}
