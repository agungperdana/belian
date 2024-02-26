/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class EmploymentMenu extends AbstractMenuItem
{
	public EmploymentMenu()
	{
		setLabel(lang.get("navbar.menu.hr.employment"));
		setImage("/icons/employment16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_EMPLOYMENT_READ"));
		
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(EmploymentWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
