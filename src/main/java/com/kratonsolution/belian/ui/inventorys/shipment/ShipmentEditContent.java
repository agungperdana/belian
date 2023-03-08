/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.shipment;

import java.math.BigDecimal;
import java.util.Date;
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
import org.zkoss.zul.Decimalbox;
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
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentItem;
import com.kratonsolution.belian.shipment.dm.ShipmentStatus;
import com.kratonsolution.belian.shipment.svc.ShipmentItemService;
import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.party.PartyAddressList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.general.party.PartyContactList;
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
public class ShipmentEditContent extends AbstractForm
{	
	private ShipmentService service = Springs.get(ShipmentService.class);

	private ShipmentItemService itemService = Springs.get(ShipmentItemService.class);
	
	private Textbox number = Components.readOnlyTextBox(null,false);
	
	private Datebox entryDate = Components.currentDatebox();
	
	private Datebox estShipDate = Components.currentDatebox();
	
	private Datebox estReadyDate = Components.currentDatebox();

	private Datebox estArrivalDate = Components.currentDatebox();
	
	private Datebox cancelDate = Components.currentDatebox();
	
	private Decimalbox estShipCost = Components.decimalbox(BigDecimal.ZERO);
	
	private Decimalbox actShipCost = Components.decimalbox(BigDecimal.ZERO);
	
	private Textbox instruction = Components.stdTextBox(null, false);
	
	private ShipmentTypeList types = new ShipmentTypeList(false);

	private PartyBox shipFromParty = new PartyBox(false,false);

	private PartyAddressList shipFromAddress = new PartyAddressList(false, null);

	private PartyContactList shipFromContact = new PartyContactList(false, null);
	
	private PartyBox partyPlacingOrder = new PartyBox(false,false);

	private PartyBox shipToParty = new PartyBox(true,false);

	private PartyAddressList shipToAddress = new PartyAddressList(false, null);

	private PartyContactList shipToContacts = new PartyContactList(false, null);

	private Tabbox tabbox = new Tabbox();
	
	private Grid from = new Grid();
	
	private Grid to = new Grid();
	
	private Grid statuses = new Grid();
	
	private Grid items = new Grid();

	private Row row;

