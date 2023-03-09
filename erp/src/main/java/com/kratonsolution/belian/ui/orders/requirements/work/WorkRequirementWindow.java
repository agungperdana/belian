
package com.kratonsolution.belian.ui.orders.requirements.work;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkRequirementWindow extends AbstractWindow
{
	public static WorkRequirementWindow newInstance(Page page)
	{
		WorkRequirementWindow window = new WorkRequirementWindow();
		window.init();
		window.setPage(page);
		window.setDock(new WorkRequirementDock());
		window.doOverlapped();
		
		return window;
	}
	
	private WorkRequirementWindow()
	{
		super();
		setHeight("85%");
	}
	
	protected void init()
	{
		caption.setImage("/icons/workrequirement32.png");
		caption.setLabel(lang.get("navbar.menu.orders.requirements.workrequirement"));
		appendChild(new WorkRequirementGridContent());
	}	
}
