
package com.kratonsolution.belian.ui.inventorys.shipment;

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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.shipment.dm.Shipment;
import com.kratonsolution.belian.shipment.dm.ShipmentStatus;
import com.kratonsolution.belian.shipment.dm.ShipmentStatusType;
import com.kratonsolution.belian.shipment.svc.ShipmentService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.party.PartyAddressList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.general.party.PartyContactList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ShipmentFormContent extends AbstractForm
{	
	private ShipmentService service = Springs.get(ShipmentService.class);

	private Datebox entryDate = Components.currentDatebox();
	
	private Datebox estShipDate = Components.currentDatebox();
	
	private Datebox estReadyDate = Components.currentDatebox();

	private Datebox estArrivalDate = Components.currentDatebox();
	
	private Datebox cancelDate = Components.currentDatebox();
	
	private Decimalbox estShipCost = Components.decimalbox(BigDecimal.ZERO);
	
	private Decimalbox actShipCost = Components.decimalbox(BigDecimal.ZERO);
	
	private Textbox instruction = Components.stdTextBox(null, false);
	
	private ShipmentTypeList types = new ShipmentTypeList(false);

	private PartyBox shipFromParty = new PartyBox(true,false);

	private PartyAddressList shipFromAddress = new PartyAddressList(false, null);

	private PartyContactList shipFromContact = new PartyContactList(false, null);
	
	private PartyBox partyPlacingOrder = new PartyBox(true,false);

	private PartyBox shipToParty = new PartyBox(true,false);

	private PartyAddressList shipToAddress = new PartyAddressList(false, null);

	private PartyContactList shipToContacts = new PartyContactList(false, null);

	private Tabbox tabbox = new Tabbox();
	
	private Grid statuses = new Grid();
	
	public ShipmentFormContent()
	{
		super();
		
		initToolbar();
		initForm();
		initTabbox();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(getParent(), new ShipmentGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
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
				
				if(shipFromParty.getDomain() == null)
					throw new WrongValueException(shipFromParty,lang.get("message.field.empty"));
				
				if(shipToParty.getDomain() == null)
					throw new WrongValueException(shipToParty,lang.get("message.field.empty"));

				Shipment shipment = new Shipment();
				shipment.setActShipCost(actShipCost.getValue());
				shipment.setAllowableCancelDate(DateTimes.sql(cancelDate.getValue()));
				shipment.setEntryDate(DateTimes.sql(entryDate.getValue()));
				shipment.setEstArrivalDate(DateTimes.sql(estArrivalDate.getValue()));
				shipment.setEstReadyDate(DateTimes.sql(estReadyDate.getValue()));
				shipment.setEstShipCost(estShipCost.getValue());
				shipment.setEstShipDate(DateTimes.sql(estShipDate.getValue()));
				shipment.setInstruction(instruction.getText());
				shipment.setLastUpdated(DateTimes.currentDate());
				shipment.setShipFromAddress(shipFromAddress.getDomainAsRef());
				shipment.setShipFromContact(shipFromContact.getDomainAsRef());
				shipment.setShipFromParty(shipFromParty.getDomainAsRef());
				shipment.setShipToAddress(shipToAddress.getDomainAsRef());
				shipment.setShipToContact(shipToContacts.getDomainAsRef());
				shipment.setShipToParty(shipToParty.getDomainAsRef());
				shipment.setType(types.getDomain());

				for(Component com:statuses.getRows().getChildren())
				{
					Row rw = (Row)com;
					
					ShipmentStatusTypeList list = (ShipmentStatusTypeList)com.getChildren().get(2);
					
					ShipmentStatus status = new ShipmentStatus();
					status.setDate(RowUtils.timestam(rw, 1));
					status.setType(list.getDomain());
					status.setShipment(shipment);
					
					shipment.getStatuses().add(status);
				}
				
				service.add(shipment);
				
				Flow.next(getParent(), new ShipmentEditContent(RowUtils.shield(shipment.getId())));
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"155px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"165px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("shipment.grid.column.shipdate")));
		row1.appendChild(estShipDate);
		row1.appendChild(new Label(lang.get("shipment.grid.column.readydate")));
		row1.appendChild(estReadyDate);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("shipment.grid.column.type")));
		row2.appendChild(types);
		row2.appendChild(new Label(lang.get("shipment.grid.column.arrivaldate")));
		row2.appendChild(estArrivalDate);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("shipment.grid.column.entrydate")));
		row3.appendChild(entryDate);
		row3.appendChild(new Label(lang.get("shipment.grid.column.canceldate")));
		row3.appendChild(cancelDate);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("shipment.grid.column.instruction")));
		row4.appendChild(instruction);
		row4.appendChild(new Label(lang.get("shipment.grid.column.estimatedcost")));
		row4.appendChild(estShipCost);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("shipment.grid.column.actualcost")));
		row5.appendChild(actShipCost);
		
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
		tabbox.getTabs().appendChild(new Tab(lang.get("shipment.grid.column.shipfrominfo")));
		tabbox.getTabs().appendChild(new Tab(lang.get("shipment.grid.column.shiptoinfo")));
		tabbox.getTabs().appendChild(new Tab(lang.get("shipment.grid.column.statuses")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initShipFromParty();
		initShipToParty();
		initStatuses();
	}

	private void initShipFromParty()
	{
		shipFromParty.addObserver(shipFromAddress);
		shipFromParty.addObserver(shipFromContact);
		
		Grid layout = new Grid();
		layout.setWidth("100%");
		layout.appendChild(new Columns());
		layout.getColumns().appendChild(new Column(null,null,"125px"));
		layout.getColumns().appendChild(new Column());
		layout.appendChild(new Rows());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("shipment.grid.column.shipfromparty")));
		row1.appendChild(shipFromParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("shipment.grid.column.shipfromaddress")));
		row2.appendChild(shipFromAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("shipment.grid.column.shipfromcontact")));
		row3.appendChild(shipFromContact);

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
		row1.appendChild(new Label(lang.get("shipment.grid.column.shiptoparty")));
		row1.appendChild(shipToParty);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("shipment.grid.column.shiptoaddress")));
		row2.appendChild(shipToAddress);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("shipment.grid.column.shiptocontact")));
		row3.appendChild(shipToContacts);

		layout.getRows().appendChild(row1);
		layout.getRows().appendChild(row2);
		layout.getRows().appendChild(row3);

		tabbox.getTabpanels().getChildren().get(1).appendChild(layout);
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
				row.appendChild(new ShipmentStatusTypeList(true));

				statuses.getRows().appendChild(row);
			}
		});

		ShipmentStatusTypeList list = new ShipmentStatusTypeList(true,ShipmentStatusType.SCHEDULED);
		list.setDisabled(true);
		
		Row row = new Row();
		row.appendChild(Components.readOnlyCheckbox());
		row.appendChild(Components.fullSpanReadOnlyDatebox(new Date()));
		row.appendChild(list);

		statuses.getRows().appendChild(row);
		
		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(statuses);
	}
}
