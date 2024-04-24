
package com.kratonsolution.belian.ui.security.role;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RoleWindow extends AbstractWindow
{
	public static RoleWindow newInstance(Page page)
	{
		RoleWindow window = new RoleWindow();
		window.init();
		window.setDock(new RoleDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private RoleWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.security.role"));
		caption.setImage("/icons/role32.png");
		appendChild(new RoleGridContent());
	}
}
