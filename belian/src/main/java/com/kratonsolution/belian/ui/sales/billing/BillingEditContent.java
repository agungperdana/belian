/**
 * 
 */
package com.kratonsolution.belian.ui.sales.billing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.dm.BillableItem;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.ProductPriceListbox;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BillingEditContent extends FormContent
{		
	private BillingService service = Springs.get(BillingService.class);

	private Grid billingItems = new Grid();

	private Row row;

	public BillingEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				BillingWindow window = (BillingWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.removeChild(toolbar.getSave());
	}

	@Override
	public void initForm()
	{
		Billable billing = service.findOne(RowUtils.id(row));
		if(billing != null)
		{
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("1");
			grid.getRows().appendChild(RowUtils.row("Number", billing.getNumber()));
			grid.getRows().appendChild(RowUtils.row("Company", billing.getOrganization().getName()));
			grid.getRows().appendChild(RowUtils.row("Date", DateTimes.format(billing.getDate())));
			grid.getRows().appendChild(RowUtils.row("Currency", billing.getCurrency().getCode()));
			grid.getRows().appendChild(RowUtils.row("Sales", billing.getSales().getName()));
			grid.getRows().appendChild(RowUtils.row("Customer", billing.getCustomer().getName()));
			grid.getRows().appendChild(RowUtils.row("Type", billing.getBillingType(utils.getLanguage())));

			billingItems.setWidth("100%");
			billingItems.appendChild(new Rows());
			billingItems.appendChild(new Columns());
			billingItems.getColumns().appendChild(new Column("Name",null,"150px"));
			billingItems.getColumns().appendChild(new Column("Qty",null,"65px"));
			billingItems.getColumns().appendChild(new Column("Price",null,"150px"));
			billingItems.getColumns().appendChild(new Column("Note",null,"100px"));
			billingItems.getColumns().appendChild(new Column(null,null,"0px"));
			billingItems.getColumns().getChildren().get(4).setVisible(false);
			billingItems.setSpan("0");

			Map<String,List<BillableItem>> maps = new HashMap<String,List<BillableItem>>();
			for(BillableItem item:billing.getItems())
			{
				if(!maps.containsKey(item.getCategory()))
					maps.put(item.getCategory(),new ArrayList<BillableItem>());

				maps.get(item.getCategory()).add(item);
			}

			for(String category:maps.keySet())
			{
				Row header = new Row();
				header.appendChild(RowUtils.cell(category, 5));
				billingItems.getRows().appendChild(header);
				
				for(BillableItem item:maps.get(category))
				{
					Row row = new Row();
					row.appendChild(new Label(item.getResource()));
					row.appendChild(new Label(item.getQuantity().toString()));
					if(billing.isPaid())
						row.appendChild(new Label(Numbers.format(item.getUnitPrice())));
					else
						row.appendChild(ProductPriceListbox.newInstance(item.getResource(), billing.getCustomer(), utils.getLocation(), billing.getDate()));
					row.appendChild(new Label(item.getNote()));
					row.appendChild(new Label(item.getId()));

					billingItems.getRows().appendChild(row);
				}
				
				Row space = new Row();
				space.appendChild(RowUtils.cell("", 5));
				billingItems.getRows().appendChild(space);
			}

			appendChild(billingItems);
		}
	}
}
