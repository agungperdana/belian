/**
 * 
 */
package com.kratonsolution.belian.ui.workefforts.workeffort;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortWindow extends AbstractWindow
{
	public static WorkEffortWindow newInstance(Page page)
	{
		WorkEffortWindow window = new WorkEffortWindow();
		window.init();
		window.setPage(page);
		window.setDock(new WorkEffortDock());
		window.doOverlapped();
		
		return window;
	}
	
	private WorkEffortWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/workefforts32.png");
		caption.setLabel(lang.get("navbar.menu.hr.workefforts.workeffort"));
		appendChild(new WorkEffortGridContent());
	}	
}
