/**
 * 
 */
package com.kratonsolution.belian.ui.payment.receipt;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.invoice.dm.PaymentApplication;
import com.kratonsolution.belian.payment.dm.Receipt;
import com.kratonsolution.belian.payment.svc.PaymentMethodTypeService;
import com.kratonsolution.belian.payment.svc.ReceiptService;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.srv.BillingService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.ModelListener;
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
public class ReceiptFormContent extends FormContent implements ModelListener<Person>
{	
	private ReceiptService service = Springs.get(ReceiptService.class);
	
	private BillingService billingService = Springs.get(BillingService.class);
	
	private PaymentMethodTypeService typeService = Springs.get(PaymentMethodTypeService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private PersonBox persons = new PersonBox(false);
	
	private CurrencyList currencys = new CurrencyList();
	
	private TaxList taxes = new TaxList();
	
	private Datebox date = Components.currentDatebox();
	
	private Listbox types = Components.newSelect(typeService.findAll(),true);
	
	private Textbox reference = Components.stdTextBox(null,false);
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Textbox amount = Components.readOnlyMoneyBox(BigDecimal.ZERO,false);
	
	private Grid billings = new Grid();
	
	public ReceiptFormContent()
	{
		super();
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
				if(companys.getOrganization() == null)
					throw new WrongValueException(companys,lang.get("message.field.empty"));
				
				if(currencys.getCurrency() == null)
					throw new WrongValueException(currencys,lang.get("message.field.empty"));
				
				if(taxes.getTax() == null)
					throw new WrongValueException(taxes,lang.get("message.field.empty"));
				
				if(persons.getPerson() == null)
					throw new WrongValueException(persons,lang.get("message.field.empty"));
				
				if(amount.getValue() == null || amount.getValue().equals(0d))
					throw new WrongValueException(amount,lang.get("message.field.empty"));
				
				if(types.getSelectedCount() <= 0)
					throw new WrongValueException(types,lang.get("message.field.empty"));
				
				Receipt payment = new Receipt();
				payment.setCurrency(currencys.getCurrency());
				payment.setDate(DateTimes.sql(date.getValue()));
				payment.setNote(note.getText());
				payment.setOrganization(companys.getOrganization());
				payment.setReference(reference.getText());
				payment.setStaff(utils.getEmployee());
				payment.setTax(taxes.getTax());
				payment.setType(typeService.findOne(Components.string(types)));
				
				BigDecimal amt = BigDecimal.ZERO;
				for(Component com:billings.getRows().getChildren())
				{
					Row row = (Row)com;
					if(RowUtils.isChecked(row, 0))
					{
						Billable billable = billingService.findOne(RowUtils.id(row));
						if(billable != null)
							amt = amt.add(billable.getBillingAmount().add(billable.getTaxAmount()));
			
						PaymentApplication application = new PaymentApplication();
						application.setAmount(billable.getBillingAmount().add(billable.getTaxAmount()));
						application.setBillable(billable);
						application.setReceipt(payment);
						
						payment.getBillings().add(application);
					}
				}
				
				payment.setAmount(amt);
				service.add(payment);
				
				Flow.next(getParent(),new ReceiptGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		persons.addListener(ReceiptFormContent.this);
		
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
		billings.getColumns().appendChild(new Column());
		billings.getColumns().appendChild(new Column(null,null,"110px"));
		billings.getColumns().appendChild(new Column());
		billings.setSpan("1");
		billings.getColumns().getLastChild().setVisible(false);

		appendChild(billings);
	}
	
	@Override
	public void fireEvent(Person model)
	{
		billings.getRows().getChildren().clear();
		if(model != null)
		{
			if(companys.getOrganization() == null)
				throw new WrongValueException(companys,lang.get("message.field.empty"));
			
			if(persons.getPerson() == null)
				throw new WrongValueException(persons,lang.get("message.field.empty"));
			
			for(Billable billable:billingService.findAllUnpaid(companys.getOrganization().getId(), persons.getPerson().getId()))
			{
				Row row = new Row();
				
				Checkbox checkbox = Components.checkbox(false);
				checkbox.addEventListener(Events.ON_CHECK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
						calculate();
					}
					
				});
				
				row.appendChild(checkbox);
				row.appendChild(Components.label(billable.getNumber()));
				row.appendChild(Components.label(billable.getBillingAmount().add(billable.getTaxAmount())));
				row.appendChild(Components.label(billable.getId()));
				
				billings.getRows().appendChild(row);
			}
		}
	}
	
	private void calculate()
	{
		BigDecimal amt = BigDecimal.ZERO;
		for(Component com:billings.getRows().getChildren())
		{
			Row row = (Row)com;
			if(RowUtils.isChecked(row, 0))
			{
				Billable billable = billingService.findOne(RowUtils.id(row));
				if(billable != null)
					amt = amt.add(billable.getBillingAmount().add(billable.getTaxAmount()));
			}
		}
		
		amount.setValue(Numbers.format(amt));
	}
}
