
package com.kratonsolution.belian.ui.orders.salesorder;

import java.math.BigDecimal;
import java.util.Date;

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
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.orders.dm.OrderAdjustment;
import com.kratonsolution.belian.orders.dm.OrderAdjustmentType;
import com.kratonsolution.belian.orders.dm.OrderRole;
import com.kratonsolution.belian.orders.dm.OrderRoleType;
import com.kratonsolution.belian.orders.dm.OrderStatus;
import com.kratonsolution.belian.orders.dm.OrderTerm;
import com.kratonsolution.belian.orders.dm.OrderTermType;
import com.kratonsolution.belian.orders.dm.SalesOrder;
import com.kratonsolution.belian.orders.svc.SalesOrderService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.accounting.currency.CurrencyList;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyAddressList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.general.party.PartyContactList;
import com.kratonsolution.belian.ui.global.StatusTypeList;
import com.kratonsolution.belian.ui.orders.OrderAdjustmentTypeList;
import com.kratonsolution.belian.ui.orders.OrderRoleTypeList;
import com.kratonsolution.belian.ui.orders.OrderTermTypeList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesOrderFormContent extends BForm
{	
	private SalesOrderService service = Springs.get(SalesOrderService.class);

	private Datebox orderDate = Components.currentDatebox();

	private Datebox entryDate = Components.currentDatebox();

	private CurrencyList currencys = new CurrencyList(false);

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private PartyBox billToParty = new PartyBox(true,false);

	private PartyAddressList billToAddress = new PartyAddressList(false, null);

	private PartyContactList billToContact = new PartyContactList(false, null);
	
	private PartyBox partyPlacingOrder = new PartyBox(true,false);

	private PartyBox shipToParty = new PartyBox(true,false);

	private PartyAddressList shipToAddress = new PartyAddressList(false, null);

	private PartyContactList shipToContacts = new PartyContactList(false, null);

	private Textbox note = Components.stdTextBox(null, false);

	private Grid roles = new Grid();

	private Grid statuses = new Grid();

	private Grid terms = new Grid();

	private Grid adjustments = new Grid();

	private Tabbox tabbox = new Tabbox();

	public SalesOrderFormContent()
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
				Flow.next(getParent(), new SalesOrderGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(orderDate.getValue() == null)
					throw new WrongValueException(orderDate,lang.get("message.field.empty"));

				if(entryDate.getValue() == null)
					throw new WrongValueException(entryDate,lang.get("message.field.empty"));

				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));

				if(billToParty.getDomain() == null)
					throw new WrongValueException(billToParty,lang.get("message.field.empty"));

				if(billToAddress.getDomain() == null)
					throw new WrongValueException(billToAddress,lang.get("message.field.empty"));

				if(billToContact.getDomain() == null)
					throw new WrongValueException(billToContact,lang.get("message.field.empty"));

				if(shipToParty.getDomain() == null)
					throw new WrongValueException(shipToParty,lang.get("message.field.empty"));

				if(shipToAddress.getDomain() == null)
					throw new WrongValueException(shipToAddress,lang.get("message.field.empty"));

				if(shipToContacts.getDomain() == null)
					throw new WrongValueException(shipToContacts,lang.get("message.field.empty"));

				SalesOrder order = SalesOrder.standard();
				order.setCurrency(currencys.getDomainAsRef());
				order.setEntryDate(DateTimes.sql(entryDate.getValue()));
				order.setOrderDate(DateTimes.sql(orderDate.getValue()));

				//internal organization who is receive the order
				order.setPartyTakingOrder(organizations.getDomainAsRef());

				//customer
				order.setPartyPlacingOrder(partyPlacingOrder.getDomainAsRef());
				
				//billing information
				order.setBillToParty(billToParty.getDomainAsRef());
				order.setBillToAddress(billToAddress.getDomainAsRef());
				order.setBillToContact(billToContact.getDomainAsRef());
				
				//shipping information
				order.setShipToParty(shipToParty.getDomainAsRef());
				order.setShipToAddress(shipToAddress.getDomainAsRef());
				order.setShipToContact(shipToContacts.getDomainAsRef());
				
				for(Component com:roles.getRows().getChildren())
				{
					Row iRow = (Row)com;
					
					PartyBox partyBox = (PartyBox)iRow.getChildren().get(1);
					OrderRoleTypeList roleTypeList = (OrderRoleTypeList)iRow.getChildren().get(3);
					
					OrderRole role = new OrderRole();
					role.setOrder(order);
					role.setPercentContribution(RowUtils.decimal(iRow, 2));
					role.setPerson(partyBox.getDomainAsRef());
					role.setType(roleTypeList.getOrderRoleType());

					order.getPartyOrderRoles().add(role);
				}
				
				for(Component com:statuses.getRows().getChildren())
				{
					Row iRow = (Row)com;
					
					StatusTypeList statusTypeList = (StatusTypeList)iRow.getChildren().get(2);
					
					OrderStatus status = new OrderStatus();
					status.setDate(RowUtils.timestam(iRow, 1));
					status.setOrder(order);
					status.setType(statusTypeList.getDomain());
					
					order.getStatuses().add(status);
				}
				
				for(Component com:terms.getRows().getChildren())
				{
					Row iRow = (Row)com;
					
					OrderTermTypeList termTypeList = (OrderTermTypeList)iRow.getChildren().get(2);
					
					OrderTerm term = new OrderTerm();
					term.setAmount(RowUtils.decimal(iRow, 3));
					term.setItem(RowUtils.string(iRow, 1));
					term.setOrder(order);
					term.setType(termTypeList.getDomain());
					
					order.getTerms().add(term);
				}
				
				for(Component com:adjustments.getRows().getChildren())
				{
					Row iRow = (Row)com;
					
					OrderAdjustmentTypeList adjustmentTypeList = (OrderAdjustmentTypeList)iRow.getChildren().get(1);
					
					OrderAdjustment adjustment = new OrderAdjustment();
					adjustment.setAmount(RowUtils.decimal(iRow, 2));
					adjustment.setOrder(order);
					adjustment.setPercent(RowUtils.decimal(iRow, 3));
					adjustment.setType(adjustmentTypeList.getOrderAdjustmentType());
					
					order.getAdjustments().add(adjustment);
				}
				
				service.add(order);

				Flow.next(getParent(), new SalesOrderEditContent(RowUtils.shield(order.getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		addColumn(new Column(null,null,"150px"));
		addColumn(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.takingorder")));
		row1.appendChild(organizations);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.orderdate")));
		row2.appendChild(orderDate);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.entrydate")));
		row3.appendChild(entryDate);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("order.grid.column.placingorder")));
		row4.appendChild(partyPlacingOrder);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("order.grid.column.currency")));
		row5.appendChild(currencys);

		addRow(row1);
		addRow(row2);
		addRow(row3);
		addRow(row4);
		addRow(row5);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabpanels());
		tabbox.appendChild(new Tabs());
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.billings")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.shippings")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.roles")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.statuses")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.terms")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.adjustments")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initBillToParty();
		initShipToParty();
		initRoles();
		initStatuses();
		initTerms();
		initAdjustments();
	}

	private void initBillToParty()
	{
		billToParty.addObserver(billToAddress);
		billToParty.addObserver(billToContact);
		
		Grid layout = new Grid();
		layout.setWidth("100%");
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"125px"));
		layout.getColumns().appendChild(new Column());
		layout.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.billto")));
		row1.appendChild(billToParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.billingaddress")));
		row2.appendChild(billToAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.billingcontact")));
		row3.appendChild(billToContact);

		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);

		tabbox.getTabpanels().getFirstChild().appendChild(layout);
	}

	private void initShipToParty()
	{
		shipToParty.addObserver(shipToAddress);
		shipToParty.addObserver(shipToContacts);
		
		Grid layout = new Grid();
		layout.setWidth("100%");
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"125px"));
		layout.getColumns().appendChild(new Column());
		layout.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.shipto")));
		row1.appendChild(shipToParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.shippingaddress")));
		row2.appendChild(shipToAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.shippingcontact")));
		row3.appendChild(shipToContacts);

		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);

		tabbox.getTabpanels().getChildren().get(1).appendChild(layout);
	}

	private void initRoles()
	{
		NRCToolbar nrc = new NRCToolbar(roles);

		roles.setWidth("100%");
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.appendChild(new Rows());
		roles.appendChild(new Columns());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("order.roles.grid.column.person"),null,"350px"));
		roles.getColumns().appendChild(new Column(lang.get("order.roles.grid.column.contribution"),null,"100px"));
		roles.getColumns().appendChild(new Column(lang.get("order.roles.grid.column.type"),null,"125px"));
		roles.setSpan("1");

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(PartyBox.personNolinkSpan());
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
				row.appendChild(new OrderRoleTypeList(true));

				roles.getRows().appendChild(row);
			}
		});

		PartyBox admin = new PartyBox(false, true, utils.getPerson());
		admin.setReadonly();
		
		OrderRoleTypeList roleType = new OrderRoleTypeList(true,OrderRoleType.SALESPERSON);
		roleType.setDisabled(true);
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(admin);
		row.appendChild(Components.fullspanReadonlyDecimalbox(BigDecimal.ZERO));
		row.appendChild(roleType);
		
		roles.getRows().appendChild(row);
		
		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(roles);
	}

	private void initStatuses()
	{
		NRCToolbar nrc = new NRCToolbar(statuses);

		statuses.setWidth("100%");
		statuses.setEmptyMessage(lang.get("message.grid.empty"));
		statuses.appendChild(new Rows());
		statuses.appendChild(new Columns());
		statuses.getColumns().appendChild(new Column(null,null,"25px"));
		statuses.getColumns().appendChild(new Column(lang.get("order.statuses.grid.column.date"),null,"150px"));
		statuses.getColumns().appendChild(new Column(lang.get("order.statuses.grid.column.type"),null,"100px"));
		statuses.setSpan("2");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(new Date()));
				row.appendChild(new StatusTypeList(true));

				statuses.getRows().appendChild(row);
			}
		});

		StatusTypeList list = new StatusTypeList(true,StatusType.CREATED);
		list.setDisabled(true);
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(Components.fullSpanReadOnlyDatebox(new Date()));
		row.appendChild(list);

		statuses.getRows().appendChild(row);
		
		tabbox.getTabpanels().getChildren().get(3).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(3).appendChild(statuses);
	}

	private void initTerms()
	{
		NRCToolbar nrc = new NRCToolbar(terms);

		terms.setWidth("100%");
		terms.setEmptyMessage(lang.get("message.grid.empty"));
		terms.appendChild(new Rows());
		terms.appendChild(new Columns());
		terms.getColumns().appendChild(new Column(null,null,"25px"));
		terms.getColumns().appendChild(new Column(lang.get("order.terms.grid.column.orderitem"),null,"150px"));
		terms.getColumns().appendChild(new Column(lang.get("order.terms.grid.column.type"),null,"225px"));
		terms.getColumns().appendChild(new Column(lang.get("order.terms.grid.column.amount"),null,"100px"));
		terms.setSpan("1");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.textBox(null));
				row.appendChild(new OrderTermTypeList(true));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));

				terms.getRows().appendChild(row);
			}
		});
		
		OrderTermTypeList typeList = new OrderTermTypeList(true);
		typeList.setDomain(OrderTermType.CREDIT_TERM);
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(Components.readOnlyTextBox());
		row.appendChild(typeList);
		row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));

		terms.getRows().appendChild(row);
				
		tabbox.getTabpanels().getChildren().get(4).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(4).appendChild(terms);
	}

	private void initAdjustments()
	{
		NRCToolbar nrc = new NRCToolbar(adjustments);

		adjustments.setWidth("100%");
		adjustments.setEmptyMessage(lang.get("message.grid.empty"));
		adjustments.appendChild(new Rows());
		adjustments.appendChild(new Columns());
		adjustments.getColumns().appendChild(new Column(null,null,"25px"));
		adjustments.getColumns().appendChild(new Column(lang.get("order.adjustments.grid.column.type"),null,"150px"));
		adjustments.getColumns().appendChild(new Column(lang.get("order.adjustments.grid.column.amount"),null,"150px"));
		adjustments.getColumns().appendChild(new Column(lang.get("order.adjustments.grid.column.percent"),null,"150px"));
		adjustments.setSpan("1");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new OrderAdjustmentTypeList(true));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));

				adjustments.getRows().appendChild(row);
			}
		});
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(new OrderAdjustmentTypeList(true,OrderAdjustmentType.TAX));
		row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
		row.appendChild(Components.fullspanDecimalbox(BigDecimal.TEN));

		adjustments.getRows().appendChild(row);

		tabbox.getTabpanels().getChildren().get(5).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(5).appendChild(adjustments);
	}
}
