/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

/**
 * @author agungdodiperdana
 *
 */
public abstract class FormContent extends Vlayout implements Callable
{
	protected FormToolbar toolbar = new FormToolbar();
	
	protected Grid grid = new Grid();
	
	protected Rows rows = new Rows();
	
	public FormContent()
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("97%");
		setStyle("overflow:auto");
		
		grid.appendChild(rows);
		
		appendChild(toolbar);
		appendChild(grid);
	}
	
	public abstract void initToolbar();
	
	public abstract void initForm();
}
