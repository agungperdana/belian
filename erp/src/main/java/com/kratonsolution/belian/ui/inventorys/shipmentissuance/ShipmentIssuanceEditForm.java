
package com.kratonsolution.belian.ui.inventorys.shipmentissuance;

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

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.orders.svc.OrderItemService;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuance;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuanceItem;
import com.kratonsolution.belian.shipment.dm.ShipmentIssuanceRole;
import com.kratonsolution.belian.shipment.svc.ShipmentIssuanceService;
import com.kratonsolution.belian.shipment.svc.ShipmentItemService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.inventorys.shipment.ShipmentIssuableList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentIssuanceEditForm extends AbstractForm
{	
	private ShipmentIssuanceService service = Springs.get(ShipmentIssuanceService.class);

	private ShipmentItemService shipmentItemService = Springs.get(ShipmentItemService.class);

	private OrderItemService orderItemService = Springs.get(OrderItemService.class);

	private Datebox date = Components.currentDatebox();

	private Textbox number = Components.autonumber();

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private PartyBox destinations = new PartyBox(true,false);
	
	private ShipmentIssuableList shipments = new ShipmentIssuableList(false);

	private Tabbox tabbox = new Tabbox();

	private Grid items = new Grid();

	private Grid roles = new Grid();

	private String on;
	
	public ShipmentIssuanceEditForm(String on)
	{
		super();

		this.on = on;

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
				Flow.next(getParent(), new ShipmentIssuanceGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		ShipmentIssuance issuance = service.getOne(on);
		if(issuance != null)
		{
			number.setText(issuance.getNumber());
			
			date.setValue(issuance.getDate());
			date.setDisabled(true);

			destinations.setDomainAsRef(issuance.getDestination());
			destinations.setDisabled();

			organizations.setDomainAsRef(issuance.getOrganization());
			organizations.setDisabled(true);
			
			shipments.setDomainAsRef(issuance.getShipment());
		}

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
		items.getColumns().appendChild(new Column(null,null,"25px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.date"),null,"80px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.product"),null,"200px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.ordered"),null,"60px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.expired"),null,"120px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.serial"),null,"125px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.facility"),null,"150px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentissuance.grid.column.container"),null,"150px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("2");

		tabbox.getTabpanels().getFirstChild().appendChild(items);

		ShipmentIssuance out = service.getOne(on);
		if(out != null)
		{
			for(ShipmentIssuanceItem item:out.getItems())
			{
				Row row = new Row();
				row.appendChild(Components.readOnlyCheckbox());
				row.appendChild(new Label(DateTimes.format(out.getDate())));
				row.appendChild(new Label(item.getProduct().getValue()));
				row.appendChild(new Label(Numbers.format(item.getQuantity())));
				row.appendChild(new Label(DateTimes.format(item.getExpired())));
				row.appendChild(new Label(item.getSerial()));
				row.appendChild(new Label(item.getFacility().getValue()));
				row.appendChild(new Label(item.getContainer().getValue()));
				row.appendChild(new Label(item.getId()));

				items.getRows().appendChild(row);
			}
		}
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
		
		ShipmentIssuance out = service.getOne(on);
		if(out != null)
		{
			for(ShipmentIssuanceRole role:out.getRoles())
			{
				Row row = new Row();
				row.appendChild(Components.readOnlyCheckbox());
				row.appendChild(new Label(role.getParty().getValue()));
				row.appendChild(new Label(role.getType().display(utils.getLanguage())));

				roles.getRows().appendChild(row);
			}
		}

		
		tabbox.getTabpanels().getLastChild().appendChild(roles);
	}
}
