
package com.kratonsolution.belian.ui.component;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.api.dm.IDValueRef;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GridLayout extends Vlayout
{
	private Grid grid = new Grid();
	
	public GridLayout(int column)
	{
		grid.setHflex("1");
		grid.setVflex("1");
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());

		int colsize = column;
		if(colsize <= 0)
			colsize = 5;
		
		for(int idx=0;idx<colsize;idx++)
			grid.getColumns().appendChild(new Column());
		
		appendChild(grid);
	}
	
	public void add(Component child)
	{
		if(child != null)
		{
			boolean added = false;
			
			for(Component com:grid.getRows().getChildren())
			{
				Row row = (Row)com;
				if(row.getChildren().size() < 5)
				{
					row.appendChild(child);
					added = true;
				}
			}
			
			if(!added)
			{
				Row row = new Row();
				row.appendChild(child);
				grid.getRows().appendChild(row);
			}
		}
	}
	
	public List<IDValueRef> getSelectedModel()
	{
		List<IDValueRef> models = new ArrayList<>();
		
		for(Component com:grid.getRows().getChildren())
		{
			for(Component cell:com.getChildren())
			{
				ToggleButton but = (ToggleButton)cell.getFirstChild();
				if(but.isSelected())
					models.add(but.getModel());
			}
		}
			
		return models;
	}
	
	public List<String> getSelectedModelIds()
	{
		List<String> models = new ArrayList<>();
		
		for(Component com:grid.getRows().getChildren())
		{
			for(Component cell:com.getChildren())
			{
				ToggleButton but = (ToggleButton)cell;
				if(but.isSelected())
					models.add(but.getModel().getId());
			}
		}
			
		return models;
	}
}
