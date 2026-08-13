
package com.kratonsolution.belian.ui.security.user;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserWindow extends AbstractWindow
{
	public static UserWindow newInstance(Page page)
	{
		UserWindow window = new UserWindow();
		window.init();
		window.setDock(new UserDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private UserWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.security.user"));
		caption.setImage("/icons/user32.png");
		appendChild(new UserGridContent());
	}
}
