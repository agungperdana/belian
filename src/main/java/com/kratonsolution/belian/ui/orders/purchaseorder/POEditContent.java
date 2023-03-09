
package com.kratonsolution.belian.ui.orders.purchaseorder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

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
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Models;
import com.kratonsolution.belian.common.dm.Referenceable;
import com.kratonsolution.belian.orders.dm.OrderAdjustment;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.dm.OrderRole;
import com.kratonsolution.belian.orders.dm.OrderStatus;
import com.kratonsolution.belian.orders.dm.OrderTerm;
import com.kratonsolution.belian.orders.dm.PurchaseOrder;
import com.kratonsolution.belian.orders.dm.PurchaseOrderItem;
import com.kratonsolution.belian.orders.svc.PurchaseOrderService;
import com.kratonsolution.belian.ui.AbstractForm;
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
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class POEditContent extends AbstractForm
{	
	private PurchaseOrderService service = Springs.get(PurchaseOrderService.class);
	
	private Datebox orderDate = Components.currentDatebox();

	private Datebox entryDate = Components.currentDatebox();

	private CurrencyList currencys = new CurrencyList(false);

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private PartyBox payToParty = new PartyBox(true,false);

	private PartyAddressList payToAddress = new PartyAddressList(false, null);

	private PartyContactList payToContacts = new PartyContactList(false, null);
	
	private PartyBox partyTakingOrder = new PartyBox(true,false);

	private PartyBox shipToParty = new PartyBox(true,false);

	private PartyAddressList shipToAddress = new PartyAddressList(false, null);

	private PartyContactList ShipToContacts = new PartyContactList(false, null);

	private Textbox note = Components.stdTextBox(null, false);
	
	private Textbox orders = Components.readOnlyMoneyBox(BigDecimal.ZERO, false);
	
	private Textbox adjusts = Components.readOnlyMoneyBox(BigDecimal.ZERO, false);
	
	private Textbox total = Components.readOnlyMoneyBox(BigDecimal.ZERO, false);

	private Grid items = new Grid();

	private Grid roles = new Grid();

	private Grid statuses = new Grid();

	private Grid terms = new Grid();

	private Grid adjustments = new Grid();

	private Tabbox tabbox = new Tabbox();

	private Row row;

	public POEditContent(Row row)
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
				Flow.next(getParent(), new POGridContent());
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
				
				if(payToParty.getDomain() == null)
					throw new WrongValueException(payToParty,lang.get("message.field.empty"));
				
				if(payToAddress.getDomain() == null)
					throw new WrongValueException(payToAddress,lang.get("message.field.empty"));
				
				if(payToContacts.getDomain() == null)
					throw new WrongValueException(payToContacts,lang.get("message.field.empty"));
				
				if(shipToParty.getDomain() == null)
					throw new WrongValueException(shipToParty,lang.get("message.field.empty"));
				
				if(shipToAddress.getDomain() == null)
					throw new WrongValueException(shipToAddress,lang.get("message.field.empty"));
				
				if(ShipToContacts.getDomain() == null)
					throw new WrongValueException(ShipToContacts,lang.get("message.field.empty"));
				
				PurchaseOrder order = service.getOne(RowUtils.id(row));
				if(order != null)
				{
					Map<String,Referenceable> vRoles = Models.toRefMap(order.getPartyOrderRoles());
					Map<String,Referenceable> vStatuses = Models.toRefMap(order.getStatuses());
					Map<String,Referenceable> vTerms = Models.toRefMap(order.getTerms());
					Map<String,Referenceable> vAdjustments = Models.toRefMap(order.getAdjustments());
					
					order.getPartyOrderRoles().clear();
					order.getStatuses().clear();
					order.getTerms().clear();
					order.getAdjustments().clear();

					order.setCurrency(currencys.getDomainAsRef());
					order.setEntryDate(DateTimes.sql(entryDate.getValue()));
					order.setOrderDate(DateTimes.sql(orderDate.getValue()));
					
					order.setBillToParty(payToParty.getDomainAsRef());
					order.setBillToAddress(payToAddress.getDomainAsRef());
					order.setBillToContact(payToContacts.getDomainAsRef());
					
					order.setPartyPlacingOrder(organizations.getDomainAsRef());
					order.setPartyTakingOrder(partyTakingOrder.getDomainAsRef());

					order.setShipToParty(shipToParty.getDomainAsRef());
					order.setShipToAddress(shipToAddress.getDomainAsRef());
					order.setShipToContact(ShipToContacts.getDomainAsRef());

					for(Component com:roles.getRows().getChildren())
					{
						Row iRow = (Row)com;

						PartyBox partyBox = (PartyBox)iRow.getChildren().get(1);
						OrderRoleTypeList roleTypeList = (OrderRoleTypeList)iRow.getChildren().get(3);

						OrderRole role = (OrderRole)vRoles.get(RowUtils.id(iRow));
						if(role == null)
							role = new OrderRole();
						
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

						OrderStatus status = (OrderStatus)vStatuses.get(RowUtils.id(iRow));
						if(status == null)
							status = new OrderStatus();
						
						status.setDate(RowUtils.timestam(iRow, 1));
						status.setOrder(order);
						status.setType(statusTypeList.getDomain());

						order.getStatuses().add(status);
					}

					for(Component com:terms.getRows().getChildren())
					{
						Row iRow = (Row)com;

						OrderTermTypeList termTypeList = (OrderTermTypeList)iRow.getChildren().get(2);

						OrderTerm term = (OrderTerm)vTerms.get(RowUtils.id(iRow));
						if(term == null)
							term = new OrderTerm();
						
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

						OrderAdjustment adjustment = (OrderAdjustment)vAdjustments.get(RowUtils.id(iRow));
						if(adjustment == null)
							adjustment = new OrderAdjustment();
						
						adjustment.setAmount(RowUtils.decimal(iRow, 2));
						adjustment.setOrder(order);
						adjustment.setPercent(RowUtils.decimal(iRow, 3));
						adjustment.setType(adjustmentTypeList.getOrderAdjustmentType());

						order.getAdjustments().add(adjustment);
					}

					service.edit(order);
				}

				Flow.next(getParent(), new POGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		PurchaseOrder order = service.getOne(RowUtils.id(row));
		if(order != null)
		{
			organizations.setDomainAsRef(order.getPartyPlacingOrder());
			orderDate.setValue(order.getOrderDate());
			entryDate.setValue(order.getEntryDate());
			partyTakingOrder.setDomainAsRef(order.getPartyTakingOrder());
			currencys.setDomainAsRef(order.getCurrency());
			orders.setText(Numbers.format(order.getTotalItems()));
			adjusts.setText(Numbers.format(order.getTotalAdjustments()));
			total.setText(Numbers.format(order.getTotalItems().add(order.getTotalAdjustments())));
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"175px"));
		grid.getColumns().appendChild(new Column(null,null,"450px"));
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.placingorder")));
		row1.appendChild(organizations);
		row1.appendChild(new Label(lang.get("order.items.grid.column.amount")));
		row1.appendChild(orders);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.orderdate")));
		row2.appendChild(orderDate);
		row2.appendChild(new Label(lang.get("order.grid.column.adjustments")));
		row2.appendChild(adjusts);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.entrydate")));
		row3.appendChild(entryDate);
		row3.appendChild(new Label(lang.get("order.grid.column.total")));
		row3.appendChild(total);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("order.grid.column.takingorder")));
		row4.appendChild(partyTakingOrder);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("order.grid.column.currency")));
		row5.appendChild(currencys);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabpanels());
		tabbox.appendChild(new Tabs());
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.paymentinfo")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.shippings")));
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.items")));
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
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.setSelectedIndex(2);
		
		appendChild(tabbox);

		initPayToParty();
		initShipToParty();
		initItems();
		initRoles();
		initStatuses();
		initTerms();
		initAdjustments();
	}

	private void initPayToParty()
	{
		payToParty.addObserver(payToAddress);
		payToParty.addObserver(payToContacts);
		
		PurchaseOrder order = service.getOne(RowUtils.id(row));
		if(order != null)
		{
			payToParty.setDomainAsRef(order.getPartyPlacingOrder());
			payToAddress.setDomainAsRef(order.getBillToAddress());
			payToContacts.setDomainAsRef(order.getBillToContact());
		}

		Grid layout = new Grid();
		layout.setWidth("100%");
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"125px"));
		layout.getColumns().appendChild(new Column());
		layout.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.payto")));
		row1.appendChild(payToParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.paytoaddress")));
		row2.appendChild(payToAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.paytocontact")));
		row3.appendChild(payToContacts);

		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);

		tabbox.getTabpanels().getFirstChild().appendChild(layout);
	}

	private void initShipToParty()
	{
		shipToParty.addObserver(shipToAddress);
		shipToParty.addObserver(ShipToContacts);
		
		PurchaseOrder order = service.getOne(RowUtils.id(row));
		if(order != null)
		{
			shipToParty.setDomainAsRef(order.getShipToParty());
			shipToAddress.setDomainAsRef(order.getShipToAddress());
			ShipToContacts.setDomainAsRef(order.getShipToContact());
		}

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
		row3.appendChild(ShipToContacts);

		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);

		tabbox.getTabpanels().getChildren().get(1).appendChild(layout);
	}

	private void initItems()
	{
		NRCToolbar nrc = new NRCToolbar(items);
		nrc.getClear().setDisabled(true);

		items.setWidth("100%");
		items.setEmptyMessage(lang.get("message.grid.empty"));
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(null,null,"25px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.product"),null,"200px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.feature"),null,"150px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"80px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.unitprice"),null,"135px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.amount"),null,"135px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("1");

		PurchaseOrder order = service.getOne(RowUtils.id(row));
		if(order != null)
		{
			for(OrderItem item:order.getItems())
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(new Label(item.getProduct().getValue()));
				row.appendChild(new Label(item.getFeature()!=null?item.getFeature().getValue():""));
				row.appendChild(new Label(Numbers.format(item.getQuantity())));
				row.appendChild(new Label(Numbers.format(item.getUntitPrice())));
				row.appendChild(new Label(Numbers.format(item.getQuantity().multiply(item.getUntitPrice()))));
				row.appendChild(new Label(item.getId()));
				row.addEventListener(Events.ON_CLICK, new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						Flow.next(getParent(), new POItemViewForm(item));
					}
				});

				items.getRows().appendChild(row);
			}
		}

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				PurchaseOrderItem item = new PurchaseOrderItem();
				item.setOrder(order);
				
				Flow.next(getParent(), new POItemForm(item));
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
							
							for(Object object:items.getRows().getChildren())
							{
								Row rw = (Row)object;
								if(RowUtils.isChecked(rw))
									ids.add(RowUtils.id(rw));
							}
							
							PurchaseOrder out = service.getOne(RowUtils.id(row));
							if(out != null)
							{
								Iterator<OrderItem> iterator = out.getItems().iterator();
								while (iterator.hasNext())
								{
									OrderItem oi = (OrderItem) iterator.next();
									for(String id:ids)
									{
										if(oi.getId().equals(id))
										{
											iterator.remove();
											break;
										}
									}
								}
								
								service.edit(out);
							}

							Flow.next(getParent(), new POEditContent(row));
						}
					}
				});
			}
		});

		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(items);
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
		roles.getColumns().appendChild(new Column());
		roles.getColumns().getLastChild().setVisible(false);
		roles.setSpan("1");

		PurchaseOrder order = service.getOne(RowUtils.id(row));
		if(order != null)
		{
			for(OrderRole role:order.getPartyOrderRoles())
			{
				PartyBox box = new PartyBox(false, true);
				box.setDomainAsRef(role.getPerson());
				OrderRoleTypeList typeList = new OrderRoleTypeList(true);
				typeList.setOrderRoleType(role.getType());

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(Components.fullspanDecimalbox(role.getPercentContribution()));
				row.appendChild(typeList);
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
				row.appendChild(PartyBox.personNolinkSpan());
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
				row.appendChild(new OrderRoleTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				roles.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(3).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(3).appendChild(roles);
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
		statuses.getColumns().appendChild(new Column());
		statuses.getColumns().getLastChild().setVisible(false);
		statuses.setSpan("2");

		PurchaseOrder order = service.getOne(RowUtils.id(row));
		if(order != null)
		{
			for(OrderStatus status:order.getStatuses())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(status.getDate()));
				row.appendChild(new StatusTypeList(true,status.getType()));
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
				row.appendChild(Components.fullSpanDatebox(new Date()));
				row.appendChild(new StatusTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				statuses.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(4).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(4).appendChild(statuses);
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
		terms.getColumns().appendChild(new Column());
		terms.getColumns().getLastChild().setVisible(false);
		terms.setSpan("1");

		PurchaseOrder order = service.getOne(RowUtils.id(row));
		if(order != null)
		{
			for(OrderTerm term:order.getTerms())
			{
				OrderTermTypeList termTypeList = new OrderTermTypeList(true);
				termTypeList.setDomain(term.getType());

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.textBox(term.getItem()));
				row.appendChild(termTypeList);
				row.appendChild(Components.fullspanDecimalbox(term.getAmount()));
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
				row.appendChild(Components.textBox(null));
				row.appendChild(new OrderTermTypeList(true));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				terms.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(5).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(5).appendChild(terms);
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
		adjustments.getColumns().appendChild(new Column());
		adjustments.getColumns().getLastChild().setVisible(false);
		adjustments.setSpan("1");

		PurchaseOrder order = service.getOne(RowUtils.id(row));
		if(order != null)
		{
			for(OrderAdjustment adjustment:order.getAdjustments())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new OrderAdjustmentTypeList(true,adjustment.getType()));
				row.appendChild(Components.fullspanDecimalbox(adjustment.getAmount()));
				row.appendChild(Components.fullspanDecimalbox(adjustment.getPercent()));
				row.appendChild(new Label(adjustment.getId()));

				adjustments.getRows().appendChild(row);
			}
		}

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
				row.appendChild(new Label(UUID.randomUUID().toString()));

				adjustments.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(6).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(6).appendChild(adjustments);
	}
}
