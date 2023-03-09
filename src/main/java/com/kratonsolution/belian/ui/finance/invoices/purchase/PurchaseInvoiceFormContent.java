
package com.kratonsolution.belian.ui.finance.invoices.purchase;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
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
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.invoice.dm.InvoiceRole;
import com.kratonsolution.belian.invoice.dm.InvoiceStatus;
import com.kratonsolution.belian.invoice.dm.InvoiceTerm;
import com.kratonsolution.belian.invoice.dm.InvoiceTermType;
import com.kratonsolution.belian.invoice.dm.PurchaseInvoice;
import com.kratonsolution.belian.invoice.svc.PurchaseInvoiceService;
import com.kratonsolution.belian.orders.dm.RoleType;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.finance.invoices.InvoiceStatusTypeList;
import com.kratonsolution.belian.ui.finance.invoices.InvoiceTermTypeList;
import com.kratonsolution.belian.ui.general.party.PartyAddressList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.general.party.PartyContactList;
import com.kratonsolution.belian.ui.orders.RoleTypeList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseInvoiceFormContent extends AbstractForm
{	
	private PurchaseInvoiceService service = Springs.get(PurchaseInvoiceService.class);

	private Datebox date = Components.currentDatebox();

	private Textbox note = Components.stdTextBox(null,false);
	
	private Textbox message = Components.stdTextBox(null,false);
	
	private PartyBox billFrom = new PartyBox(false,false,false);

	private PartyAddressList fromAddress = new PartyAddressList(false, null);
	
	private PartyContactList fromContact = new PartyContactList(false, null);
	
	private PartyBox billTo = new PartyBox(false,false,false);

	private PartyAddressList toAddress = new PartyAddressList(false, null);
	
	private PartyContactList toContact = new PartyContactList(false, null);
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid statuses = new Grid();
	
	private Grid roles = new Grid();
	
	private Grid terms = new Grid();

	public PurchaseInvoiceFormContent()
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
				Flow.next(getParent(), new PurchaseInvoiceGridContent());
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
			
				if(billFrom.getDomain() == null)
					throw new WrongValueException(billFrom,lang.get("message.field.empty"));
				
				if(fromAddress.getDomain() == null)
					throw new WrongValueException(fromAddress,lang.get("message.field.empty"));
				
				if(fromContact.getDomain() == null)
					throw new WrongValueException(fromContact,lang.get("message.field.empty"));
				
				if(billTo.getDomain() == null)
					throw new WrongValueException(billTo,lang.get("message.field.empty"));
				
				if(toAddress.getDomain() == null)
					throw new WrongValueException(toAddress,lang.get("message.field.empty"));
				
				if(toContact.getDomain() == null)
					throw new WrongValueException(toContact,lang.get("message.field.empty"));
				
				PurchaseInvoice invoice = new PurchaseInvoice();
				invoice.setBilledFromAddress(fromAddress.getDomainAsRef());
				invoice.setBilledFromContact(fromContact.getDomainAsRef());
				invoice.setBilledFromParty(billFrom.getDomainAsRef());
				invoice.setBilledToAddress(toAddress.getDomainAsRef());
				invoice.setBilledToContact(toContact.getDomainAsRef());
				invoice.setBilledToParty(billTo.getDomainAsRef());
				invoice.setDate(DateTimes.sql(date.getValue()));
				invoice.setMessage(message.getText());
				invoice.setNote(note.getText());
				invoice.setNumber(generator.generate(invoice.getDate(), billFrom.getDomain().getId(), Code.PIV));
				
				for(Component com:statuses.getRows().getChildren())
				{
					Row row = (Row)com;
					
					InvoiceStatusTypeList list = (InvoiceStatusTypeList)com.getChildren().get(2);
					
					InvoiceStatus status = new InvoiceStatus();
					status.setDate(RowUtils.timestam(row, 1));
					status.setType(list.getDomain());
					status.setInvoice(invoice);
					
					invoice.getStatuses().add(status);
				}
				
				for(Component com:roles.getRows().getChildren())
				{
					Row row = (Row)com;
					
					PartyBox box = (PartyBox)com.getChildren().get(2);
					RoleTypeList list = (RoleTypeList)com.getChildren().get(3);
					
					InvoiceRole role = new InvoiceRole();
					role.setDate(RowUtils.timestam(row, 1));
					role.setType(list.getDomain());
					role.setParty(box.getDomainAsRef());
					role.setInvoice(invoice);
					
					invoice.getRoles().add(role);
				}
				
				for(Component com:terms.getRows().getChildren())
				{
					Row row = (Row)com;
					
					InvoiceTermTypeList list = (InvoiceTermTypeList)com.getChildren().get(2);
					
					InvoiceTerm term = new InvoiceTerm();
					term.setType(list.getDomain());
					term.setValue(RowUtils.decimal(row, 1));
					term.setInvoice(invoice);
					
					invoice.getTerms().add(term);
				}
				
				service.add(invoice);
				
				Flow.next(getParent(), new PurchaseInvoiceEditContent(RowUtils.shield(invoice.getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("invoices.grid.column.date")));
		row1.appendChild(date);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("invoices.grid.column.note")));
		row2.appendChild(note);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("invoices.grid.column.message")));
		row3.appendChild(message);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
	
	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("invoices.grid.column.sender")));
		tabbox.getTabs().appendChild(new Tab(lang.get("invoices.grid.column.receiver")));
		tabbox.getTabs().appendChild(new Tab(lang.get("invoices.grid.column.statuses")));
		tabbox.getTabs().appendChild(new Tab(lang.get("invoices.grid.column.roles")));
		tabbox.getTabs().appendChild(new Tab(lang.get("invoices.grid.column.terms")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
		
		from();
		to();
		initStatus();
		initRoles();
		initTerms();
	}
	
	private void from()
	{
		billFrom.addObserver(fromAddress);
		billFrom.addObserver(fromContact);
		
		Grid froms = new Grid();
		froms.setWidth("100%");
		froms.appendChild(new Columns());
		froms.appendChild(new Rows());
		froms.getColumns().appendChild(new Column(null,null,"150px"));
		froms.getColumns().appendChild(new Column());
		froms.setSpan("1");
		froms.getRows().appendChild(RowUtils.row(lang.get("invoices.grid.column.from"), billFrom));
		froms.getRows().appendChild(RowUtils.row(lang.get("invoices.grid.column.fromaddress"), fromAddress));
		froms.getRows().appendChild(RowUtils.row(lang.get("invoices.grid.column.fromcontact"), fromContact));
		
		tabbox.getTabpanels().getFirstChild().appendChild(froms);
	}
	
	private void to()
	{
		billTo.addObserver(toAddress);
		billTo.addObserver(toContact);
		
		billTo.setDomain(utils.getOrganization());
		
		Grid tos = new Grid();
		tos.setWidth("100%");
		tos.appendChild(new Columns());
		tos.appendChild(new Rows());
		tos.getColumns().appendChild(new Column(null,null,"150px"));
		tos.getColumns().appendChild(new Column());
		tos.setSpan("1");
		tos.getRows().appendChild(RowUtils.row(lang.get("invoices.grid.column.to"), billTo));
		tos.getRows().appendChild(RowUtils.row(lang.get("invoices.grid.column.toaddress"), toAddress));
		tos.getRows().appendChild(RowUtils.row(lang.get("invoices.grid.column.tocontact"), toContact));
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(tos);
	}
	
	private void initStatus()
	{
		NRCToolbar nrc = new NRCToolbar(statuses);
		
		statuses.setWidth("100%");
		statuses.setEmptyMessage(lang.get("message.grid.empty"));
		statuses.appendChild(new Columns());
		statuses.appendChild(new Rows());
		statuses.getColumns().appendChild(new Column(null,null,"25px"));
		statuses.getColumns().appendChild(new Column(lang.get("invoices.grid.column.date"),null,"150px"));
		statuses.getColumns().appendChild(new Column(lang.get("invoices.grid.column.type"),null,"135px"));
		statuses.setSpan("2");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.datetime(true));
				row.appendChild(new InvoiceStatusTypeList(true));
				
				statuses.getRows().appendChild(row);
			}
		});
				
		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(statuses);
	}
	
	private void initRoles()
	{
		NRCToolbar nrc = new NRCToolbar(roles);
		
		roles.setWidth("100%");
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.appendChild(new Columns());
		roles.appendChild(new Rows());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("invoices.grid.column.date"),null,"150px"));
		roles.getColumns().appendChild(new Column(lang.get("invoices.grid.column.party"),null,"135px"));
		roles.getColumns().appendChild(new Column(lang.get("invoices.grid.column.type"),null,"135px"));
		roles.setSpan("2");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.datetime(true));
				row.appendChild(new PartyBox(false,true,false));
				row.appendChild(new RoleTypeList(true));
				
				roles.getRows().appendChild(row);
			}
		});
		
		PartyBox box = new PartyBox(false,true,false);
		box.setDomain(utils.getPerson());
		box.setDisabled();
		
		RoleTypeList list = new RoleTypeList(true);
		list.setDomain(RoleType.ENTERED_BY);
		list.setDisabled(true);
		
		Row row = new Row();
		row.appendChild(Components.checkbox(true,false));
		row.appendChild(Components.fullSpanReadOnlyDatebox(DateTimes.currentDate()));
		row.appendChild(box);
		row.appendChild(list);
		
		roles.getRows().appendChild(row);
		
		tabbox.getTabpanels().getChildren().get(3).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(3).appendChild(roles);
	}
	
	private void initTerms()
	{
		NRCToolbar nrc = new NRCToolbar(terms);
		
		terms.setWidth("100%");
		terms.setEmptyMessage(lang.get("message.grid.empty"));
		terms.appendChild(new Columns());
		terms.appendChild(new Rows());
		terms.getColumns().appendChild(new Column(null,null,"25px"));
		terms.getColumns().appendChild(new Column(lang.get("invoices.grid.column.term"),null,"135px"));
		terms.getColumns().appendChild(new Column(lang.get("invoices.grid.column.type"),null,"135px"));
		terms.setSpan("2");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ONE));
				row.appendChild(new InvoiceTermTypeList(true));
				
				terms.getRows().appendChild(row);
			}
		});
		
		InvoiceTermTypeList list = new InvoiceTermTypeList(true);
		list.setDomain(InvoiceTermType.PAYMENT);
		list.setDisabled(true);
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(Components.fullspanDecimalbox(BigDecimal.ONE));
		row.appendChild(list);
		
		terms.getRows().appendChild(row);
		
		tabbox.getTabpanels().getChildren().get(4).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(4).appendChild(terms);
	}
}
