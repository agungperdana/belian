/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.goodreceive;

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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.inventory.dm.GoodsReceive;
import com.kratonsolution.belian.inventory.dm.GoodsReceiveItem;
import com.kratonsolution.belian.inventory.svc.GoodsReceiveService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GoodsReceiveEditContent extends FormContent
{	
	private GoodsReceiveService service = Springs.get(GoodsReceiveService.class);
	
	private Datebox date = Components.currentDatebox();

	private Textbox number = Components.stdTextBox(null,true);
	
	private Listbox companys = Components.newSelect();

	private Listbox receiveables = Components.newSelect();

	private Listbox facilitys = Components.newSelect();

	private Listbox users = Components.newSelect();

	private Grid items = new Grid();

	private Row row;

	public GoodsReceiveEditContent(Row row)
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
				GoodsReceiveWindow window = (GoodsReceiveWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{


				GoodsReceiveWindow window = (GoodsReceiveWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		GoodsReceive goodsReceive = service.findOne(RowUtils.string(row, 5));
		if(goodsReceive != null)
		{
			date.setValue(goodsReceive.getDate());
			number.setText(goodsReceive.getNumber());
			companys.appendChild(new Listitem(goodsReceive.getOrganization().getLabel(), goodsReceive.getOrganization().getValue()));
			facilitys.appendChild(new Listitem(goodsReceive.getDestination().getLabel(), goodsReceive.getDestination().getValue()));
			users.appendChild(new Listitem(goodsReceive.getReceiver().getLabel(), goodsReceive.getReceiver().getValue()));
		
			Components.setDefault(companys);
			Components.setDefault(receiveables);
			Components.setDefault(facilitys);
			Components.setDefault(users);
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Date"));
		row1.appendChild(date);
		
		Row row0 = new Row();
		row0.appendChild(new Label("Number"));
		row0.appendChild(number);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Company"));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Reference"));
		row3.appendChild(receiveables);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Facility"));
		row4.appendChild(facilitys);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Receive By"));
		row5.appendChild(users);
		
		rows.appendChild(row1);
		rows.appendChild(row0);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
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
		
		appendChild(items);
		
		GoodsReceive goodsReceive = service.findOne(RowUtils.string(row, 5));
		if(goodsReceive != null)
		{
			for(GoodsReceiveItem item:goodsReceive.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getProduct().getName()));
				row.appendChild(Components.label(item.getQuantity()));
				row.appendChild(new Label(item.getProduct().getUom().getName()));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
		}
	}
}
