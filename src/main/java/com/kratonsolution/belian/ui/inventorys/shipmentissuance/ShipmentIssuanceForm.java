
package com.kratonsolution.belian.ui.inventorys.shipmentissuance;

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
import com.kratonsolution.belian.orders.svc.OrderItemService;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuance;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuanceItem;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuanceRole;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentRoleType;
import com.kratonsolution.belian.shipment.svc.ShipmentIssuanceService;
import com.kratonsolution.belian.shipment.svc.ShipmentItemService;
import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.inventory.facility.ContainerList;
import com.kratonsolution.belian.ui.inventory.facility.FacilityList;
import com.kratonsolution.belian.ui.inventorys.shipment.ShipmentIssuableList;
import com.kratonsolution.belian.ui.inventorys.shipment.ShipmentRoleTypeList;
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
public class ShipmentIssuanceForm extends AbstractForm
{	
	private ShipmentIssuanceService service = Springs.get(ShipmentIssuanceService.class);

	private ShipmentItemService shipmentItemService = Springs.get(ShipmentItemService.class);

	private ShipmentService shipmentService = Springs.get(ShipmentService.class);
	
	private OrderItemService orderItemService = Springs.get(OrderItemService.class);

	private Datebox date = Components.currentDatebox();

	private Textbox number = Components.autonumber();

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private PartyBox destinations = new PartyBox(true,false);
	
	private ShipmentIssuableList shipments = new ShipmentIssuableList(false);

	private ShipmentIssuance issuance;

	private Tabbox tabbox = new Tabbox();

	private Grid items = new Grid();

	private Grid roles = new Grid();

	public ShipmentIssuanceForm()
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
				Flow.next(getParent(), new ShipmentIssuanceGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(date.getValue() == null)
					throw new WrongValueException(date, lang.get("message.field.empty"));

				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations, lang.get("message.field.empty"));

				if(destinations.getDomain() == null)
					throw new WrongValueException(destinations, lang.get("message.field.empty"));

				ShipmentIssuance issuance = new ShipmentIssuance();
				issuance.setDate(DateTimes.sql(date.getValue()));
				issuance.setOrganization(organizations.getDomainAsRef());
				issuance.setDestination(destinations.getDomainAsRef());
				issuance.setShipment(shipments.getDomainAsRef());

				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;

					ShipmentItem shipmentItem = shipmentItemService.getOne(RowUtils.id(row));
					if(shipmentItem != null)
					{
						FacilityList facilityList = (FacilityList)com.getChildren().get(5);
						ContainerList containerList = (ContainerList)com.getChildren().get(6);

						if(facilityList.getDomain() == null)
							throw new WrongValueException(facilityList,lang.get("message.field.empty"));

						if(containerList.getDomain() == null)
							throw new WrongValueException(containerList,lang.get("message.field.empty"));

						ShipmentIssuanceItem item = new ShipmentIssuanceItem();
						item.setQuantity(RowUtils.decimal(row, 2));
						item.setExpired(RowUtils.sql(row, 3));
						item.setSerial(RowUtils.string(row, 4));
						item.setProduct(shipmentItem.getProduct());
						item.setFacility(facilityList.getDomainAsRef());
						item.setContainer(containerList.getDomainAsRef());
						item.setShipmentItem(shipmentItem.toRef());
						item.setIssuance(issuance);
						
						issuance.getItems().add(item);
					}
				}

				for(Component com:roles.getRows().getChildren())
				{
					PartyBox box = (PartyBox)com.getChildren().get(1);
					ShipmentRoleTypeList list = (ShipmentRoleTypeList)com.getChildren().get(2);

					if(box.getDomain() == null)
						throw new WrongValueException(box,lang.get("message.field.empty"));

					if(list.getDomain() == null)
						throw new WrongValueException(list,lang.get("message.field.empty"));

					ShipmentIssuanceRole role = new ShipmentIssuanceRole();
					role.setIssuance(issuance);
					role.setParty(box.getDomainAsRef());
					role.setType(list.getDomain());

					issuance.getRoles().add(role);
				}

				service.add(issuance);
				
				Flow.next(getParent(), new ShipmentIssuanceGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		destinations.addObserver(shipments);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("shipmentissuance.grid.column.number")));
		row1.appendChild(number);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("shipmentissuance.grid.column.date")));
		row2.appendChild(date);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("shipmentissuance.grid.column.organization")));
		row3.appendChild(organizations);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("shipmentissuance.grid.column.customer")));
		row4.appendChild(destinations);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("shipmentissuance.grid.column.shipment")));
		row5.appendChild(shipments);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("shipmentissuance.grid.column.items")));
		tabbox.getTabs().appendChild(new Tab(lang.get("shipmentissuance.grid.column.roles")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initItems();
		initRoles();
	}

	private void initItems()
	{
		items.setWidth("100%");
		items.setEmptyMessage(lang.get("message.grid.empty"));
		items.appendChild(new Columns());
		items.appendChild(new Rows());
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.date"),null,"80px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.product"),null,"200px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.ordered"),null,"60px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.expired"),null,"120px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.serial"),null,"125px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.facility"),null,"150px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.container"),null,"150px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("1");

		tabbox.getTabpanels().getFirstChild().appendChild(items);

		shipments.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(shipments.getDomain() != null)
				{
					Shipment out = shipmentService.getOne(shipments.getDomainAsRef().getId());
					if(out != null)
					{
						for(ShipmentItem item:out.getItems())
						{
							if(item.isIssuable())
							{
								FacilityList facilityList = new FacilityList(true);
								
								ContainerList containerList = new ContainerList(true);
								
								facilityList.addObserver(containerList);
								
								Row row = new Row();
								row.appendChild(new Label(DateTimes.format(out.getEntryDate())));
								row.appendChild(new Label(item.getProduct().getValue()));
								row.appendChild(new Label(Numbers.format(item.getQuantity().subtract(item.getIssuance()))));
								row.appendChild(Components.fullSpanDatebox(null));
								row.appendChild(Components.textBox(null));
								row.appendChild(facilityList);
								row.appendChild(containerList);
								row.appendChild(new Label(item.getId()));

								items.getRows().appendChild(row);
							}
						}
					}
				}
			}
		});
	}

	private void initRoles()
	{
		roles.setWidth("100%");
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.appendChild(new Columns());
		roles.appendChild(new Rows());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.person"),null,"250px"));
		roles.getColumns().appendChild(new Column(lang.get("shipment.grid.column.type"),null,"150px"));
		roles.setSpan("1");

		NRCToolbar nrc = new NRCToolbar(roles);
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new PartyBox(false,true,true));
				row.appendChild(new ShipmentRoleTypeList(true));

				roles.getRows().appendChild(row);
			}
		});

		PartyBox box = new PartyBox(false,true,utils.getPerson());
		box.setReadonly();

		ShipmentRoleTypeList list = new ShipmentRoleTypeList(true,ShipmentRoleType.ISSUER);
		list.setDisabled(true);

		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(box);
		row.appendChild(list);

		roles.getRows().appendChild(row);

		tabbox.getTabpanels().getLastChild().appendChild(nrc);
		tabbox.getTabpanels().getLastChild().appendChild(roles);
	}

