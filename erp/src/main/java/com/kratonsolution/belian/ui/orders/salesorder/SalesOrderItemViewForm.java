
package com.kratonsolution.belian.ui.orders.salesorder;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
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
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.svc.OrderItemService;
import com.kratonsolution.belian.requirement.dm.RequirementOrderCommitment;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.products.feature.ProductFeatureList;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.products.product.ProductPriceBox;
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
public class SalesOrderItemViewForm extends BForm
{	
	private OrderItemService service = Springs.get(OrderItemService.class);
	
	private ProductBox productBox = new ProductBox(false);
	
	private ProductFeatureList featureList = new ProductFeatureList(false);
	
	private Decimalbox quantity = Components.decimalbox(BigDecimal.ZERO);
	
	private ProductPriceBox priceBox = new ProductPriceBox(false);
	
	private Textbox total = Components.readOnlyMoneyBox(BigDecimal.ZERO,false);

	private Textbox note = Components.stdTextBox(null, false);

	private Tabbox tabbox = new Tabbox();
	
	private Grid fulfillments = new Grid();

	private OrderItem item;
	
	public SalesOrderItemViewForm(OrderItem item)
	{
		super();
		
		this.item = item;
		
		initToolbar();
		initForm();
		initTabbox();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new SalesOrderEditContent(RowUtils.shield(item.getOrder().getId())));
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Clients.showNotification(lang.get("message.update.notsupported"));
			}
		});
	}

	@Override
	public void initForm()
	{
		addColumn(new Column(null,null,"150px"));
		addColumn(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.items.grid.column.product")));
		row1.appendChild(productBox);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.items.grid.column.feature")));
		row2.appendChild(featureList);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.items.grid.column.quantity")));
		row3.appendChild(quantity);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("order.items.grid.column.unitprice")));
		row4.appendChild(priceBox);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("order.items.grid.column.amount")));
		row5.appendChild(total);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("order.items.grid.column.note")));
		row6.appendChild(note);

		addRow(row1);
		addRow(row2);
		addRow(row3);
		addRow(row4);
		addRow(row5);
		addRow(row6);
		
		if(item != null)
		{
			productBox.setDomainAsRef(item.getProduct());
			featureList.setDomainAsRef(item.getFeature());
			quantity.setValue(item.getQuantity());
			priceBox.getNominal().setValue(item.getUntitPrice());
			total.setText(Numbers.format(item.getQuantity().multiply(item.getUntitPrice())));
			note.setText(item.getNote());
		}
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabpanels());
		tabbox.appendChild(new Tabs());
		tabbox.getTabs().appendChild(new Tab(lang.get("order.items.grid.column.fulfillments")));
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initFulfillments();
	}
	
	private void initFulfillments()
	{
		fulfillments.setWidth("100%");
		fulfillments.setEmptyMessage(lang.get("message.grid.empty"));
		fulfillments.appendChild(new Rows());
		fulfillments.appendChild(new Columns());
		fulfillments.getColumns().appendChild(new Column(lang.get("order.grid.column.entrydate"),null,"135px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("order.grid.column.number"),null,"150px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"100px"));
		fulfillments.setSpan("2");
		
		if(item != null)
		{
			OrderItem out = service.getOne(item.getId());
			if(out != null)
			{
				for(RequirementOrderCommitment com:out.getOrderCommitments())
				{
					Row row = new Row();
					row.appendChild(new Label(DateTimes.format(out.getOrder().getEntryDate())));
					row.appendChild(new Label(out.getOrder().getNumber()));
					row.appendChild(new Label(Numbers.format(com.getQuantity())));
					
					fulfillments.getRows().appendChild(row);
				}
			}
		}
		
		tabbox.getTabpanels().getFirstChild().appendChild(fulfillments);
	}
}
