
package com.kratonsolution.belian.ui.finance.payments.receipt;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
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

import com.google.common.base.Strings;
import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.api.dm.Observer;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.svc.SalesInvoiceService;
import com.kratonsolution.belian.payments.dm.PaymentApplication;
import com.kratonsolution.belian.payments.dm.PaymentMethodType;
import com.kratonsolution.belian.payments.dm.Receipt;
import com.kratonsolution.belian.payments.svc.ReceiptService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.finance.invoices.sales.SalesInvoiceBox;
import com.kratonsolution.belian.ui.finance.payments.PaymentMethodTypeList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptFormContent extends AbstractForm
{	
	private ReceiptService service = Springs.get(ReceiptService.class);

	private SalesInvoiceService invoiceService = Springs.get(SalesInvoiceService.class);
	
	private Datebox date = Components.currentDatebox();

	private Textbox note = Components.stdTextBox(null,false);
	
	private PartyBox payer = new PartyBox(false,false,false);
	
	private Textbox reference = Components.stdTextBox(null,false);
	
	private PaymentMethodTypeList typeList = new PaymentMethodTypeList(false,PaymentMethodType.CASH);
	
	private Decimalbox amount = Components.decimalbox(BigDecimal.ZERO,true);
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid applications = new Grid();

	public ReceiptFormContent()
	{
		super();
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
				Flow.next(getParent(), new ReceiptGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));
				
				if(date.getValue() == null)
					throw new WrongValueException(date,lang.get("message.field.empty"));
			
				if(payer.getDomain() == null)
					throw new WrongValueException(payer,lang.get("message.field.empty"));
				
				if(amount.getValue().compareTo(BigDecimal.ZERO) <= 0)
					throw new WrongValueException(amount,lang.get("message.field.empty"));
			
				if(typeList.getDomain() == null)
					throw new WrongValueException(typeList,lang.get("message.field.empty"));
				
				Receipt receipt = new Receipt();
				receipt.setAmount(amount.getValue());
				receipt.setCommend(note.getText());
				receipt.setEfectiveDate(DateTimes.sql(date.getValue()));
				receipt.setMethod(typeList.getDomain());
				receipt.setReceiver(organizations.getDomainAsRef());
				receipt.setPayer(payer.getDomainAsRef());
				receipt.setReference(reference.getText());
				receipt.setNumber(generator.generate(DateTimes.currentDate(), receipt.getReceiver().getId(),Code.RCT));
				
				for(Component com:applications.getRows().getChildren())
				{
					Row row = (Row)com;
					
					SalesInvoiceBox box = (SalesInvoiceBox)row.getChildren().get(1);
					
					PaymentApplication application = new PaymentApplication();
					application.setAmount(RowUtils.decimal(row, 2));
					application.setInvoice(box.getInvoiceRef());
					application.setPayment(receipt);
					
					receipt.getApplications().add(application);
				}
				
				service.add(receipt);
				
				Flow.next(getParent(), new ReceiptGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"135px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("payments.grid.column.date")));
		row1.appendChild(date);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("payments.grid.column.receiver")));
		row2.appendChild(organizations);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("payments.grid.column.payer")));
		row3.appendChild(payer);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("payments.grid.column.method")));
		row4.appendChild(typeList);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("payments.grid.column.reference")));
		row5.appendChild(reference);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("payments.grid.column.amount")));
		row6.appendChild(amount);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("payments.grid.column.commend")));
		row7.appendChild(note);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
	}
	
	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("payments.grid.column.applications")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
		
		initApplications();
	}
	
	private void initApplications()
	{
		NRCToolbar nrc = new NRCToolbar(applications);
		
		applications.setWidth("100%");
		applications.setEmptyMessage(lang.get("message.grid.empty"));
		applications.appendChild(new Columns());
		applications.appendChild(new Rows());
		applications.getColumns().appendChild(new Column(null,null,"25px"));
		applications.getColumns().appendChild(new Column(lang.get("payments.grid.column.invoice"),null,"150px"));
		applications.getColumns().appendChild(new Column(lang.get("payments.grid.column.amount"),null,"135px"));
		applications.setSpan("1");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Decimalbox decimalbox = Components.fullspanDecimalbox(BigDecimal.ZERO);
				
				SalesInvoiceBox box = new SalesInvoiceBox(false, true);
				box.addObserver(new Observer()
				{
					@Override
					public void valueChange(IDValueRef value)
					{
						if(value != null && !Strings.isNullOrEmpty(value.getId()))
						{
							Invoice invoice = invoiceService.findById(value.getId());
							if(invoice != null)
							{
								decimalbox.setValue(invoice.getSubtotal());
								decimalbox.focus();
								calculate();
							}
						}
					}
				});
				
				payer.addObserver(box);
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(decimalbox);
				
				applications.getRows().appendChild(row);
			}
		});
				
		tabbox.getTabpanels().getChildren().get(0).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(0).appendChild(applications);
	}
	
	private void calculate()
	{
		BigDecimal amt = BigDecimal.ZERO;
		
		for(Component com:applications.getRows().getChildren())
		{
			Row row = (Row)com;
			amt = amt.add(RowUtils.decimal(row, 2));
		}
		
		amount.setValue(amt);
	}
}
