/**
 * 
 */
package com.kratonsolution.belian.ui.healthcares.clinic.visit;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class VisitWindow extends AbstractWindow
{
	public static VisitWindow newInstance(Page page)
	{
		VisitWindow window = new VisitWindow();
		window.init();
		window.setPage(page);
		window.setDock(new VisitDock());
		window.doOverlapped();
		
		return window;
	}
	
	private VisitWindow()
	{
		super();
		setHeight("80%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/visit32.png");
		caption.setLabel(lang.get("navbar.menu.healthcares.clinic.visit"));
		appendChild(new VisitGridContent());
	}	
}
