
package com.kratonsolution.belian.ui.finance.invoices.sales;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

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
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.invoice.dm.InvoiceItem;
import com.kratonsolution.belian.invoice.dm.InvoiceRole;
import com.kratonsolution.belian.invoice.dm.InvoiceStatus;
import com.kratonsolution.belian.invoice.dm.InvoiceTerm;
import com.kratonsolution.belian.invoice.dm.SalesInvoice;
import com.kratonsolution.belian.invoice.svc.SalesInvoiceService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.finance.invoices.InvoiceStatusTypeList;
import com.kratonsolution.belian.ui.finance.invoices.InvoiceTermTypeList;
import com.kratonsolution.belian.ui.general.party.PartyAddressList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.general.party.PartyContactList;
import com.kratonsolution.belian.ui.orders.RoleTypeList;
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
public class SalesInvoiceEditContent extends AbstractForm
{	
	private SalesInvoiceService service = Springs.get(SalesInvoiceService.class);

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

	private Grid items = new Grid();

	private Grid statuses = new Grid();

	private Grid roles = new Grid();

	private Grid terms = new Grid();

	private Row row;

	public SalesInvoiceEditContent(Row row)
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
		toolbar.attachPrint();
		toolbar.getPrint().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PrintWindow print = new PrintWindow("/salesinvoiceprint?id="+RowUtils.id(row));
				print.setPage(getPage());
				print.doModal();
			}
		});

		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new SalesInvoiceGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				SalesInvoice invoice = service.findById(RowUtils.id(row));
				if(invoice != null && !invoice.isPaid())
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


					invoice.setBilledFromAddress(fromAddress.getDomainAsRef());
					invoice.setBilledFromContact(fromContact.getDomainAsRef());
					invoice.setBilledFromParty(billFrom.getDomainAsRef());
					invoice.setBilledToAddress(toAddress.getDomainAsRef());
					invoice.setBilledToContact(toContact.getDomainAsRef());
					invoice.setBilledToParty(billTo.getDomainAsRef());
					invoice.setDate(DateTimes.sql(date.getValue()));
					invoice.setMessage(message.getText());
					invoice.setNote(note.getText());
					invoice.setNumber(generator.generate(invoice.getDate(), billFrom.getDomain().getId(), Code.SIV));

					Map<String,InvoiceStatus> stmap = new HashMap<>();
					Map<String,InvoiceRole> rolemap = new HashMap<>();
					Map<String,InvoiceTerm> termmap = new HashMap<>();

					for(InvoiceStatus status:invoice.getStatuses())
						stmap.put(status.getId(), status);

					for(InvoiceRole role:invoice.getRoles())
						rolemap.put(role.getId(), role);

					for(InvoiceTerm term:invoice.getTerms())
						termmap.put(term.getId(), term);

					invoice.getStatuses().clear();
					invoice.getRoles().clear();
					invoice.getTerms().clear();

					for(Component com:statuses.getRows().getChildren())
					{
						Row rw = (Row)com;

						InvoiceStatusTypeList list = (InvoiceStatusTypeList)com.getChildren().get(2);

						InvoiceStatus status = stmap.containsKey(RowUtils.id(rw))?stmap.get(RowUtils.id(rw)):new InvoiceStatus();
						status.setDate(RowUtils.timestam(rw, 1));
						status.setType(list.getDomain());
						status.setInvoice(invoice);

						invoice.getStatuses().add(status);
					}

					for(Component com:roles.getRows().getChildren())
					{
						Row rw = (Row)com;

						PartyBox box = (PartyBox)com.getChildren().get(2);
						RoleTypeList list = (RoleTypeList)com.getChildren().get(3);

						InvoiceRole role = rolemap.containsKey(RowUtils.id(rw))?rolemap.get(RowUtils.id(rw)):new InvoiceRole();
						role.setDate(RowUtils.timestam(rw, 1));
						role.setType(list.getDomain());
						role.setParty(box.getDomainAsRef());
						role.setInvoice(invoice);

						invoice.getRoles().add(role);
					}

					for(Component com:terms.getRows().getChildren())
					{
						Row rw = (Row)com;

						InvoiceTermTypeList list = (InvoiceTermTypeList)com.getChildren().get(2);

						InvoiceTerm term = termmap.containsKey(RowUtils.id(rw))?termmap.get(RowUtils.id(rw)):new InvoiceTerm();
						term.setType(list.getDomain());
						term.setValue(RowUtils.decimal(rw, 1));
						term.setInvoice(invoice);

						invoice.getTerms().add(term);
					}

					service.edit(invoice);
				}


				Flow.next(getParent(), new SalesInvoiceGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		SalesInvoice invoice = service.findById(RowUtils.id(row));
		if(invoice != null)
		{
			date.setValue(invoice.getDate());
			note.setText(invoice.getNote());
			message.setText(invoice.getMessage());
		}

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
		tabbox.getTabs().appendChild(new Tab(lang.get("invoices.grid.column.items")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		tabbox.setSelectedIndex(5);

		from();
		to();
		initStatus();
		initRoles();
		initTerms();
		initItems();
	}

	private void from()
	{
		billFrom.setDomain(utils.getOrganization());

		billFrom.addObserver(fromAddress);
		billFrom.addObserver(fromContact);

		SalesInvoice invoice = service.findById(RowUtils.id(row));
		if(invoice != null)
		{
			billFrom.setDomainAsRef(invoice.getBilledFromParty());
			fromAddress.setDomainAsRef(invoice.getBilledFromAddress());
			fromContact.setDomainAsRef(invoice.getBilledFromContact());
		}

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

		SalesInvoice invoice = service.findById(RowUtils.id(row));
		if(invoice != null)
		{
			billTo.setDomainAsRef(invoice.getBilledToParty());
			toAddress.setDomainAsRef(invoice.getBilledFromAddress());
			toContact.setDomainAsRef(invoice.getBilledToContact());
		}

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
		statuses.getColumns().appendChild(new Column());
		statuses.getColumns().getLastChild().setVisible(false);
		statuses.setSpan("2");

		SalesInvoice invoice = service.findById(RowUtils.id(row));
		if(invoice != null)
		{
			for(InvoiceStatus status:invoice.getStatuses())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.datetime(status.getDate(),true));
				row.appendChild(new InvoiceStatusTypeList(true,status.getType()));
				row.appendChild(new Label(status.getId()));

				statuses.getRows().appendChild(row);
			}
		}

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.datetime(true));
				row.appendChild(new InvoiceStatusTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

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
		roles.getColumns().appendChild(new Column());
		roles.getColumns().getLastChild().setVisible(false);
		roles.setSpan("2");

		SalesInvoice invoice = service.findById(RowUtils.id(row));
		if(invoice != null)
		{
			for(InvoiceRole role:invoice.getRoles())
			{
				PartyBox box = new PartyBox(false,true,false);
				box.setDomainAsRef(role.getParty());

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.datetime(role.getDate(),true));
				row.appendChild(box);
				row.appendChild(new RoleTypeList(true,role.getType()));
				row.appendChild(new Label(role.getId()));

				roles.getRows().appendChild(row);
			}
		}

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
				row.appendChild(new Label(UUID.randomUUID().toString()));

				roles.getRows().appendChild(row);
			}
		});

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
		terms.getColumns().appendChild(new Column());
		terms.getColumns().getLastChild().setVisible(false);
		terms.setSpan("2");

		SalesInvoice invoice = service.findById(RowUtils.id(row));
		if(invoice != null)
		{
			for(InvoiceTerm term:invoice.getTerms())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullspanDecimalbox(term.getValue()));
				row.appendChild(new InvoiceTermTypeList(true,term.getType()));
				row.appendChild(new Label(term.getId()));

				terms.getRows().appendChild(row);
			}
		}

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ONE));
				row.appendChild(new InvoiceTermTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				terms.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(4).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(4).appendChild(terms);
	}

	private void initItems()
	{
		NRCToolbar nrc = new NRCToolbar();
		nrc.getClear().setDisabled(true);

		items.setWidth("100%");
		items.setEmptyMessage(lang.get("message.grid.empty"));
		items.appendChild(new Columns());
		items.appendChild(new Rows());
		items.getColumns().appendChild(new Column(null,null,"25px"));
		items.getColumns().appendChild(new Column(lang.get("invoices.grid.column.description"),null,"135px"));
		items.getColumns().appendChild(new Column(lang.get("invoices.grid.column.quantity"),null,"135px"));
		items.getColumns().appendChild(new Column(lang.get("invoices.grid.column.amount"),null,"135px"));
		items.getColumns().appendChild(new Column(lang.get("invoices.grid.column.taxable"),null,"80px"));
		items.getColumns().appendChild(new Column(lang.get("invoices.grid.column.type"),null,"175px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("1");

		SalesInvoice invoice = service.findById(RowUtils.id(row));
		if(invoice != null)
		{
			for(InvoiceItem item:invoice.getItems())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new Label(item.getLabel(utils.getLanguage())));
				row.appendChild(new Label(Numbers.format(item.getQuantity())));
				row.appendChild(new Label(Numbers.format(item.getAmount())));
				row.appendChild(new Label(item.isTaxable()?lang.get("label.component.generic.yes"):lang.get("label.component.generic.no")));
				row.appendChild(new Label(item.getType().display(utils.getLanguage())));
				row.appendChild(new Label(item.getId()));

				items.getRows().appendChild(row);
			}
		}

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(getParent(), new SalesInvoiceItemForm(service.findById(RowUtils.id(row))));
			}
		});

		nrc.getRemove().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Messagebox.show(lang.get("message.removedata"),"Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
						{
							Vector<String> ids = new Vector<>();
							for(Component com:items.getRows().getChildren())
								ids.add(RowUtils.id((Row)com));

							service.delItem(ids);

							Flow.next(getParent(), new SalesInvoiceEditContent(row));
						}
					}
				});
			}
		});

		tabbox.getTabpanels().getLastChild().appendChild(nrc);
		tabbox.getTabpanels().getLastChild().appendChild(items);
	}
}
