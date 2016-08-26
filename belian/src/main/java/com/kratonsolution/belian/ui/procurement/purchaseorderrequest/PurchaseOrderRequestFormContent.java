/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;

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
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

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
import com.kratonsolution.belian.ui.StateListener;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.component.TaxList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestFormContent extends FormContent
{	
	private PurchaseOrderRequestService service = Springs.get(PurchaseOrderRequestService.class);

	private UserService userService = Springs.get(UserService.class);

	private PersonService personService = Springs.get(PersonService.class);

	private Textbox number = Components.readOnlyTextBox(null,false);

	private OrganizationList companys = new OrganizationList();
	
	private TaxList taxes = new TaxList();

	private Textbox estimated = Components.moneyBox();

	private Textbox tax = Components.moneyBox();
	
	private Textbox total = Components.moneyBox();
	
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
				Flow.next(getParent(), new PurchaseOrderRequestGridContent());
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
				request.setTax(taxes.getTax());

				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					ProductBox box = (ProductBox)row.getChildren().get(1);

					if(box.getProduct() == null)
						throw new WrongValueException(box,lang.get("message.field.empty"));
					
					PurchaseOrderRequestItem item = new PurchaseOrderRequestItem();
					item.setNote(RowUtils.string(row, 6));
					item.setProduct(box.getProduct());
					item.setQuantity(BigDecimal.valueOf(box.getQuantity().getValue()));
					item.setEstimatedPrice(BigDecimal.valueOf(box.getPrice().getValue()));
					item.setRequest(request);

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

				Flow.next(getParent(), new PurchaseOrderRequestGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		taxes.addEventListener(Events.ON_CLICK, new InfoHandler());
		
		companys.setWidth("100%");
		number.setWidth("100%");
		number.setText(PurchaseOrderRequest.NCODE+System.currentTimeMillis());

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());

		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("porequest.grid.column.company")));
		row0.appendChild(companys);
		row0.appendChild(new Label(lang.get("porequest.grid.column.estimated")));
		row0.appendChild(estimated);

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("porequest.grid.column.number")));
		row1.appendChild(number);
		row1.appendChild(new Label(lang.get("porequest.grid.column.tax")));
		row1.appendChild(tax);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("porequest.grid.column.date")));
		row2.appendChild(date);
		row2.appendChild(new Label(lang.get("porequest.grid.column.total")));
		row2.appendChild(total);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("porequest.grid.column.tax")));
		row3.appendChild(taxes);
		
		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
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
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.quantity"),null,"65px"));
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.uom"),null,"75px"));
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.price"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.total"),null,"100px"));
		items.getColumns().appendChild(new Column(lang.get("porequest.grid.column.note"),null,"150px"));
		items.setSpan("1");
		
		nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ProductBox box = new ProductBox();
				box.addListener(new InfoHandler());
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(box.getQuantity());
				row.appendChild(box.getUoms());
				row.appendChild(box.getPrice());
				row.appendChild(box.getTotal());
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
	
	private class InfoHandler implements StateListener,EventListener<Event>
	{
		@Override
		public void stateChanged()
		{
			BigDecimal price = BigDecimal.ZERO;
			
			for(Component com:items.getRows().getChildren())
			{
				Row row = (Row)com;
				ProductBox box = (ProductBox)row.getChildren().get(1);
			
				price = price.add(BigDecimal.valueOf(box.getQuantity().getValue()*box.getPrice().getValue()));
			}
		
			BigDecimal tx = price.multiply(taxes.getTax().getAmount()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP);
			
			estimated.setText(Numbers.format(price));
			tax.setText(Numbers.format(tx));
			total.setText(Numbers.format(price.add(tx)));
		}

		@Override
		public void onEvent(Event arg0) throws Exception
		{
			stateChanged();
		}
	}
}