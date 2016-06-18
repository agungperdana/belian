/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.svc.CodeGenerator;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class FormContent extends Vlayout implements Removeable
{
	protected FormToolbar toolbar = new FormToolbar();
	
	protected Grid grid = new Grid();
	
	protected Rows rows = new Rows();
	
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected CodeGenerator generator = Springs.get(CodeGenerator.class);
	
	public FormContent()
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
