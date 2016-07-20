/**
 * 
 */
package com.kratonsolution.belian.ui.payment.recurringpayment;

import java.math.BigDecimal;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.payment.dm.RecurringPayment;
import com.kratonsolution.belian.payment.svc.RecurringPaymentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.CurrencyList;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.TaxList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptEditContent extends FormContent
{	
	private RecurringPaymentService service = Springs.get(RecurringPaymentService.class);

	private OrganizationList companys = new OrganizationList();

	private CurrencyList currencys = new CurrencyList();

	private TaxList taxes = new TaxList();

	private Datebox date = Components.currentDatebox();

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox reference = Components.stdTextBox(null,false);

	private Textbox note = Components.stdTextBox(null,false);

	private Doublebox amount = Components.stdDoubleBox(0);

	private Row row;

	public ReceiptEditContent(Row row)
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
				
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
				
				if(amount.getValue() == null || amount.getValue().equals(0d))
					throw new WrongValueException(amount,lang.get("message.field.empty"));
				
				RecurringPayment payment = service.findOne(RowUtils.id(row));
				if(payment != null)
				{
					payment.setAmount(BigDecimal.valueOf(amount.doubleValue()));
					payment.setCurrency(currencys.getCurrency());
					payment.setDate(DateTimes.sql(date.getValue()));
					payment.setName(name.getText());
					payment.setNote(note.getText());
					payment.setOrganization(companys.getOrganization());
					payment.setReference(reference.getText());
					payment.setStaff(utils.getEmployee());
					payment.setTax(taxes.getTax());
					
					service.edit(payment);
				}

				Flow.next(getParent(),new ReceiptGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		RecurringPayment payment = service.findOne(RowUtils.id(row));
		if(payment != null)
		{
			companys.setOrganization(payment.getOrganization());
			currencys.setCurrency(payment.getCurrency());
			taxes.setTax(payment.getTax());
			date.setValue(payment.getDate());
			name.setText(payment.getName());
			reference.setText(payment.getReference());
			amount.setValue(payment.getAmount().doubleValue());
			note.setText(payment.getNote());
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("recurringpayment.grid.column.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("recurringpayment.grid.column.date")));
		row2.appendChild(date);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("recurringpayment.grid.column.name")));
		row3.appendChild(name);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("recurringpayment.grid.column.reference")));
		row4.appendChild(reference);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("recurringpayment.grid.column.amount")));
		row5.appendChild(amount);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("recurringpayment.grid.column.currency")));
		row6.appendChild(currencys);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("recurringpayment.grid.column.tax")));
		row7.appendChild(taxes);
		
		Row row8 = new Row();
		row8.appendChild(new Label(lang.get("recurringpayment.grid.column.note")));
		row8.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
	}
}
