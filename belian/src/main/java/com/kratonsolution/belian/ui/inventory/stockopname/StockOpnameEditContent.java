/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockopname;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.inventory.dm.StockOpname;
import com.kratonsolution.belian.inventory.dm.StockOpnameItem;
import com.kratonsolution.belian.inventory.svc.StockOpnameService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockOpnameEditContent extends FormContent
{	
	private StockOpnameService service = Springs.get(StockOpnameService.class);
	
	private Grid items = new Grid();

	private Row row;

	public StockOpnameEditContent(Row row)
	{
		super();
		this.row = row;
		
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
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				StockOpnameWindow window = (StockOpnameWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		StockOpname stock = service.findOne(RowUtils.string(row, 4));
		if(stock != null)
		{
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.getRows().appendChild(RowUtils.row("Date", Dates.format(stock.getDate())));
			grid.getRows().appendChild(RowUtils.row("Company", stock.getOrganization().getName()));
			grid.getRows().appendChild(RowUtils.row("Facility", stock.getFacility().getName()));
		}
	}
	
	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null, "150px"));
		items.getColumns().appendChild(new Column("Onhand",null, "75px"));
		items.getColumns().appendChild(new Column("Opname",null, "75px"));
		items.getColumns().appendChild(new Column("UoM",null, "100px"));
		items.getColumns().appendChild(new Column("Note",null, "150px"));
		items.setSpan("0");
		
		StockOpname stock = service.findOne(RowUtils.string(row, 4));
		if(stock != null)
		{
			for(StockOpnameItem item:stock.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getProduct().getName()));
				row.appendChild(Components.label(item.getOnhand()));
				row.appendChild(Components.label(item.getOpnamed()));
				row.appendChild(new Label(item.getProduct().getUom().getName()));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
		}
		
		appendChild(items);
	}
}
