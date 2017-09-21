/**
 * 
 */
package com.kratonsolution.belian.ui.general.organization;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationWindow extends AbstractWindow
{
	public static OrganizationWindow newInstance(Page page)
	{
		OrganizationWindow window = new OrganizationWindow();
		window.init();
		window.setDock(new OrganizationDock());
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private OrganizationWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.general.organization"));
		caption.setImage("/icons/organization32.png");
		appendChild(new OrganizationGridContent());
	}	
}
