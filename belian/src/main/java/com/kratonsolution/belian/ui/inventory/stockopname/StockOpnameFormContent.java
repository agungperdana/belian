/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockopname;

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

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.StockOpname;
import com.kratonsolution.belian.inventory.dm.StockOpnameItem;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.InventoryItemService;
import com.kratonsolution.belian.inventory.svc.StockOpnameService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockOpnameFormContent extends FormContent
{	
	private StockOpnameService service = Springs.get(StockOpnameService.class);
	
	private InventoryItemService itemService = Springs.get(InventoryItemService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private Datebox date = Components.currentDatebox();
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Listbox facilitys = Components.newSelect(facilityService.findAllActive(),true);
	
	private Listbox users = Components.newSelect(utils.getUser().getPerson());
	
	private Grid items = new Grid();
	
	public StockOpnameFormContent()
	{
		super();
		initToolbar();
		initForm();
		initItems();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				StockOpnameWindow window = (StockOpnameWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				
				StockOpname opname = new StockOpname();
				opname.setDate(new Date(date.getValue().getTime()));
				opname.setOrganization(utils.getOrganization());
				opname.setFacility(facilityService.findOne(Components.string(facilitys)));
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					InventoryItem inv = itemService.findOne(RowUtils.string(row, 5));
					if(inv != null)
					{
						StockOpnameItem item = new StockOpnameItem();
						item.setNote(RowUtils.string(row, 4));
						item.setParent(opname);
						item.setProduct(inv.getProduct());
						item.setOnhand(inv.getOnhand());
						item.setOpnamed(RowUtils.decimal(row, 2));
						
						opname.getItems().add(item);
					}
				}
				
				service.add(opname);
				
				StockOpnameWindow window = (StockOpnameWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		facilitys.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initData();
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Date"));
		row1.appendChild(date);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Company"));
		row2.appendChild(companys);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Facility"));
		row4.appendChild(facilitys);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row4);
	}
	
	private void initItems()
	{
		items.setWidth("100%");
		items.setEmptyMessage("No inventory Item exist inside facility");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null, "150px"));
		items.getColumns().appendChild(new Column("Onhand",null, "75px"));
		items.getColumns().appendChild(new Column("Opname",null, "75px"));
		items.getColumns().appendChild(new Column("UoM",null, "100px"));
		items.getColumns().appendChild(new Column("Note",null, "150px"));
		items.getColumns().appendChild(new Column(null,null, "0px"));
		items.getColumns().getChildren().get(5).setVisible(false);
		items.setSpan("0");
		initData();
		appendChild(items);
	}
	
	private void initData()
	{
		items.getRows().getChildren().clear();
		
		Facility facility = facilityService.findOne(Components.string(facilitys));
		if(facility != null)
		{
			for(InventoryItem inv:facility.getInventorys())
			{
				Row row = new Row();
				row.appendChild(new Label(inv.getProduct().getName()));
				row.appendChild(Components.label(inv.getOnhand()));
				row.appendChild(Components.doubleBox(inv.getOnhand().doubleValue()));
				row.appendChild(new Label(inv.getProduct().getUom().getName()));
				row.appendChild(Components.textBox(null));
				row.appendChild(new Label(inv.getId()));
				
				items.getRows().appendChild(row);
			}
		}
	}
}