//	private class ShipmentItemObserver implements Observer
//	{
//		@Override
//		public void valueChange(IDValueRef value)
//		{
//			if(value != null && !Strings.isNullOrEmpty(value.getId()) && organizations.getDomain() != null)
//			{
//				items.getRows().getChildren().clear();
//
//				for(ShipmentItem shipmentItem:shipmentItemService.findAllIssuable(utils.getOrganization().getId(), value.getId()))
//				{
//					for(ShipmentOrder order:shipmentItem.getOrders())
//					{
//						OrderItem orderItem = orderItemService.getOne(order.getOrderItem().getId());
//						if(orderItem != null && orderItem.getQuantity().subtract(orderItem.getProcessed()).compareTo(BigDecimal.ZERO) > 0)
//						{
//							Decimalbox accepted = Components.fullspanDecimalbox(orderItem.getQuantity().subtract(orderItem.getProcessed()));
//							Decimalbox rejected = Components.fullspanDecimalbox(BigDecimal.ZERO);
//							Datebox expired = Components.fullSpanDatebox(Dates.now());
//							Textbox serial = Components.textBox(null);
//
//							ContainerList containerList = new ContainerList(true);
//
//							FacilityList facilityList = new FacilityList(true);
//							facilityList.addObserver(containerList);
//
//							accepted.setReadonly(true);
//							rejected.setReadonly(true);
//							expired.setDisabled(true);
//							serial.setReadonly(true);
//							containerList.setDisabled(true);
//							facilityList.setDisabled(true);
//
//							Checkbox box = Components.checkbox(false);
//							box.addEventListener(Events.ON_CHECK, new EventListener<CheckEvent>()
//							{
//								@Override
//								public void onEvent(CheckEvent ev) throws Exception
//								{
//									if(ev.isChecked())
//									{
//										accepted.setReadonly(false);
//										rejected.setReadonly(false);
//										expired.setDisabled(false);
//										serial.setReadonly(false);
//										containerList.setDisabled(false);
//										facilityList.setDisabled(false);
//									}
//									else
//									{
//										accepted.setReadonly(true);
//										rejected.setReadonly(true);
//										expired.setDisabled(true);
//										serial.setReadonly(true);
//										containerList.setDisabled(true);
//										facilityList.setDisabled(true);
//									}
//								}
//							});
//
//							Row row = new Row();
//							row.appendChild(box);
//							row.appendChild(new Label(DateTimes.format(orderItem.getOrder().getEntryDate())));
//							row.appendChild(new Label(orderItem.getOrder().getNumber()));
//							row.appendChild(new Label(orderItem.getProduct().getValue()));
//							row.appendChild(new Label(Numbers.format(orderItem.getQuantity().subtract(orderItem.getProcessed()))));
//							row.appendChild(accepted);
//							row.appendChild(rejected);
//							row.appendChild(expired);
//							row.appendChild(serial);
//							row.appendChild(facilityList);
//							row.appendChild(containerList);
//							row.appendChild(new Label(orderItem.getId()));
//							row.appendChild(new Label(shipmentItem.getId()));
//
//							items.getRows().appendChild(row);
//						}
//					}
//				}
//			}
//		}
//	}
}
