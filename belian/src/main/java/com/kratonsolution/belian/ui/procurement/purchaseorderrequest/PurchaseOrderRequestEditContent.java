/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.kratonsolution.belian.global.dm.Roled;
import com.kratonsolution.belian.global.dm.RoledType;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.procurement.dm.PORRole;
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
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestEditContent extends FormContent
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

						ProductBox box = (ProductBox)row.getChildren().get(1);

						if(box.getProduct() == null)
							throw new WrongValueException(box,lang.get("message.field.empty"));
						
						PurchaseOrderRequestItem item = new PurchaseOrderRequestItem();
						item.setNote(RowUtils.string(row, 6));
						item.setProduct(box.getProduct());
						item.setQuantity(BigDecimal.valueOf(box.getQuantity().getValue()));
						item.setEstimatedPrice(BigDecimal.valueOf(box.getPrice().getValue()));
						item.setRequest(request);
						item.setId(RowUtils.id(row));

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
						role.setId(RowUtils.id(row));
						
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
		companys.setWidth("100%");
		number.setWidth("100%");
		
		PurchaseOrderRequest request = service.findOne(RowUtils.id(row));
		if(request != null)
		{
			number.setText(request.getNumber());
			companys.setOrganization(request.getOrganization());
			taxes.setTax(request.getTax());
			date.setValue(request.getDate());
			estimated.setText(Numbers.format(request.getEstimatedCost()));

			BigDecimal txt = BigDecimal.ZERO;
			
			if(request.getTax() != null)
				txt = request.getEstimatedCost().multiply(request.getTax().getAmount()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP);

			tax.setText(Numbers.format(txt));
			total.setText(Numbers.format(request.getEstimatedCost().add(txt)));
			
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
		nrc.getRemove().addEventListener(Events.ON_CLICK, new InfoHandler());
		nrc.getClear().addEventListener(Events.ON_CLICK, new InfoHandler());

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
		items.getColumns().appendChild(new Column());
		items.setSpan("1");
		items.getColumns().getLastChild().setVisible(false);

		PurchaseOrderRequest request = service.findOne(RowUtils.id(row));
		if(request != null)
		{
			nrc.getNew().setDisabled(request.getLastStatus().getType().equals(StatusType.Approved));
			nrc.getRemove().setDisabled(request.getLastStatus().getType().equals(StatusType.Approved));
			nrc.getClear().setDisabled(request.getLastStatus().getType().equals(StatusType.Approved));
			
			for(PurchaseOrderRequestItem item:request.getItems())
			{
				ProductBox box = new ProductBox();
				box.setProduct(item.getProduct());
				box.getQuantity().setValue(item.getQuantity().doubleValue());
				box.getPrice().setValue(item.getEstimatedPrice()!=null?item.getEstimatedPrice().doubleValue():0d);
				box.getTotal().setValue(item.getEstimatedPrice()!=null?item.getQuantity().multiply(item.getEstimatedPrice()).doubleValue():0d);
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(box.getQuantity());
				row.appendChild(box.getUoms());
				row.appendChild(box.getPrice());
				row.appendChild(box.getTotal());
				row.appendChild(Components.textBox(item.getNote()));
				row.appendChild(Components.label(item.getId()));

				items.getRows().appendChild(row);
			}
		}

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
				row.appendChild(Components.label(UUID.randomUUID().toString()));

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

		PurchaseOrderRequest request = service.findOne(RowUtils.id(row));
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
