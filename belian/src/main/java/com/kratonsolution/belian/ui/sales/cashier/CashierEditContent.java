/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

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

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.dm.BillableItem;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.sales.view.BillablePrint;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierEditContent extends FormContent
{		
	private BillingService service = Springs.get(BillingService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	private Grid billingItems = new Grid();

	private Row row;

	public CashierEditContent(Row row)
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
				CashierWindow window = (CashierWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().setLabel("Pay & Print");
		toolbar.getSave().setImage("/icons/print.png");
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Billable billing = service.findOne(RowUtils.string(row, 5));
				if(billing != null)
				{
					billing.setPaid(true);
					service.edit(billing);
					
					PrintWindow window = new PrintWindow(BillablePrint.GEN(billing.getId(),utils.isPos()),true);
					window.setPage(getPage());
					window.setVisible(true);
				}
				
				CashierWindow window = (CashierWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Billable billing = service.findOne(RowUtils.string(row, 5));
		if(billing != null)
		{
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());

			Row numbers = new Row();
			numbers.appendChild(new Label("Number"));
			numbers.appendChild(new Label(billing.getNumber()));
			numbers.appendChild(new Label("Billing"));
			numbers.appendChild(Components.readOnlyMoneyBox(billing.getBillingAmount()));
			
			Row comps = new Row();
			comps.appendChild(new Label("Company"));
			comps.appendChild(new Label(billing.getOrganization().getName()));
			comps.appendChild(new Label("Tax"));
			comps.appendChild(Components.readOnlyMoneyBox(billing.getTaxAmount()));
			
			Row dts = new Row();
			dts.appendChild(new Label("Date"));
			dts.appendChild(new Label(Dates.format(billing.getDate())));
			dts.appendChild(new Label("Total Billing"));
			dts.appendChild(Components.readOnlyMoneyBox(billing.getTaxAmount().add(billing.getBillingAmount())));
			
			Row currs = new Row();
			currs.appendChild(new Label("Currency"));
			currs.appendChild(new Label(billing.getCurrency().getCode()));
			currs.appendChild(new Label("Sales"));
			currs.appendChild(new Label(billing.getSales().getName()));
			
			Row cuss = new Row();
			cuss.appendChild(new Label("Type"));
			cuss.appendChild(new Label(billing.getBillingType()));
			cuss.appendChild(new Label("Customer"));
			cuss.appendChild(new Label(billing.getCustomer().getName()));
			
			grid.getRows().appendChild(numbers);
			grid.getRows().appendChild(comps);
			grid.getRows().appendChild(dts);
			grid.getRows().appendChild(currs);
			grid.getRows().appendChild(cuss);

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
					row.appendChild(Components.numberLabel(item.getUnitPrice()));
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
