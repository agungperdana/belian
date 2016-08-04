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
	
	private Textbox other = Components.readOnlyMoneyBox(BigDecimal.ZERO);
	
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

		toolbar.getSave().setLabel(lang.get("label.component.button.payprint"));
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
						Clients.alert(lang.get("cashier.message.notmatch"));
						return;
					}
					
					billing.setShift(shift);
					
					service.paid(billing);
					
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
			numbers.appendChild(new Label(lang.get("cashier.grid.column.table")));
			numbers.appendChild(new Label(billing.getTableNumber()+""));
			numbers.appendChild(new Label(lang.get("cashier.grid.column.billing")));
			numbers.appendChild(amount);
			
			Row comps = new Row();
			comps.appendChild(new Label(lang.get("cashier.grid.column.number")));
			comps.appendChild(new Label(billing.getNumber()));
			comps.appendChild(new Label(lang.get("cashier.grid.column.tax")));
			comps.appendChild(tax);
			
			Row dts = new Row();
			dts.appendChild(new Label(lang.get("cashier.grid.column.date")));
			dts.appendChild(new Label(DateTimes.format(billing.getDate())));
			dts.appendChild(new Label(lang.get("cashier.grid.column.other")));
			dts.appendChild(other);
			
			Row currs = new Row();
			currs.appendChild(new Label(lang.get("cashier.grid.column.currency")));
			currs.appendChild(new Label(billing.getCurrency().getCode()));
			currs.appendChild(new Label(lang.get("cashier.grid.column.totbil")));
			currs.appendChild(total);
			
			Row cuss = new Row();
			cuss.appendChild(new Label(lang.get("cashier.grid.column.type")));
			cuss.appendChild(new Label(billing.getBillingType(utils.getLanguage())));
			cuss.appendChild(new Label(lang.get("cashier.grid.column.sales")));
			cuss.appendChild(new Label(billing.getSales().getName()));
			
			Row last = new Row();
			last.appendChild(new Label(lang.get("cashier.grid.column.customer")));
			last.appendChild(new Label(billing.getCustomer()!=null?billing.getCustomer().getName():"Anonymous"));
			
			grid.getRows().appendChild(numbers);
			grid.getRows().appendChild(comps);
			grid.getRows().appendChild(dts);
			grid.getRows().appendChild(currs);
			grid.getRows().appendChild(cuss);
			grid.getRows().appendChild(last);
			
			tabbox.setWidth("100%");
			tabbox.appendChild(new Tabs());
			tabbox.appendChild(new Tabpanels());
			tabbox.getTabs().appendChild(new Tab(lang.get("cashier.grid.column.items")));
			tabbox.getTabs().appendChild(new Tab(lang.get("cashier.grid.column.payments")));
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
		billingItems.getColumns().appendChild(new Column(lang.get("cashier.grid.column.name"),null,"250px"));
		billingItems.getColumns().appendChild(new Column(lang.get("cashier.grid.column.quantity"),null,"45px"));
		billingItems.getColumns().appendChild(new Column(lang.get("cashier.grid.column.uom"),null,"70px"));
		billingItems.getColumns().appendChild(new Column(lang.get("cashier.grid.column.price"),null,"90px"));
		billingItems.getColumns().appendChild(new Column(lang.get("cashier.grid.column.discount"),null,"90px"));
		billingItems.getColumns().appendChild(new Column(lang.get("cashier.grid.column.charge"),null,"90px"));
		billingItems.getColumns().appendChild(new Column(lang.get("cashier.grid.column.note"),null,"100px"));
		billingItems.setSpan("0");

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
		payments.getColumns().appendChild(new Column(lang.get("cashier.grid.column.type"),null,"200px"));
		payments.getColumns().appendChild(new Column(lang.get("cashier.grid.column.amount"),null,"105px"));
		payments.getColumns().appendChild(new Column(lang.get("cashier.grid.column.reference"),null,null));
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
			other.setText(Numbers.format(billing.getExtra()));
			total.setText(Numbers.format(_amount.add(_tax).add(billing.getExtra())));
			
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
