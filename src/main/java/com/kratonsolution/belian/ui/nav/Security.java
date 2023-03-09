
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.security.module.ModuleMenu;
import com.kratonsolution.belian.ui.security.role.RoleMenu;
import com.kratonsolution.belian.ui.security.user.UserMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Security extends AbstractMenu
{
	private ModuleMenu module = new ModuleMenu();
	
	private RoleMenu role = new RoleMenu();
	
	private UserMenu user = new UserMenu();
	
	public Security()
	{
		setLabel(lang.get("navbar.menu.security"));
		setImage("/icons/security16.png");
		
		Menupopup popup = new Menupopup();
		
		if(!module.isDisabled())
		{
			popup.appendChild(module);
			popup.appendChild(new Menuseparator());
		}
		
		if(!role.isDisabled())
		{
			popup.appendChild(role);
			popup.appendChild(new Menuseparator());
		}
		
		if(!user.isDisabled())
			popup.appendChild(user);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
