/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.MedicationProductBox;
import com.kratonsolution.belian.ui.util.Components;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicationPanel extends Tabpanel
{
	private Grid grid = new Grid();
	
	private NRCToolbar toolbar = new NRCToolbar(grid);
	
	public MedicationPanel()
	{
		appendChild(toolbar);
		appendChild(grid);
		
		initToolbar();
		initGrid();
	}
	
	private void initToolbar()
	{
		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(new Checkbox());
				row.appendChild(new MedicationProductBox(row));
				row.appendChild(Components.doubleBox(1l));
				row.appendChild(Components.textBox(""));
				
				grid.getRows().appendChild(row);
			}
		});
	
		Toolbarbutton save = new Toolbarbutton("Save","/icons/save.png");
		save.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});
		
		toolbar.appendChild(save);
	}
	
	private void initGrid()
	{
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column("Medicine",null,"300px"));
		grid.getColumns().appendChild(new Column("Quantity",null,"75px"));
		grid.getColumns().appendChild(new Column("Note",null,null));
		grid.getColumns().appendChild(new Column(null,null,"0px"));
	}
}
