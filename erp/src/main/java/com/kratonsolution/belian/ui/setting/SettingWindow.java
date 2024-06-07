package com.kratonsolution.belian.ui.setting;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public class SettingWindow extends AbstractWindow
{
	public static SettingWindow newInstance(Page page)
	{
		SettingWindow window = new SettingWindow();
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private SettingWindow()
	{
		super();
		
		caption.setLabel(lang.get("navbar.menu.setting"));
		caption.setImage("/icons/setting32.png");
		appendChild(new SettingForm());
	}
}
