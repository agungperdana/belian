
package com.kratonsolution.belian.ui.inventorys.shipmentreceipt;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
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
import com.kratonsolution.belian.orders.svc.OrderItemService;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentReceipt;
import com.kratonsolution.belian.shipment.dm.ShipmentReceiptItem;
import com.kratonsolution.belian.shipment.dm.ShipmentReceiptRole;
import com.kratonsolution.belian.shipment.svc.ShipmentItemService;
import com.kratonsolution.belian.shipment.svc.ShipmentReceiptService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.inventorys.shipment.ShipmentReceiptableList;
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
public class ShipmentReceiptEditForm extends AbstractForm
{	
	private ShipmentReceiptService service = Springs.get(ShipmentReceiptService.class);

	private ShipmentItemService shipmentItemService = Springs.get(ShipmentItemService.class);

	private OrderItemService orderItemService = Springs.get(OrderItemService.class);

	private Datebox date = Components.currentDatebox();

	private Textbox number = Components.autonumber();

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private PartyBox suppliers = new PartyBox(false,false);
	
	private ShipmentReceiptableList shipments = new ShipmentReceiptableList(false);

	private Tabbox tabbox = new Tabbox();

	private Grid items = new Grid();

	private Grid roles = new Grid();

	private Row row;
	
	public ShipmentReceiptEditForm(Row row)
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
				Flow.next(getParent(), new ShipmentReceiptGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new ShipmentReceiptGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		ShipmentReceipt receipt = service.findById(RowUtils.id(row));
		if(receipt != null)
		{
			date.setValue(receipt.getDate());
			organizations.setDomainAsRef(receipt.getOrganization());
			suppliers.setDomainAsRef(receipt.getSource());
			shipments.setDomainAsRef(receipt.getShipment());
		}
		
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
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.ordered"),null,"60px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.accepted"),null,"70px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.rejected"),null,"60px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.expired"),null,"120px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.serial"),null,"125px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.facility"),null,"135px"));
		items.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.container"),null,"135px"));
		items.setSpan("1");
		
		ShipmentReceipt receipt = service.findById(RowUtils.id(row));
		if(receipt != null)
		{
			for(ShipmentReceiptItem item:receipt.getItems())
			{
				ShipmentItem shipmentItem = shipmentItemService.findById(item.getShipmentItem().getId());
				if(shipmentItem != null)
				{
					Row row = new Row();
					row.appendChild(new Label(item.getProduct().getValue()));
					row.appendChild(new Label(Numbers.format(shipmentItem.getQuantity())));
					row.appendChild(new Label(Numbers.format(item.getAccepted())));
					row.appendChild(new Label(Numbers.format(item.getRejected())));
					row.appendChild(new Label(DateTimes.format(item.getExpired())));
					row.appendChild(new Label(item.getSerial()));
					row.appendChild(new Label(item.getFacility().getValue()));
					row.appendChild(new Label(item.getContainer().getValue()));

					items.getRows().appendChild(row);
				}
			}
		}
		
		tabbox.getTabpanels().getFirstChild().appendChild(items);
	}

	private void initRoles()
	{
		roles.setWidth("100%");
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.appendChild(new Columns());
		roles.appendChild(new Rows());
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("shipmentreceipt.grid.column.person"),null,"250px"));
		roles.getColumns().appendChild(new Column(lang.get("shipment.grid.column.type"),null,"150px"));
		roles.setSpan("1");

		ShipmentReceipt receipt = service.findById(RowUtils.id(row));
		if(receipt != null)
		{
			for(ShipmentReceiptRole role:receipt.getRoles())
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(new Label(role.getParty().getValue()));
				row.appendChild(new Label(role.getType().display(utils.getLanguage())));
				
				roles.getRows().appendChild(row);
			}
		}
		
		tabbox.getTabpanels().getLastChild().appendChild(roles);
	}
}
