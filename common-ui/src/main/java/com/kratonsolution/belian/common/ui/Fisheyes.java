package com.kratonsolution.belian.common.ui;

import org.zkoss.zul.Space;
import org.zkoss.zul.Toolbar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Fisheyes extends Toolbar
{
	private static final long serialVersionUID = 1L;

	public Fisheyes()
	{
		setWidth("50%");
		setHeight("50px");
		setStyle("border:solid silver 1px;padding-left:2px;padding-right:2px;");
	}
	
	public void insertSpace(boolean isBar) {
		
		Space sep = new Space();
		sep.setBar(isBar);
		
		appendChild(sep);
	}
}
