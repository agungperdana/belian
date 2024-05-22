
package com.kratonsolution.belian.ui.orders.requirements.work;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class WorkRequirementMenu extends AbstractMenuItem
{
	public WorkRequirementMenu()
	{
		setLabel(lang.get("navbar.menu.orders.requirements.workrequirement"));
		setImage("/icons/workrequirement16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_WORK_REQUIREMENT_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(WorkRequirementWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
