/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.tax;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class TaxMenu extends AbstractMenuItem
{
	public TaxMenu()
	{
		setLabel(lang.get("navbar.menu.accounting.tax"));
		setImage("/icons/tax16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_TAX_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		TaxWindow.newInstance(getPage());
	}
}
