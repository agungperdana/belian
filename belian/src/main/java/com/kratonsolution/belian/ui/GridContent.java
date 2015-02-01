/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Grid;
import org.zkoss.zul.Vlayout;

/**
 * @author agungdodiperdana
 *
 */
public abstract class GridContent extends Vlayout implements Callable
{
	protected final GridToolbar gridToolbar = new GridToolbar();
	
	protected final Grid grid = new Grid();

	public GridContent()
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("100%");
		setStyle("overflow:auto");
	}
	
	protected abstract void initToolbar();
	
	protected abstract void initGrid();
}
