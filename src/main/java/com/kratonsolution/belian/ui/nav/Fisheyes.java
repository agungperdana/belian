/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Space;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.tools.view.Dock;
import com.kratonsolution.belian.tools.view.Docks;
import com.kratonsolution.belian.ui.tools.notification.NotificationDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Fisheyes extends Toolbar implements Docks
{
	public Fisheyes()
	{
		setWidth("60%");
		setHeight("40px");
		setStyle("border:solid silver 1px;padding-left:2px;padding-right:2px;");

		Space sep = new Space();
		sep.setBar(true);
		
		appendChild(new NotificationDock());
		appendChild(sep);
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
