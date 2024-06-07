
package com.kratonsolution.belian.ui.inventorys.shipmentreceipt;

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

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentReceipt;
import com.kratonsolution.belian.shipment.dm.ShipmentReceiptItem;
import com.kratonsolution.belian.shipment.dm.ShipmentReceiptRole;
import com.kratonsolution.belian.shipment.dm.ShipmentRoleType;
import com.kratonsolution.belian.shipment.svc.ShipmentItemService;
import com.kratonsolution.belian.shipment.svc.ShipmentReceiptService;
import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.inventory.facility.ContainerList;
import com.kratonsolution.belian.ui.inventory.facility.FacilityList;
import com.kratonsolution.belian.ui.inventorys.shipment.ShipmentReceiptableList;
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
public class ShipmentReceiptForm extends AbstractForm
{	
	private ShipmentService shipmentService = Springs.get(ShipmentService.class);

	private ShipmentReceiptService service = Springs.get(ShipmentReceiptService.class);

	private ShipmentItemService shipmentItemService = Springs.get(ShipmentItemService.class);

	private Datebox date = Components.currentDatebox();

	private Textbox number = Components.autonumber();

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private PartyBox suppliers = new PartyBox(true,false);

	private ShipmentReceiptableList shipments = new ShipmentReceiptableList(false);

	private Tabbox tabbox = new Tabbox();

	private Grid items = new Grid();

	private Grid roles = new Grid();

	public ShipmentReceiptForm()
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
				Flow.next(getParent(), new ShipmentReceiptGridContent());
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

				if(suppliers.getDomain() == null)
					throw new WrongValueException(suppliers, lang.get("message.field.empty"));

				ShipmentReceipt receipt = new ShipmentReceipt();
				receipt.setDate(DateTimes.sql(date.getValue()));
				receipt.setOrganization(organizations.getDomainAsRef());
				receipt.setSource(suppliers.getDomainAsRef());
				receipt.setShipment(shipments.getDomainAsRef());

				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					if(RowUtils.decimal(row, 2).compareTo(BigDecimal.ZERO) > 0 || RowUtils.decimal(row, 3).compareTo(BigDecimal.ZERO) > 0)
					{
						FacilityList facilityList = (FacilityList)com.getChildren().get(6);
						ContainerList containerList = (ContainerList)com.getChildren().get(7);

						if(facilityList.getDomain() == null)
							throw new WrongValueException(facilityList,lang.get("message.field.empty"));

						if(containerList.getDomain() == null)
							throw new WrongValueException(containerList,lang.get("message.field.empty"));

						ShipmentItem shipmentItem = shipmentItemService.findById(RowUtils.id(row));
						if(shipmentItem != null)
						{
							ShipmentReceiptItem item = new ShipmentReceiptItem();
							item.setAccepted(RowUtils.decimal(row, 2));
							item.setRejected(RowUtils.decimal(row, 3));					
							item.setExpired(RowUtils.sql(row, 4));
							item.setSerial(RowUtils.string(row, 5));
							item.setFacility(facilityList.getDomainAsRef());
							item.setContainer(containerList.getDomainAsRef());
							item.setProduct(shipmentItem.getProduct());
							item.setShipmentItem(shipmentItem.toRef());
							item.setReceipt(receipt);

							receipt.getItems().add(item);
						}
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

					ShipmentReceiptRole role = new ShipmentReceiptRole();
					role.setReceipt(receipt);
					role.setParty(box.getDomainAsRef());
					role.setType(list.getDomain());

					receipt.getRoles().add(role);
				}

				if(receipt.getItems().isEmpty())
					throw new WrongValueException(shipments,"no shipment item selected.");
				
				service.add(receipt);
				
				Flow.next(getParent(), new ShipmentReceiptGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		suppliers.addObserver(shipments);
		shipments.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(shipments.getDomain() == null)
					throw new WrongValueException(shipments,lang.get("message.field.empty"));
			
				Shipment shipment = shipmentService.findById(shipments.getDomainAsRef().getId());
				if(shipment != null && !shipment.isDelivered())
				{
					for(ShipmentItem item :shipment.getItems())
					{
						if(item.isReceiptable())
						{
							ContainerList containerList = new ContainerList(true);

							FacilityList facilityList = new FacilityList(true);
							facilityList.addObserver(containerList);

							Row row = new Row();
							row.appendChild(new Label(item.getProduct().getValue()));
							row.appendChild(new Label(Numbers.format(item.getQuantity().subtract(item.getReceipted()))));
							row.appendChild(Components.fullspanDecimalbox(item.getQuantity().subtract(item.getReceipted())));
							row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
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
		});

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("shipmentreceipt.grid.column.date")));
		row1.appendChild(date);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("shipmentreceipt.grid.column.organization")));
		row2.appendChild(organizations);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("shipmentreceipt.grid.column.supplier")));
		row3.appendChild(suppliers);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("shipmentreceipt.grid.column.shipment")));
		row4.appendChild(shipments);

		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("shipmentreceipt.grid.column.items")));
		tabbox.getTabs().appendChild(new Tab(lang.get("shipmentreceipt.grid.column.roles")));
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
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.product"),null,"200px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.ordered"),null,"75px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.accepted"),null,"75px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.rejected"),null,"75px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.expired"),null,"125px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.serial"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.facility"),null,"125px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.container"),null,"125px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("0");
		
		tabbox.getTabpanels().getFirstChild().appendChild(items);
	}

	private void initRoles()
	{
		NRCToolbar nrc = new NRCToolbar(roles);

		roles.setWidth("100%");
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.appendChild(new Columns());
		roles.appendChild(new Rows());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.person"),null,"250px"));
		roles.getColumns().appendChild(new Column(lang.get("shipment.grid.column.type"),null,"150px"));
		roles.setSpan("1");

		PartyBox receiver = PartyBox.personNolinkSpan();
		receiver.setDomain(utils.getPerson());
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(receiver);
		row.appendChild(new ShipmentRoleTypeList(true, ShipmentRoleType.RECEIVER));

		roles.getRows().appendChild(row);

		nrc.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(PartyBox.personNolinkSpan());
				row.appendChild(new ShipmentRoleTypeList(true));

				roles.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getLastChild().appendChild(roles);
	}
}
