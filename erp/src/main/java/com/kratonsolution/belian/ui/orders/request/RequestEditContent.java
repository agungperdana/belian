
package com.kratonsolution.belian.ui.orders.request;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Component;
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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.orders.dm.Request;
import com.kratonsolution.belian.orders.dm.RequestItem;
import com.kratonsolution.belian.orders.dm.RequestRole;
import com.kratonsolution.belian.orders.svc.RequestService;
import com.kratonsolution.belian.ui.AbstractForm;
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
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequestEditContent extends AbstractForm
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

	private Row row;

	public RequestEditContent(Row row)
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
		Request request = service.getOne(RowUtils.id(row));
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new RequestGridContent());
			}
		});

		toolbar.getSave().setDisabled(request!=null?!request.isEditable():false);
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				request.setDescription(note.getText());
				request.setEntryDate(DateTimes.sql(entryDate.getValue()));
				request.setOrderDate(DateTimes.sql(sendDate.getValue()));
				request.setRequiredDate(DateTimes.sql(requiredDate.getValue()));
				request.setOriginator(origin.getDomainAsRef());
				request.setResponding(suppliers.getDomainAsRef());
				request.setType(typeList.getRequestType());
				
				Map<String,RequestItem> itemMap = new HashMap<>();
				for(RequestItem item:request.getItems())
					itemMap.put(item.getId(), item);
				
				Map<String,RequestRole> roleMap = new HashMap<>();
				for(RequestRole role:request.getRoles())
					roleMap.put(role.getId(), role);
				
				request.getItems().clear();
				request.getRoles().clear();
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					ProductBox box = (ProductBox)row.getChildren().get(1);
					
					RequestItem item = itemMap.containsKey(RowUtils.id(row))?itemMap.get(RowUtils.id(row)):new RequestItem();
						
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
					
					RequestRole role = roleMap.containsKey(RowUtils.id(row))?roleMap.get(RowUtils.id(row)):new RequestRole();
					role.setPerson(box.getDomainAsRef());
					role.setType(list.getDomain());
					role.setRequest(request);
					
					request.getRoles().add(role);
				}

				service.edit(request);
			}
		});
		
		toolbar.appendChild(toolbar.getClose());
		toolbar.getClose().setDisabled(request.isClosed());
		toolbar.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				toolbar.getClose().setDisabled(true);
				request.setClosed(true);
				service.edit(request);
			}
		});
	}

	@Override
	public void initForm()
	{
		Request request = service.getOne(RowUtils.id(row));
		if(request != null)
		{
			entryDate.setValue(request.getEntryDate());
			sendDate.setValue(request.getOrderDate());
			requiredDate.setValue(request.getRequiredDate());
			typeList.setRequestType(request.getType());
			origin.setDomainAsRef(request.getOriginator());
			suppliers.setDomainAsRef(request.getResponding());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("order.grid.column.entrydate")));
		row1.appendChild(entryDate);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("order.grid.column.orderdate")));
		row2.appendChild(sendDate);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("order.grid.column.requireddate")));
		row3.appendChild(requiredDate);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("order.grid.column.type")));
		row4.appendChild(typeList);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("order.grid.column.organization")));
		row5.appendChild(origin);

		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("order.grid.column.suppliers")));
		row6.appendChild(suppliers);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
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
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("1");

		Request request = service.getOne(RowUtils.id(row));
		if(request != null)
		{
			for(RequestItem item:request.getItems())
			{
				UOMList uoms = new UOMList(true);
				
				ProductBox box = new ProductBox(false, true);
				box.setDomainAsRef(item.getProduct());
				box.addObserver(uoms);

				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(box);
				row.appendChild(Components.textBox(item.getDescription()));
				row.appendChild(Components.fullSpanDatebox(item.getRequiredDate()));
				row.appendChild(Components.fullspanDecimalbox(item.getQuantity()));
				row.appendChild(uoms);
				row.appendChild(Components.fullspanDecimalbox(item.getMaxAllowablePrice()));
				row.appendChild(new Label(item.getId()));

				items.getRows().appendChild(row);
			}
		}

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
				row.appendChild(Components.decimalbox(BigDecimal.ONE));
				row.appendChild(uoms);
				row.appendChild(Components.decimalbox(BigDecimal.ONE));
				row.appendChild(new Label("0"));

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
		roles.getColumns().appendChild(new Column());
		roles.getColumns().getLastChild().setVisible(false);
		roles.setSpan("1");

		Request request = service.getOne(RowUtils.id(row));
		if(request != null)
		{
			for(RequestRole role:request.getRoles())
			{
				PartyBox box = new PartyBox(false,true,true);
				box.setDomainAsRef(role.getPerson());
				
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(box);
				row.appendChild(new RoleTypeList(true,role.getType()));
				row.appendChild(new Label(role.getId()));

				roles.getRows().appendChild(row);
			}
		}
		
		bar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(new PartyBox(false,true,true));
				row.appendChild(new RoleTypeList(true));
				row.appendChild(new Label("0"));
				
				roles.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(1).appendChild(bar);
		tabbox.getTabpanels().getChildren().get(1).appendChild(roles);
	}
}
