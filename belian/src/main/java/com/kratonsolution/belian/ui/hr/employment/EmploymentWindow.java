/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentWindow extends AbstractWindow
{
	public static EmploymentWindow newInstance(Page page)
	{
		EmploymentWindow window = new EmploymentWindow();
		window.setPage(page);
		window.init();
		window.doOverlapped();
		window.setDock(new EmploymentDock());
		
		return window;
	}
	
	private EmploymentWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setLabel(lang.get("navbar.menu.hr.employment"));
		caption.setImage("/icons/employment32.png");
		appendChild(new EmploymentGridContent());
	}
}
