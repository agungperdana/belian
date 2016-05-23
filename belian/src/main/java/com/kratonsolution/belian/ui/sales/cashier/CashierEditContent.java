/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.dm.BillableItem;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.sales.view.BillablePrint;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.ProductRow;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
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
	
	private Textbox amount = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox tax = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox total = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
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
				Billable billing = service.findOne(RowUtils.string(row, 6));
				if(billing != null)
				{
					billing.setPaid(true);
					
					for(Component com:billingItems.getRows().getChildren())
					{
						ProductRow row = (ProductRow)com;
						for(BillableItem item:billing.getItems())
						{
							if(item.getId().equals(row.getId()))
							{
								item.setPrice(row.getPrice());
								item.setDiscount(row.getDiscount());
								item.setCharge(row.getCharge());
								break;
							}
						}
					}
					
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
		Billable billing = service.findOne(RowUtils.string(row, 6));
		if(billing != null)
		{
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());

			Row numbers = new Row();
			numbers.appendChild(new Label("Table"));
			numbers.appendChild(new Label(billing.getTableNumber()+""));
			numbers.appendChild(new Label("Billing"));
			numbers.appendChild(amount);
			
			Row comps = new Row();
			comps.appendChild(new Label("Number"));
			comps.appendChild(new Label(billing.getNumber()));
			comps.appendChild(new Label("Tax"));
			comps.appendChild(tax);
			
			Row dts = new Row();
			dts.appendChild(new Label("Date"));
			dts.appendChild(new Label(Dates.format(billing.getDate())));
			dts.appendChild(new Label("Total Billing"));
			dts.appendChild(total);
			
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
			billingItems.getColumns().appendChild(new Column("Name",null,"250px"));
			billingItems.getColumns().appendChild(new Column("Qty",null,"65px"));
			billingItems.getColumns().appendChild(new Column("UoM",null,"70px"));
			billingItems.getColumns().appendChild(new Column("Price",null,"100px"));
			billingItems.getColumns().appendChild(new Column("Disc",null,"100px"));
			billingItems.getColumns().appendChild(new Column("Charge",null,"100px"));
			billingItems.getColumns().appendChild(new Column("Note",null,"100px"));
			billingItems.getColumns().appendChild(new Column(null,null,"0px"));
			billingItems.getColumns().getChildren().get(7).setVisible(false);
			billingItems.setSpan("0");

			for(BillableItem item:billing.getItems())
				billingItems.getRows().appendChild(new ProductRow(item,new OnSelectEvent()));

			appendChild(billingItems);
			
			display();
		}
	}
	
	private void display()
	{
		Billable billing = service.findOne(RowUtils.string(row, 6));
		if(billing != null)
		{
			BigDecimal _amount = BigDecimal.ZERO;
			BigDecimal _tax = BigDecimal.ZERO;
			
			for(Component com:billingItems.getRows().getChildren())
			{
				ProductRow row = (ProductRow)com;
				_amount = _amount.add(row.getPrice().multiply(row.getQuantity()).subtract(row.getDiscount()).add(row.getCharge()));
			}
			
			_tax = billing.getTax().getAmount().multiply(_amount).divide(BigDecimal.valueOf(100));
			
			amount.setText(Numbers.format(_amount));
			tax.setText(Numbers.format(_tax));
			total.setText(Numbers.format(_amount.add(_tax)));
		}
	}
	
	private class OnSelectEvent implements EventListener<Event>
	{
		@Override
		public void onEvent(Event arg0) throws Exception
		{
			display();
		}
	}
}
