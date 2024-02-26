/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menupopup;

import com.kratonsolution.belian.ui.workefforts.workeffort.WorkEffortMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortsMenu extends AbstractMenu
{
	private Menupopup popup = new Menupopup();
			
	private WorkEffortMenu workEffortMenu = new WorkEffortMenu();
	
	public WorkEffortsMenu()
	{
		setLabel(lang.get("navbar.menu.hr.workefforts"));
		setImage("/icons/workeffort16.png");
		
		if(!workEffortMenu.isDisabled())
		{
			popup.appendChild(workEffortMenu);
		}
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
	
	@Override
	public boolean isDisabled()
	{
		return popup.getChildren().isEmpty();
	}
}
