
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.orders.pos.POSMenu;
import com.kratonsolution.belian.ui.orders.salesorder.SalesOrderMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SalesMenu extends AbstractMenu
{
	private POSMenu posMenu = new POSMenu();
	
	private SalesOrderMenu salesOrder = new SalesOrderMenu();
	
	public SalesMenu()
	{
		setLabel(lang.get("navbar.menu.orders.sales"));
		setImage("/icons/sales16.png");
		
		if(!posMenu.isDisabled())
		{
			popup.appendChild(posMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!salesOrder.isDisabled())
			popup.appendChild(salesOrder);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
