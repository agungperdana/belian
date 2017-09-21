/**
 * 
 */
package com.kratonsolution.belian.ui.healthcares.clinic.visitqueue;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class VisitQueueWindow extends AbstractWindow
{
	public static VisitQueueWindow newInstance(Page page)
	{
		VisitQueueWindow window = new VisitQueueWindow();
		window.init();
		window.setPage(page);
		window.setDock(new VisitQueueDock());
		window.doOverlapped();
		
		return window;
	}
	
	private VisitQueueWindow()
	{
		super();
		setWidth("275px");
		setHeight("500px");
	}
	
	protected void init()
	{
		caption.setImage("/icons/visitqueue32.png");
		caption.setLabel(lang.get("navbar.menu.healthcares.clinic.queue"));
		appendChild(new VisitQueueContent());
	}
}
