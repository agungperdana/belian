
package com.kratonsolution.belian.ui.orders.request;

import java.math.BigDecimal;

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
import com.kratonsolution.belian.orders.dm.Request;
import com.kratonsolution.belian.orders.dm.RequestItem;
import com.kratonsolution.belian.orders.dm.RequestRole;
import com.kratonsolution.belian.orders.svc.RequestService;
import com.kratonsolution.belian.ui.BForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.general.uom.UOMList;
import com.kratonsolution.belian.ui.orders.RequestTypeList;
import com.kratonsolution.belian.ui.orders.RoleTypeList;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequestFormContent extends BForm
{	
	private RequestService service = Springs.get(RequestService.class);
	
	private Datebox entryDate = Components.currentDatebox();
	
	private Datebox sendDate = Components.currentDatebox();
	
	private Datebox requiredDate = Components.datebox();
	
	private Textbox note = Components.textBox(null);
	
	private RequestTypeList typeList = new RequestTypeList(false);
	
	private CompanyStructureList origin = new CompanyStructureList(false);
	
	private PartyBox suppliers = new PartyBox(true);
	
	private Grid items = new Grid();
	
	private Grid roles = new Grid();

	private Tabbox tabbox = new Tabbox();
	
	public RequestFormContent()
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
				Flow.next(getParent(), new RequestGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(entryDate.getValue() == null)
					throw new WrongValueException(entryDate, lang.get("message.field.empty"));
				
				if(sendDate.getValue() == null)
					throw new WrongValueException(sendDate, lang.get("message.field.empty"));
				
				if(requiredDate.getValue() == null)
					throw new WrongValueException(requiredDate, lang.get("message.field.empty"));
				
				if(suppliers.getDomain() == null)
					throw new WrongValueException(suppliers, lang.get("message.field.empty"));
				
				if(origin.getDomain() == null)
					throw new WrongValueException(origin, lang.get("message.field.empty"));
				
				if(typeList.getRequestType() == null)
					throw new WrongValueException(typeList, lang.get("message.field.empty"));
			
				Request request = new Request();
				request.setDescription(note.getText());
				request.setEntryDate(DateTimes.sql(entryDate.getValue()));
				request.setOrderDate(DateTimes.sql(sendDate.getValue()));
				request.setRequiredDate(DateTimes.sql(requiredDate.getValue()));
				request.setOriginator(origin.getDomainAsRef());
				request.setResponding(suppliers.getDomainAsRef());
				request.setType(typeList.getRequestType());
				request.setNumber(numberGen.generate(request.getEntryDate(), request.getOriginator().getId(), Code.REQ));
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					ProductBox box = (ProductBox)row.getChildren().get(1);
					
					RequestItem item = new RequestItem();
					item.setDescription(RowUtils.string(row, 2));
					item.setMaxAllowablePrice(RowUtils.decimal(row, 6));
					item.setProduct(box.getDomainAsRef());
					item.setQuantity(RowUtils.decimal(row, 4));
					item.setRequest(request);
					item.setRequiredDate(RowUtils.sql(row, 3));
					
					request.getItems().add(item);
				}
				
				for(Component com:roles.getRows().getChildren())
				{
					Row row = (Row)com;
				
					PartyBox box = (PartyBox)row.getChildren().get(1);
					RoleTypeList list = (RoleTypeList)row.getChildren().get(2);
					
					RequestRole role = new RequestRole();
					role.setPerson(box.getDomainAsRef());
					role.setType(list.getDomain());
					role.setRequest(request);
					
					request.getRoles().add(role);
				}
				
				service.add(request);
				
				Flow.next(getParent(), new RequestGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		origin.setDomain(utils.getOrganization());
		
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.organization")));
		row1.appendChild(origin);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.entrydate")));
		row2.appendChild(entryDate);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.orderdate")));
		row3.appendChild(sendDate);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("order.grid.column.requireddate")));
		row4.appendChild(requiredDate);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("order.grid.column.type")));
		row5.appendChild(typeList);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("order.grid.column.suppliers")));
		row6.appendChild(suppliers);
		
		Row row7 = new Row();
		row7.appendChild(new Label(lang.get("order.grid.column.description")));
		row7.appendChild(note);
		
		addRow(row1);
		addRow(row2);
		addRow(row3);
		addRow(row4);
		addRow(row5);
		addRow(row6);
		addRow(row7);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("porequest.grid.column.items")));
		tabbox.getTabs().appendChild(new Tab(lang.get("porequest.grid.column.roles")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initItems();
		initRolesGrid();
	}

	public void initItems()
	{
		NRCToolbar nrc = new NRCToolbar(items);

		items.setWidth("100%");
		items.setEmptyMessage(lang.get("message.grid.empty"));
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(null,null,"25px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.product"),null,"150px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.note"),null,"200px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.requireddate"),null,"110px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.uom"),null,"90px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.maxallowed"),null,"100px"));
		items.setSpan("1");

		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				UOMList uoms = new UOMList(true);
				
				ProductBox box = new ProductBox(false, true);
				box.addObserver(uoms);
				
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(box);
				row.appendChild(Components.textBox(null));
				row.appendChild(Components.fullSpanDatebox(DateTimes.currentDate()));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ONE));
				row.appendChild(uoms);
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ONE));
				
				items.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(0).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(0).appendChild(items);
	}

	private void initRolesGrid()
	{
		NRCToolbar bar = new NRCToolbar(roles);

		roles.appendChild(new Columns());
		roles.appendChild(new Rows());
		roles.setEmptyMessage(lang.get("message.grid.empty"));
		roles.getColumns().appendChild(new Column(null,null,"25px"));
		roles.getColumns().appendChild(new Column(lang.get("porequest.grid.column.person"),null,"150px"));
		roles.getColumns().appendChild(new Column(lang.get("porequest.grid.column.type"),null,"125px"));
		roles.setSpan("1");

		bar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(new PartyBox(false,true,true));
				row.appendChild(new RoleTypeList(true));
				
				roles.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(1).appendChild(bar);
		tabbox.getTabpanels().getChildren().get(1).appendChild(roles);
	}
}