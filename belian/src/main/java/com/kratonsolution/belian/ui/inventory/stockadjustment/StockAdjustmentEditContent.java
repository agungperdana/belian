/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockadjustment;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.StockAdjustment;
import com.kratonsolution.belian.inventory.dm.StockAdjustmentItem;
import com.kratonsolution.belian.inventory.svc.StockAdjustmentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentEditContent extends FormContent
{	
	private StockAdjustmentService service = Springs.get(StockAdjustmentService.class);
	
	private Grid items = new Grid();

	private Row row;

	public StockAdjustmentEditContent(Row row)
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
				StockAdjustmentWindow window = (StockAdjustmentWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				StockAdjustmentWindow window = (StockAdjustmentWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		StockAdjustment stock = service.findOne(RowUtils.string(row, 4));
		if(stock != null)
		{
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.getRows().appendChild(RowUtils.row("Date", DateTimes.format(stock.getDate())));
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
		items.getColumns().appendChild(new Column("Quantity",null, "90px"));
		items.getColumns().appendChild(new Column("UoM",null, "100px"));
		items.getColumns().appendChild(new Column("Note",null, "150px"));
		items.setSpan("0");
		
		StockAdjustment stock = service.findOne(RowUtils.string(row, 4));
		if(stock != null)
		{
			for(StockAdjustmentItem item:stock.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getProduct().getName()));
				row.appendChild(Components.label(item.getQuantity()));
				row.appendChild(new Label(item.getProduct().getUom().getName()));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
		}
		
		appendChild(items);
	}
}
