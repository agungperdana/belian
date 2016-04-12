/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import java.sql.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.dm.RoledType;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.procurement.dm.PORRole;
import com.kratonsolution.belian.procurement.dm.PORStatus;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequest;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestItem;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.security.svc.UserService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestFormContent extends FormContent
{	
private PurchaseOrderRequestService service = Springs.get(PurchaseOrderRequestService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private UserService userService = Springs.get(UserService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private Textbox number = Components.readOnlyTextBox();
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Datebox date = Components.currentDatebox();
	
	private Grid items = new Grid();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid rolesGrid = new Grid();
	
	public PurchaseOrderRequestFormContent()
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
				PurchaseOrderRequestWindow window = (PurchaseOrderRequestWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PurchaseOrderRequest request = new PurchaseOrderRequest();
				request.setNumber(number.getText());
				request.setDate(new Date(date.getValue().getTime()));
				request.setOrganization(utils.getOrganization());
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					PurchaseOrderRequestItem item = new PurchaseOrderRequestItem();
					item.setNote(RowUtils.string(row, 4));
					item.setProduct(Components.product(row, 1));
					item.setRequest(request);
					item.setQuantity(RowUtils.decimal(row, 2));
					
					request.getItems().add(item);
				}
				
				PORStatus status = new PORStatus();
				status.setDate(request.getDate());
				status.setDescription("Just Created");
				status.setParty(utils.getUser().getPerson());
				status.setRequest(request);
				status.setType(StatusType.Created);
				
				request.setLastStatus(status);
				request.getStatuses().add(status);
				
				PORRole initiator = new PORRole();
				initiator.setParty(utils.getUser().getPerson());
				initiator.setRequest(request);
				initiator.setType(RoledType.Initiator);
				initiator.setDone(true);
				
				PORRole requested = new PORRole();
				requested.setParty(utils.getOrganization());
				requested.setRequest(request);
				requested.setType(RoledType.Requested);
				requested.setDone(true);
				
				request.getRoles().add(initiator);
				request.getRoles().add(requested);
				
				for(Component com:rolesGrid.getRows().getChildren())
				{
					Row row = (Row)com;
					
					PORRole role = new PORRole();
					role.setRequest(request);
					role.setParty(personService.findOne(RowUtils.string(row, 1)));
					role.setType(RoledType.valueOf(RowUtils.string(row, 2)));
					
					request.getRoles().add(role);
				}
				
				service.add(request);
				
				PurchaseOrderRequestWindow window = (PurchaseOrderRequestWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		number.setText(PurchaseOrderRequest.NCODE+System.currentTimeMillis());
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row0 = new Row();
		row0.appendChild(new Label("Number"));
		row0.appendChild(number);
		
		Row row1 = new Row();
		row1.appendChild(new Label("Date"));
		row1.appendChild(date);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Company"));
		row2.appendChild(companys);
		
		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
	}
	
	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Item(s)"));
		tabbox.getTabs().appendChild(new Tab("Role(s)"));
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
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(null,null,"25px"));
		items.getColumns().appendChild(new Column("Product",null,"150px"));
		items.getColumns().appendChild(new Column("Quantity",null,"100px"));
		items.getColumns().appendChild(new Column("UoM",null,"100px"));
		items.getColumns().appendChild(new Column("Note",null,"150px"));
		items.setSpan("1");
		
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ProductBox box = new ProductBox();
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(Components.doubleBox(1));
				row.appendChild(box.getUoms());
				row.appendChild(Components.textBox(null));
				
				items.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(0).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(0).appendChild(items);
	}
	
	private void initRolesGrid()
	{
		NRCToolbar bar = new NRCToolbar(rolesGrid);
		
		rolesGrid.appendChild(new Columns());
		rolesGrid.appendChild(new Rows());
		rolesGrid.getColumns().appendChild(new Column(null,null,"25px"));
		rolesGrid.getColumns().appendChild(new Column("Person",null,"150px"));
		rolesGrid.getColumns().appendChild(new Column("Type",null,"125px"));
		rolesGrid.setSpan("1");
		
		bar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanSelect(personService.findAll(),true));
				
				Listbox listbox = Components.fullSpanSelect();
				listbox.appendItem(RoledType.Reviewer.name(), RoledType.Reviewer.name());
				listbox.appendItem(RoledType.Approver.name(), RoledType.Approver.name());
				
				row.appendChild(listbox);
				
				rolesGrid.getRows().appendChild(row);
			}
		});
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(bar);
		tabbox.getTabpanels().getChildren().get(1).appendChild(rolesGrid);
	}
}