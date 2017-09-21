/**
 * 
 */
package com.kratonsolution.belian.ui.setting;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class SettingMenu extends AbstractMenuItem
{
	public SettingMenu()
	{
		setLabel(lang.get("navbar.menu.setting"));
		setImage("/icons/setting16.png");
		
		addEventListener(Events.ON_CLICK, this);
	}

	@Override
	public void onEvent(Event arg0) throws Exception
	{
		SettingWindow.newInstance(getPage());
	}
}
