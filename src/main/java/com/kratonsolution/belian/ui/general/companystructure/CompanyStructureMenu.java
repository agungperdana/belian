/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class CompanyStructureMenu extends AbstractMenuItem
{	
	public CompanyStructureMenu()
	{
		setLabel(lang.get("navbar.menu.general.companystructure"));
		setImage("/icons/companystructure16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_COMPANY_STRUCTURE_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(CompanyStructureWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
