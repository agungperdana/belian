package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zul.Space;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Fisheyes extends Toolbar
{
	private static final long serialVersionUID = 1L;
	
	private Toolbarbutton moduleRegistry = new Toolbarbutton();

	public Fisheyes()
	{
		setWidth("50%");
		setHeight("50px");
		setStyle("border:solid silver 1px;padding-left:2px;padding-right:2px;");
		
		moduleRegistry.setImage("/images/module-launcher.png");;
		
		appendChild(moduleRegistry);
		appendChild(InsertSpace(true));
	}
	
	public Space InsertSpace(boolean isBar) {
		
		Space sep = new Space();
		sep.setBar(isBar);
		
		return sep;
	}
}
