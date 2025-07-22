
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.orders.requirements.product.ProductRequirementMenu;
import com.kratonsolution.belian.ui.orders.requirements.work.WorkRequirementMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequirementsMenu extends AbstractMenu
{
	private ProductRequirementMenu product = new ProductRequirementMenu();
	
	private WorkRequirementMenu work = new WorkRequirementMenu();
	
	public RequirementsMenu()
	{
		setLabel(lang.get("navbar.menu.orders.requirements"));
		setImage("/icons/requirements16.png");

		if(!product.isDisabled())
		{
			popup.appendChild(product);
			popup.appendChild(new Menuseparator());
		}
		
		if(!work.isDisabled())
			popup.appendChild(work);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
