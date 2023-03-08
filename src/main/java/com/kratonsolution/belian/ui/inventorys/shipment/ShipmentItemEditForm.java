/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.shipment;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.orders.dm.Order;
import com.kratonsolution.belian.orders.svc.OrderService;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentOrder;
import com.kratonsolution.belian.shipment.svc.ShipmentItemService;
import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentItemEditForm extends AbstractForm
{	
	private ShipmentService service = Springs.get(ShipmentService.class);

	private ShipmentItemService itemService = Springs.get(ShipmentItemService.class);

	private OrderService orderService = Springs.get(OrderService.class);

	private Decimalbox quantity = Components.decimalbox(BigDecimal.ZERO);

	private Textbox content = Components.stdTextBox(null, false);

	private ProductBox produBox = new ProductBox(false,false);

	private Tabbox tabbox = new Tabbox();

	private Grid items = new Grid();

	private ShipmentItem parent;

	public ShipmentItemEditForm(ShipmentItem parent)
	{
		super();

		this.parent = parent;

		initToolbar();
		initForm();
		initTabbox();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(getParent(), new ShipmentEditContent(RowUtils.shield(parent.getShipment().getId())));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ShipmentEditContent(RowUtils.shield(parent.getShipment().getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		if(parent != null)
		{
			produBox.setDomainAsRef(parent.getProduct());
			content.setText(parent.getContent());
			quantity.setValue(parent.getQuantity());
		}

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
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("2");

		tabbox.getTabpanels().getFirstChild().appendChild(items);

		ShipmentItem item = itemService.findOne(parent.getId());
		if(item != null)
		{
			for(ShipmentOrder so:item.getOrders())
			{
				Order order = orderService.findOne(so.getOrder().getId());
				if(order != null)
				{
					Row row = new Row();
					row.appendChild(Components.checkbox(true, false));
					row.appendChild(new Label(DateTimes.format(order.getEntryDate())));
					row.appendChild(new Label(order.getNumber()));
					row.appendChild(new Label(Numbers.format(so.getQuantity())));

					items.getRows().appendChild(row);
				}
			}
		}
	}
}