	public ShipmentEditContent(Row row)
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
				Flow.next(getParent(), new ShipmentGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Shipment shipment = service.findOne(RowUtils.id(row));
				if(shipment != null && shipment.isEditable())
				{
					if(types.getDomain() == null)
						throw new WrongValueException(types,lang.get("message.field.empty"));
					
					if(entryDate.getValue() == null)
						throw new WrongValueException(entryDate,lang.get("message.field.empty"));
					
					if(estShipDate.getValue() == null)
						throw new WrongValueException(estShipDate,lang.get("message.field.empty"));
					
					if(estReadyDate.getValue() == null)
						throw new WrongValueException(estReadyDate,lang.get("message.field.empty"));
					
					if(estArrivalDate.getValue() == null)
						throw new WrongValueException(estReadyDate,lang.get("message.field.empty"));
					
					if(estShipCost.getValue() == null)
						throw new WrongValueException(estShipCost,lang.get("message.field.empty"));
					
					shipment.setActShipCost(actShipCost.getValue());
					shipment.setAllowableCancelDate(DateTimes.sql(cancelDate.getValue()));
					shipment.setEntryDate(DateTimes.sql(entryDate.getValue()));
					shipment.setEstArrivalDate(DateTimes.sql(estArrivalDate.getValue()));
					shipment.setEstReadyDate(DateTimes.sql(estReadyDate.getValue()));
					shipment.setEstShipCost(estShipCost.getValue());
					shipment.setEstShipDate(DateTimes.sql(estShipDate.getValue()));
					shipment.setInstruction(instruction.getText());
					shipment.setLastUpdated(DateTimes.currentDate());
					
					Map<String,ShipmentStatus> stats = new HashMap<>();
					for(ShipmentStatus status:shipment.getStatuses())
						stats.put(status.getId(), status);
					
					shipment.getStatuses().clear();
					
					for(Component com:statuses.getRows().getChildren())
					{
						Row rw = (Row)com;
						
						ShipmentStatusTypeList list = (ShipmentStatusTypeList)com.getChildren().get(2);
						
						ShipmentStatus status = stats.containsKey(RowUtils.id(rw))?stats.get(RowUtils.id(rw)):new ShipmentStatus();
						status.setDate(RowUtils.timestam(rw, 1));
						status.setType(list.getDomain());
						status.setShipment(shipment);
						
						shipment.getStatuses().add(status);
					}
					
					service.edit(shipment);
					
					Flow.next(getParent(), new ShipmentEditContent(row));
				}
			}
		});
	}

	@Override
	public void initForm()
	{
		Shipment shipment = service.findOne(RowUtils.id(row));
		if(shipment != null)
		{
			number.setText(shipment.getNumber());
			actShipCost.setValue(shipment.getActShipCost());
			cancelDate.setValue(shipment.getAllowableCancelDate());
			entryDate.setValue(shipment.getEntryDate());
			estArrivalDate.setValue(shipment.getEstArrivalDate());
			estReadyDate.setValue(shipment.getEstReadyDate());
			estShipCost.setValue(shipment.getEstShipCost());
			estShipDate.setValue(shipment.getEstShipDate());
			instruction.setText(shipment.getInstruction());
			shipFromAddress.setDomainAsRef(shipment.getShipFromAddress());
			shipFromContact.setDomainAsRef(shipment.getShipFromContact());
			shipFromParty.setDomainAsRef(shipment.getShipFromParty());
			shipToAddress.setDomainAsRef(shipment.getShipToAddress());
			shipToContacts.setDomainAsRef(shipment.getShipToContact());
			shipToParty.setDomainAsRef(shipment.getShipToParty());
			types.setDomain(shipment.getType());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"155px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"160px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("shipment.grid.column.number")));
		row1.appendChild(number);
		row1.appendChild(new Label(lang.get("shipment.grid.column.shipdate")));
		row1.appendChild(estShipDate);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("shipment.grid.column.type")));
		row2.appendChild(types);
		row2.appendChild(new Label(lang.get("shipment.grid.column.readydate")));
		row2.appendChild(estReadyDate);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("shipment.grid.column.entrydate")));
		row3.appendChild(entryDate);
		row3.appendChild(new Label(lang.get("shipment.grid.column.arrivaldate")));
		row3.appendChild(estArrivalDate);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("shipment.grid.column.estimatedcost")));
		row4.appendChild(estShipCost);
		row4.appendChild(new Label(lang.get("shipment.grid.column.canceldate")));
		row4.appendChild(cancelDate);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("shipment.grid.column.actualcost")));
		row5.appendChild(actShipCost);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("shipment.grid.column.instruction")));
		row6.appendChild(instruction);
		
		grid.getRows().appendChild(row1);
		grid.getRows().appendChild(row2);
		grid.getRows().appendChild(row3);
		grid.getRows().appendChild(row4);
		grid.getRows().appendChild(row5);
		grid.getRows().appendChild(row6);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabpanels());
		tabbox.appendChild(new Tabs());
		tabbox.getTabs().appendChild(new Tab(lang.get("shipment.grid.column.shipfrominfo")));
		tabbox.getTabs().appendChild(new Tab(lang.get("shipment.grid.column.shiptoinfo")));
		tabbox.getTabs().appendChild(new Tab(lang.get("shipment.grid.column.statuses")));
		tabbox.getTabs().appendChild(new Tab(lang.get("shipment.grid.column.items")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
		
		tabbox.setSelectedIndex(3);

		initShipFromParty();
		initShipToParty();
		initStatuses();
		initItems();
	}

	private void initShipFromParty()
	{
		shipFromParty.addObserver(shipFromAddress);
		shipFromParty.addObserver(shipFromContact);
		
		from.setWidth("100%");
		from.appendChild(new Columns());
		from.getColumns().appendChild(new Column(null,null,"125px"));
		from.getColumns().appendChild(new Column());
		from.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("shipment.grid.column.shipfromparty")));
		row1.appendChild(shipFromParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("shipment.grid.column.shipfromaddress")));
		row2.appendChild(shipFromAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("shipment.grid.column.shipfromcontact")));
		row3.appendChild(shipFromContact);

		from.getRows().appendChild(row1);
		from.getRows().appendChild(row2);
		from.getRows().appendChild(row3);

		tabbox.getTabpanels().getFirstChild().appendChild(from);
	}
	
	private void initShipToParty()
	{
		shipToParty.addObserver(shipToAddress);
		shipToParty.addObserver(shipToContacts);
		
		to.setWidth("100%");
		to.appendChild(new Columns());
		to.getColumns().appendChild(new Column(null,null,"125px"));
		to.getColumns().appendChild(new Column());
		to.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("shipment.grid.column.shiptoparty")));
		row1.appendChild(shipToParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("shipment.grid.column.shiptoaddress")));
		row2.appendChild(shipToAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("shipment.grid.column.shiptocontact")));
		row3.appendChild(shipToContacts);

		to.getRows().appendChild(row1);
		to.getRows().appendChild(row2);
		to.getRows().appendChild(row3);

		tabbox.getTabpanels().getChildren().get(1).appendChild(to);
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

		Shipment shipment = service.findOne(RowUtils.id(row));
		if(shipment != null)
		{
			for(ShipmentStatus status:shipment.getStatuses())
			{
				Row row = new Row();
				row.appendChild(Components.readOnlyCheckbox());
				row.appendChild(Components.datetime(status.getDate(),true));
				row.appendChild(new ShipmentStatusTypeList(true,status.getType()));
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
				row.appendChild(new ShipmentStatusTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				statuses.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(statuses);
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
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.product"),null,"200px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.note"),null,"200px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"200px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("1");
		
		Shipment shipment = service.findOne(RowUtils.id(row));
		if(shipment != null)
		{
			for(ShipmentItem item:shipment.getItems())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(new Label(item.getProduct().getValue()));
				row.appendChild(new Label(item.getContent()));
				row.appendChild(new Label(Numbers.format(item.getQuantity())));
				row.appendChild(new Label(item.getId()));
				row.addEventListener(Events.ON_CLICK,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event ev) throws Exception
					{
						Flow.next(getParent(), new ShipmentItemEditForm(itemService.findOne(RowUtils.id(row))));
					}
				});
			
				items.getRows().appendChild(row);
			}
			
			if(!shipment.isEditable())
			{
				nrc.getNew().setDisabled(true);
				nrc.getRemove().setDisabled(true);
			}
		}
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(getParent(), new ShipmentItemForm(shipment));
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
							
							service.deleteItem(shipment,ids);
						}
					}
				});
			}
		});
		
		tabbox.getTabpanels().getChildren().get(3).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(3).appendChild(items);
	}
}
