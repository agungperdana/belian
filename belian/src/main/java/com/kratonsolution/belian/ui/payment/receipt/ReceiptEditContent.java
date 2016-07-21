/**
 * 
 */
package com.kratonsolution.belian.ui.payment.receipt;

import java.math.BigDecimal;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.payment.dm.Receipt;
import com.kratonsolution.belian.payment.svc.PaymentMethodTypeService;
import com.kratonsolution.belian.payment.svc.ReceiptService;
import com.kratonsolution.belian.sales.dm.PaymentApplication;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.component.TaxList;
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
public class ReceiptEditContent extends FormContent
{	
	private ReceiptService service = Springs.get(ReceiptService.class);

	private BillingService billingService = Springs.get(BillingService.class);

	private PaymentMethodTypeService typeService = Springs.get(PaymentMethodTypeService.class);

	private OrganizationList companys = new OrganizationList();

	private PersonBox persons = new PersonBox(false);

	private CurrencyList currencys = new CurrencyList();

	private TaxList taxes = new TaxList();

	private Datebox date = Components.currentDatebox();

	private Listbox types = Components.newSelect();

	private Textbox reference = Components.stdTextBox(null,false);

	private Textbox note = Components.stdTextBox(null,false);

	private Textbox amount = Components.readOnlyMoneyBox(BigDecimal.ZERO,false);

	private Grid billings = new Grid();

	private Row row;

	public ReceiptEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initBillings();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(),new ReceiptGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(),new ReceiptGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Receipt receipt = service.findOne(RowUtils.id(row));
		if(receipt != null)
		{
			companys.setOrganization(receipt.getOrganization());
			date.setValue(receipt.getDate());
			persons.setPerson(receipt.getStaff());
			types.setSelectedItem(types.appendItem(receipt.getType().getLabel(), receipt.getType().getValue()));
			reference.setText(receipt.getReference());
			amount.setText(Numbers.format(receipt.getAmount()));
			currencys.setCurrency(receipt.getCurrency());
			taxes.setTax(receipt.getTax());
			note.setText(receipt.getNote());
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("receipt.grid.column.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("receipt.grid.column.date")));
		row2.appendChild(date);
		
		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("receipt.grid.column.person")));
		row0.appendChild(persons);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("receipt.grid.column.type")));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("receipt.grid.column.reference")));
		row4.appendChild(reference);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("receipt.grid.column.amount")));
		row5.appendChild(amount);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("receipt.grid.column.currency")));
		row6.appendChild(currencys);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("receipt.grid.column.tax")));
		row7.appendChild(taxes);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("receipt.grid.column.note")));
		row8.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row0);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}
	
	private void initBillings()
	{
		billings.appendChild(new Rows());
		billings.appendChild(new Columns());
		billings.setEmptyMessage(lang.get("message.grid.empty"));
		billings.getColumns().appendChild(new Column(null,null,"25px"));
		billings.getColumns().appendChild(new Column(null,null,"150"));
		billings.getColumns().appendChild(new Column(null,null,"150"));
		billings.setSpan("2");

		Receipt receipt = service.findOne(RowUtils.id(row));
		if(receipt != null)
		{
			for(PaymentApplication application:receipt.getBillings())
			{
				Row row = new Row();
				row.appendChild(Components.label(application.getBillable().getNumber()));
				row.appendChild(Components.label(application.getAmount()));
				row.appendChild(Components.label(""));
				
				billings.getRows().appendChild(row);
			}
		}
		
		appendChild(billings);
	}
}
