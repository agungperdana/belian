/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.ui.util.Components;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CheckingResult extends Vlayout
{
	private Toolbar toolbar = new Toolbar();
	
	private Grid grid = new Grid();
	
	private Datebox datebox = Components.currentDatebox();
	
	private Textbox anamnesis = new Textbox();
	
	private Textbox checkingResult = new Textbox();
	
	private Textbox diagnosis = new Textbox();
	
	public CheckingResult()
	{
		setWidth("100%");
		appendChild(toolbar);
		appendChild(grid);
	
		initToolbar();
		initGrid();
	}
	
	private void initToolbar()
	{
		
	}
	
	private void initGrid()
	{
		grid.setWidth("100%");
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null, "125px"));
		grid.getColumns().appendChild(new Column());
	}
}
