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
 * @since 0.0.1
 * @version 1.0.0
 */
public class FishEyes extends Toolbar implements Docks {
	public FishEyes()
	{
		setHflex("1");
		setHeight("45px");
		setStyle("border:solid silver 1px;padding-left:2px;padding-right:2px;");
		setAlign("center");

		Space sep = new Space();
		sep.setBar(true);
		sep.setVflex("1");
		
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
	public void remove(Dock dock)
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