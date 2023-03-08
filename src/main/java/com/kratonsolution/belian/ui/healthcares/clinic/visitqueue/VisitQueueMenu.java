/**
 * 
 */
package com.kratonsolution.belian.ui.healthcares.clinic.visitqueue;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class VisitQueueMenu extends AbstractMenuItem
{
	public VisitQueueMenu()
	{
		setLabel(lang.get("navbar.menu.healthcares.clinic.queue"));
		setImage("/icons/visitqueue16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_VISIT_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(VisitQueueWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
