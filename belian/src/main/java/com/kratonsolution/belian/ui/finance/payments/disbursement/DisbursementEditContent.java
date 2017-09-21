/**
 * 
 */
package com.kratonsolution.belian.ui.finance.payments.disbursement;

import java.math.BigDecimal;

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

import com.kratonsolution.belian.invoice.svc.PurchaseInvoiceService;
import com.kratonsolution.belian.payments.dm.Disbursement;
import com.kratonsolution.belian.payments.dm.PaymentApplication;
import com.kratonsolution.belian.payments.dm.PaymentMethodType;
import com.kratonsolution.belian.payments.svc.DisbursementService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.finance.payments.PaymentMethodTypeList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
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
public class DisbursementEditContent extends AbstractForm
{	
	private DisbursementService service = Springs.get(DisbursementService.class);

	private PurchaseInvoiceService invoiceService = Springs.get(PurchaseInvoiceService.class);
	
	private Textbox number = Components.readOnlyTextBox(null);
	
	private Datebox date = Components.currentDatebox();

	private Textbox note = Components.stdTextBox(null,false);
	
	private PartyBox payer = new PartyBox(false,false,false);
	
	private Textbox reference = Components.stdTextBox(null,false);
	
	private PaymentMethodTypeList typeList = new PaymentMethodTypeList(false,PaymentMethodType.CASH);
	
	private Decimalbox amount = Components.decimalbox(BigDecimal.ZERO,true);
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid applications = new Grid();

	private Row row;

	public DisbursementEditContent(Row row)
	{
		super();
		this.row = row;
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
				Flow.next(getParent(), new DisbursementGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new DisbursementGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Disbursement receipt = service.findOne(RowUtils.id(row));
		if(receipt != null)
		{
			number.setText(receipt.getNumber());
			date.setValue(receipt.getEfectiveDate());
			organizations.setDomainAsRef(receipt.getReceiver());
			payer.setDomainAsRef(receipt.getPayer());
			typeList.setDomain(receipt.getMethod());
			reference.setText(receipt.getReference());
			amount.setValue(receipt.getAmount());
			note.setText(receipt.getCommend());
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"135px"));
		grid.getColumns().appendChild(new Column());

		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("payments.grid.column.number")));
		row0.appendChild(number);
		
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
		applications.setWidth("100%");
		applications.setEmptyMessage(lang.get("message.grid.empty"));
		applications.appendChild(new Columns());
		applications.appendChild(new Rows());
		applications.getColumns().appendChild(new Column(lang.get("payments.grid.column.invoice"),null,"150px"));
		applications.getColumns().appendChild(new Column(lang.get("payments.grid.column.amount"),null,"135px"));
		applications.setSpan("0");

		Disbursement receipt = service.findOne(RowUtils.id(row));
		if(receipt != null)
		{
			for(PaymentApplication application:receipt.getApplications())
			{
				Row rw = new Row();
				rw.appendChild(new Label(application.getInvoice().getNumber()));
				rw.appendChild(new Label(Numbers.format(application.getAmount())));
			
				applications.getRows().appendChild(rw);
			}
		}
		
		tabbox.getTabpanels().getChildren().get(0).appendChild(applications);
	}
}
