/**
 * 
 */
package com.kratonsolution.belian.ui.workefforts.workeffort;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class WorkEffortMenu extends AbstractMenuItem
{
	public WorkEffortMenu()
	{
		setLabel(lang.get("navbar.menu.hr.workefforts.workeffort"));
		setImage("/icons/workefforts16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_WORK_EFFORT_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(WorkEffortWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
