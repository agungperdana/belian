/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menuseparator;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrdersMenu extends AbstractMenu
{
	private RequirementsMenu requirementsMenu = new RequirementsMenu();
	
	private SalesMenu sales = new SalesMenu();
	
	private PurchaseMenu purchaseMenu = new PurchaseMenu();
	
	private WorkEffortsMenu workEffortMenu = new WorkEffortsMenu();
	
	public OrdersMenu()
	{
		setLabel(lang.get("navbar.menu.orders"));
		setImage("/icons/orders16.png");

		if(!requirementsMenu.isDisabled())
		{
			popup.appendChild(requirementsMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!sales.isDisabled())
		{
			popup.appendChild(sales);
			popup.appendChild(new Menuseparator());
		}

		if(!purchaseMenu.isDisabled())
		{
			popup.appendChild(purchaseMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!workEffortMenu.isDisabled())
		{
			popup.appendChild(workEffortMenu);
		}
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
