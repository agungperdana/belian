package com.kratonsolution.belian.common.ui;

import org.zkoss.zul.Textbox;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.ui.toolbar.GridToolbar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public abstract class TreeContent extends Vlayout
{	
	private static final long serialVersionUID = 1517060771989123914L;

	protected GridToolbar toolbar = new GridToolbar();
	
	protected Textbox filter = new Textbox();
	
	protected Tree tree = new Tree();
	
	public TreeContent()
	{
		setSpacing("3px");
		setWidth("100%");
		setHeight("100%");
		setStyle("overflow:auto");
		
		filter.setHeight("30px");
	}
	
	protected abstract void initToolbar();
	
	protected abstract void initTree();
}
