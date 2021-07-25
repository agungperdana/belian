package com.kratonsolution.belian.common.ui;

import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.ui.toolbar.FormToolbar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public abstract class AbstractForm extends Vlayout
{	
	private static final long serialVersionUID = 6792154391996798798L;

	protected FormToolbar toolbar = new FormToolbar();
	
	protected Grid grid = new Grid();
	
	protected Rows rows = new Rows();
	
	public AbstractForm()
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("97%");
		setStyle("overflow:auto");
		
		grid.setWidth("100%");
		grid.appendChild(rows);
		
		appendChild(toolbar);
		appendChild(grid);
	}
	
	public abstract void initToolbar();
	
	public abstract void initForm();
}
