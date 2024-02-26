/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import com.kratonsolution.belian.ui.healtcares.pharmacy.pos.PharmacyPOSMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Pharmacy extends AbstractMenu
{
	private PharmacyPOSMenu pos = new PharmacyPOSMenu();
	
	public Pharmacy()
	{
		setLabel(lang.get("navbar.menu.healthcares.pharmacy"));
		setImage("/icons/pharmacy.png");
		
		if(!pos.isDisabled())
			popup.appendChild(pos);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
