/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.dm.BillableItem;
import com.kratonsolution.belian.sales.dm.CashierShift;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.sales.srv.CashierShiftService;
import com.kratonsolution.belian.sales.view.BillablePrint;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.HasAmount;
import com.kratonsolution.belian.ui.component.MedicalReceiptRow;
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
public class CashierEditContent extends FormContent
{		
	private BillingService service = Springs.get(BillingService.class);

	private CashierShiftService cashierShiftService = Springs.get(CashierShiftService.class);
	
	private Grid billingItems = new Grid();
	
	private Grid payments = new Grid();
	
	private Textbox amount = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox tax = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Textbox total = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
	private Tabbox tabbox = new Tabbox();
	
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
				Flow.next(getParent(), new CashierGridContent());
			}
		});

		toolbar.getSave().setLabel("Pay & Print");
		toolbar.getSave().setImage("/icons/print.png");
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Billable billing = service.findOne(RowUtils.id(row));
				CashierShift shift = cashierShiftService.findToday();

				if(billing != null && shift != null)
				{
					for(BillableItem item:billing.getItems())
					{
						for(Component com:billingItems.getRows().getChildren())
						{
							BillableitemRow row = (BillableitemRow)com;
							row.updateItem(item);
						}
					}
					
					for(Component row:payments.getRows().getChildren())
					{
						MedicalReceiptRow receipt = (MedicalReceiptRow)row;
						receipt.create(billing);
					}
					
					if(!billing.match())
					{
						Clients.alert("Payment amount not equals billed amount");
						return;
					}
					
					billing.setPaid(true);
					billing.setShift(shift);
					
					service.edit(billing);
					
					PrintWindow window = new PrintWindow(BillablePrint.GEN(billing.getId(),utils.isPos()),true);
					window.setPage(getPage());
					window.setVisible(true);
				}
				
				Flow.next(getParent(), new CashierGridContent());
			}
		});
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
			dts.appendChild(new Label(DateTimes.format(billing.getDate())));
			dts.appendChild(new Label("Total Billing"));
			dts.appendChild(total);
			
			Row currs = new Row();
			currs.appendChild(new Label("Currency"));
			currs.appendChild(new Label(billing.getCurrency().getCode()));
			currs.appendChild(new Label("Sales"));
			currs.appendChild(new Label(billing.getSales().getName()));
			
			Row cuss = new Row();
			cuss.appendChild(new Label("Type"));
			cuss.appendChild(new Label(billing.getBillingType(utils.getLanguage())));
			cuss.appendChild(new Label("Customer"));
			cuss.appendChild(new Label(billing.getCustomer()!=null?billing.getCustomer().getName():"Anonymous"));
			
			grid.getRows().appendChild(numbers);
			grid.getRows().appendChild(comps);
			grid.getRows().appendChild(dts);
			grid.getRows().appendChild(currs);
			grid.getRows().appendChild(cuss);
			
			tabbox.setWidth("100%");
			tabbox.appendChild(new Tabs());
			tabbox.appendChild(new Tabpanels());
			tabbox.getTabs().appendChild(new Tab("Item(s)"));
			tabbox.getTabs().appendChild(new Tab("Payment(s)"));
			tabbox.getTabpanels().appendChild(new Tabpanel());
			tabbox.getTabpanels().appendChild(new Tabpanel());

			appendChild(tabbox);
			
			initItems(billing);
			initPayments(billing);
			
			display();
		}
	}
	
	private void initItems(Billable billing)
	{
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
		billingItems.setSpan("1");

		for(BillableItem item:billing.getItems())
		{
			BillableitemRow row = new BillableitemRow();
			row.setItem(item);
			row.setEventListener(new OnSelectEvent());
			
			billingItems.getRows().appendChild(row);
		}
		
		tabbox.getTabpanels().getFirstChild().appendChild(billingItems);
	}
	
	private void initPayments(Billable billing)
	{
		NRCToolbar toolbar = new NRCToolbar(payments);
		
		payments.setWidth("100%");
		payments.appendChild(new Rows());
		payments.appendChild(new Columns());
		payments.getColumns().appendChild(new Column("Type",null,"200px"));
		payments.getColumns().appendChild(new Column("Amount",null,"105px"));
		payments.getColumns().appendChild(new Column("Reference",null,null));
		payments.setSpan("2");
		
		tabbox.getTabpanels().getLastChild().appendChild(toolbar);
		tabbox.getTabpanels().getLastChild().appendChild(payments);
		
		payments.getRows().appendChild(new MedicalReceiptRow(billing.getBillingAmount().add(billing.getTaxAmount())));
		
		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				payments.getRows().appendChild(new MedicalReceiptRow(billing.getBillingAmount().add(billing.getTaxAmount())));
			}
		});
	}
	
	private BigDecimal display()
	{
		Billable billing = service.findOne(RowUtils.id(row));
		if(billing != null)
		{
			BigDecimal _amount = BigDecimal.ZERO;
			BigDecimal _tax = BigDecimal.ZERO;
			
			for(Component com:billingItems.getRows().getChildren())
			{
				HasAmount row = (HasAmount)com;
				_amount = _amount.add(row.getAmount());
			}
			
			_tax = billing.getTax().getAmount().multiply(_amount).divide(BigDecimal.valueOf(100));
			
			amount.setText(Numbers.format(_amount));
			tax.setText(Numbers.format(_tax));
			total.setText(Numbers.format(_amount.add(_tax)));
			
			return _amount.add(_tax);
		}
		
		return BigDecimal.ZERO;
	}
	
	private class OnSelectEvent implements EventListener<Event>
	{
		@Override
		public void onEvent(Event arg0) throws Exception
		{
			BigDecimal amt = display();
			payments.getRows().getChildren().clear();
			payments.getRows().appendChild(new MedicalReceiptRow(amt));
		}
	}
}
