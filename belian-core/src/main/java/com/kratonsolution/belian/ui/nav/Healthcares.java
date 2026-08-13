
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menuseparator;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Healthcares extends AbstractMenu
{
	private Pharmacy pharmacy = new Pharmacy();
	
	private Clinic clinic = new Clinic();
	
	public Healthcares()
	{
		setLabel(lang.get("navbar.menu.healthcares"));
		setImage("/icons/healthcares.png");

		if(!pharmacy.isDisabled())
		{
			popup.appendChild(pharmacy);
			popup.appendChild(new Menuseparator());
		}

		if(!clinic.isDisabled())
			popup.appendChild(clinic);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
