/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockadjustment;

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
import com.kratonsolution.belian.inventory.dm.StockAdjustment;
import com.kratonsolution.belian.inventory.dm.StockAdjustmentItem;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.StockAdjustmentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentFormContent extends FormContent
{	
	private StockAdjustmentService service = Springs.get(StockAdjustmentService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private Datebox date = Components.currentDatebox();
	
	private Listbox companys = Components.newSelect(utils.getOrganization());
	
	private Listbox facilitys = Components.newSelect(facilityService.findAllActive(),true);
	
	private Listbox users = Components.newSelect(utils.getUser().getPerson());
	
	private Grid items = new Grid();
	
	public StockAdjustmentFormContent()
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
				StockAdjustmentWindow window = (StockAdjustmentWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				
				StockAdjustment stock = new StockAdjustment();
				stock.setDate(new Date(date.getValue().getTime()));
				stock.setOrganization(utils.getOrganization());
				stock.setFacility(facilityService.findOne(Components.string(facilitys)));
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					StockAdjustmentItem item = new StockAdjustmentItem();
					item.setNote(RowUtils.string(row, 4));
					item.setParent(stock);
					item.setProduct(Components.product(row, 1));
					item.setQuantity(RowUtils.decimal(row, 2));
					
					stock.getItems().add(item);
				}
				
				service.add(stock);
				
				StockAdjustmentWindow window = (StockAdjustmentWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
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
		NRCToolbar nrc = new NRCToolbar(items);
		
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(null,null, "25px"));
		items.getColumns().appendChild(new Column("Product",null, "150px"));
		items.getColumns().appendChild(new Column("Quantity",null, "90px"));
		items.getColumns().appendChild(new Column("UoM",null, "100px"));
		items.getColumns().appendChild(new Column("Expired",null, "125px"));
		items.getColumns().appendChild(new Column("Note",null, "150px"));
		items.setSpan("0");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				
				ProductBox box = new ProductBox();
			
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(Components.doubleBox(1d));
				row.appendChild(box.getUoms());
				row.appendChild(Components.textBox(null));
				
				items.getRows().appendChild(row);
			}
		});
		
		appendChild(nrc);
		appendChild(items);
	}
}
