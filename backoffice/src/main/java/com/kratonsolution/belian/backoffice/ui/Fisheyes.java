package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zul.Space;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Fisheyes extends Toolbar implements Docks
{
	private static final long serialVersionUID = 1L;

	public Fisheyes()
	{
		setWidth("60%");
		setHeight("40px");
		setStyle("border:solid silver 1px;padding-left:2px;padding-right:2px;");

		Space sep = new Space();
		sep.setBar(true);
	}

	@Override
	public void register(Dock dock)
	{
		if(!contain(dock))
		{
			appendChild((Toolbarbutton)dock);
		}
	}

	@Override
	public void unregister(Dock dock)
	{
		if(contain(dock))
			removeChild((Toolbarbutton)dock);
	}

	@Override
	public boolean contain(Dock dock)
	{
		return this.getChildren().contains((Toolbarbutton)dock);
	}
}
