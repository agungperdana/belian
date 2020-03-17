package com.kratonsolution.belian.common.ui;

import org.zkoss.zul.Foot;
import org.zkoss.zul.Footer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public abstract class GridContent extends Vlayout
{	
	private static final long serialVersionUID = 8061204597422773603L;

	protected GridToolbar toolbar = new GridToolbar();
	
	protected Textbox filter = new Textbox();
	
	protected Grid grid = new Grid();
	
	public GridContent()
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("100%");
		setStyle("overflow:auto");
		
		filter.setHeight("30px");
	}
	
	protected abstract void initToolbar();
	
	protected abstract void initGrid();
	
	protected Foot getFoot(int span)
	{
		Foot foot = new Foot();
		Footer footer = new Footer();
		footer.setSpan(span);
		footer.setHeight("30px");
		foot.appendChild(footer);
		
		return foot;
	}
}
