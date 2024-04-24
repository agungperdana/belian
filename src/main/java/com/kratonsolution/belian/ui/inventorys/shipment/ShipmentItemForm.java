
package com.kratonsolution.belian.ui.inventorys.shipment;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Decimalbox;
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

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.orders.dm.Order;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.svc.OrderItemService;
import com.kratonsolution.belian.orders.svc.OrderService;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentOrder;
import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentItemForm extends AbstractForm
{	
	private ShipmentService service = Springs.get(ShipmentService.class);

	private OrderService orderService = Springs.get(OrderService.class);

	private OrderItemService orderItemService = Springs.get(OrderItemService.class);

	private Decimalbox quantity = Components.decimalbox(BigDecimal.ZERO);

	private Textbox content = Components.stdTextBox(null, false);

	private ProductBox produBox = new ProductBox(false,false);

	private Tabbox tabbox = new Tabbox();

	private Grid items = new Grid();

	private Shipment parent;

	public ShipmentItemForm(Shipment parent)
	{
		super();

		this.parent = parent;

		initToolbar();
		initForm();
		initTabbox();

		produBox.addObserver(new Observer()
		{
			@Override
			public void valueChange(IDValueRef value)
			{
				initItems();
			}
		});
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(getParent(), new ShipmentEditContent(RowUtils.shield(parent.getId())));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Shipment shipment = service.findById(parent.getId());
				if(shipment != null)
				{
					ShipmentItem shipmentItem = new ShipmentItem();
					shipmentItem.setProduct(produBox.getDomainAsRef());
					shipmentItem.setContent(content.getText());
					shipmentItem.setQuantity(quantity.getValue());
					shipmentItem.setShipment(shipment);

					for(Component com:items.getRows().getChildren())
					{
						Row rw = (Row)com;
						if(RowUtils.decimal(rw, 3).compareTo(BigDecimal.ZERO) > 0)
						{
							OrderItem orderItem = orderItemService.findById(RowUtils.id(rw));
							if(orderItem != null && !orderItem.isShipped())
							{
								ShipmentOrder order = new ShipmentOrder();
								order.setOrder(orderItem.getOrder().toRef());
								order.setOrderItem(orderItem.toRef());
								order.setQuantity(RowUtils.decimal(rw, 3));
								order.setUnitPrice(RowUtils.decimal(rw, 4));
								order.setShipmentItem(shipmentItem);

								shipmentItem.getOrders().add(order);
							}
						}
					}

					service.addItem(shipmentItem);
				}

				Flow.next(getParent(), new ShipmentEditContent(RowUtils.shield(shipment.getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"175px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");

		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("order.items.grid.column.product")));
		row0.appendChild(produBox);

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.items.grid.column.note")));
		row1.appendChild(content);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.items.grid.column.quantity")));
		row2.appendChild(quantity);

		grid.getRows().appendChild(row0);
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabpanels());
		tabbox.appendChild(new Tabs());
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.items")));
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(null,null,"25px"));
		items.getColumns().appendChild(new Column(lang.get("order.grid.column.orderdate"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("order.grid.column.number"),null,"25px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"135px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.unitprice"),null,"135px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("2");

		tabbox.getTabpanels().getFirstChild().appendChild(items);
	}

	private void initItems()
	{
		items.getRows().getChildren().clear();

		if(produBox.getDomain() != null)
		{
			for(Order order:orderService.findAllShipable(parent.getShipFromParty().getId(), parent.getShipToParty().getId()))
			{
				for(OrderItem orderItem:order.getItems())
				{
					if(!orderItem.isShipped())
					{
						Checkbox checkbox = Components.checkbox(false);
						checkbox.addEventListener(Events.ON_CHECK, new EventListener<CheckEvent>()
						{
							@Override
							public void onEvent(CheckEvent event) throws Exception
							{
								if(event.isChecked())
									calculate();
							}
						});

						Decimalbox decimalbox = Components.fullspanDecimalbox(orderItem.getQuantity().subtract(orderItem.getShipped()));
						decimalbox.addEventListener(Events.ON_CHANGE, new EventListener<Event>()
						{
							@Override
							public void onEvent(Event arg0) throws Exception
							{
								calculate();
							}
						});


						Row row = new Row();
						row.appendChild(checkbox);
						row.appendChild(new Label(DateTimes.format(order.getEntryDate())));
						row.appendChild(new Label(order.getNumber()));
						row.appendChild(decimalbox);
						row.appendChild(Components.fullspanDecimalbox(orderItem.getUntitPrice()));
						row.appendChild(new Label(orderItem.getId()));

						items.getRows().appendChild(row);
					}
				}
			}
		}
	}

	public void calculate()
	{
		BigDecimal quan = BigDecimal.ZERO;

		for(Component com:items.getRows().getChildren())
		{
			Row row = (Row)com;

			if(RowUtils.isChecked(row))
				quan = quan.add(RowUtils.decimal(row, 3));
		}

		quantity.setValue(quan);
	}
}
