/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Grid;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class GridContent extends Vlayout
{
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
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
