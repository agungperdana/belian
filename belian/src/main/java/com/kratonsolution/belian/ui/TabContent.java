/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;

/**
 * @author agungdodiperdana
 *
 */
public abstract class TabContent
{
	protected Tab header = new Tab();

	protected Tabpanel body = new Tabpanel();

	protected Grid grid = new Grid();
	
	protected GridToolbar toolbar = new GridToolbar();
	
	public TabContent()
	{
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		
		body.appendChild(toolbar);
		body.appendChild(grid);
	}
	
	protected abstract void initGrid();
	
	protected abstract void initToolbar();
	
	public Tab createHeader(String header)
	{
		this.header.setLabel(header);
		return this.header;
	}
	
	public Tabpanel createBody()
	{
		return this.body;
	}
}
