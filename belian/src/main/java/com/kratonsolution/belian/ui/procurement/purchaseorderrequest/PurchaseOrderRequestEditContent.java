/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import java.util.UUID;
import java.util.Vector;

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
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.dm.Roled;
import com.kratonsolution.belian.global.dm.RoledType;
import com.kratonsolution.belian.procurement.dm.PORRole;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequest;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestItem;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.security.svc.UserService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestEditContent extends FormContent
{	
	private PurchaseOrderRequestService service = Springs.get(PurchaseOrderRequestService.class);

	private UserService userService = Springs.get(UserService.class);

	private PersonService personService = Springs.get(PersonService.class);

	private Textbox number = Components.readOnlyTextBox();

	private Listbox companys = Components.newSelect();

	private Datebox date = Components.currentDatebox();

	private Grid items = new Grid();

	private Grid rolesGrid = new Grid();

	private Tabbox tabbox = new Tabbox();

	private Row row;

	public PurchaseOrderRequestEditContent(Row row)
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
		PurchaseOrderRequest request = service.findOne(RowUtils.id(row));
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new PurchaseOrderRequestGridContent());
			}
		});

		toolbar.getSave().setDisabled(request.isDone());
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(request != null && !request.isDone())
				{
					Vector<PurchaseOrderRequestItem> vItems = new Vector<>();
					for(Component com:items.getRows().getChildren())
					{
						Row row = (Row)com;

						PurchaseOrderRequestItem item = new PurchaseOrderRequestItem();
						item.setNote(RowUtils.string(row, 4));
						item.setProduct(Components.product(row, 1));
						item.setRequest(request);
						item.setQuantity(RowUtils.decimal(row, 2));

						vItems.add(item);
					}
					
					Vector<PORRole> vRoles = new Vector<>();
					for(Component com:rolesGrid.getRows().getChildren())
					{
						Row row = (Row)com;

						PORRole role = new PORRole();
						role.setRequest(request);
						role.setParty(personService.findOne(RowUtils.string(row, 1)));
						role.setType(RoledType.valueOf(RowUtils.string(row, 2)));
						role.setId(RowUtils.string(row, 3));
						
						vRoles.add(role);
					}

					service.edit(request,vItems,vRoles);
				}

				Flow.next(getParent(), new PurchaseOrderRequestGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		PurchaseOrderRequest request = service.findOne(RowUtils.id(row));
		if(request != null)
		{
			if(Strings.isNullOrEmpty(request.getNumber()))
				request.setNumber(PurchaseOrderRequest.NCODE+System.currentTimeMillis());

			number.setText(request.getNumber());
			date.setValue(request.getDate());
			companys.appendChild(new Listitem(request.getOrganization().getLabel(),request.getOrganization().getValue()));
			companys.setSelectedIndex(0);

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());

			Row row0 = new Row();
			row0.appendChild(new Label(lang.get("porequest.grid.column.number")));
			row0.appendChild(number);

			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("porequest.grid.column.date")));
			row1.appendChild(date);

			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("porequest.grid.column.company")));
			row2.appendChild(companys);

			rows.appendChild(row0);
			rows.appendChild(row1);
			rows.appendChild(row2);
		}
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
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.product"),null,"150px"));
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.quantity"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.uom"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.note"),null,"150px"));
		items.setSpan("1");

		PurchaseOrderRequest request = service.findOne(RowUtils.string(row, 5));
		if(request != null)
		{
			for(PurchaseOrderRequestItem item:request.getItems())
			{
				ProductBox box = new ProductBox();
				box.setProduct(item.getProduct());

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(Components.doubleBox(item.getQuantity().doubleValue()));
				row.appendChild(box.getUoms());
				row.appendChild(Components.textBox(item.getNote()));

				items.getRows().appendChild(row);
			}
		}

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
		rolesGrid.setEmptyMessage(lang.get("message.grid.empty"));
		rolesGrid.getColumns().appendChild(new Column(null,null,"25px"));
		rolesGrid.getColumns().appendChild(new Column(lang.get("porequest.grid.column.person"),null,"150px"));
		rolesGrid.getColumns().appendChild(new Column(lang.get("porequest.grid.column.type"),null,"125px"));
		rolesGrid.getColumns().appendChild(new Column());
		rolesGrid.getColumns().getLastChild().setVisible(false);
		rolesGrid.setSpan("1");

		PurchaseOrderRequest request = service.findOne(RowUtils.string(row, 5));
		if(request != null)
		{
			for(Roled roled:request.getRoles())
			{
				Row row = new Row();
				row.appendChild(Components.readOnlyCheckbox());
				row.appendChild(Components.fullSpanSelect(roled.getParty()));
				row.appendChild(Components.fullSpanSelect(roled.getType().name(), roled.getType().name()));
				row.appendChild(new Label(roled.getId()));

				rolesGrid.getRows().appendChild(row);
			}
		}

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
				row.appendChild(new Label(UUID.randomUUID().toString()));

				rolesGrid.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(1).appendChild(bar);
		tabbox.getTabpanels().getChildren().get(1).appendChild(rolesGrid);
	}
}
