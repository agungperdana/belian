
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menupopup;

import com.kratonsolution.belian.ui.hr.employment.EmploymentMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class HR extends AbstractMenu
{
	private EmploymentMenu employment = new EmploymentMenu();
	
	public HR()
	{
		setLabel(lang.get("navbar.menu.hr"));
		setImage("/icons/hr16.png");
		
		Menupopup popup = new Menupopup();

		if(!employment.isDisabled())
		{
			popup.appendChild(employment);
		}
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
