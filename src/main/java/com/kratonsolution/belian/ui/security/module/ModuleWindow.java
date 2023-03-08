/**
 * 
 */
package com.kratonsolution.belian.ui.security.module;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ModuleWindow extends AbstractWindow
{
	public static ModuleWindow newInstance(Page page)
	{
		ModuleWindow window = new ModuleWindow();
		window.init();
		window.setDock(new ModuleDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private ModuleWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.security.module"));
		caption.setImage("/icons/module32.png");

		appendChild(new ModuleGridContent());
	}
}
