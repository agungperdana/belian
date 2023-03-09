
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.orders.cashpurchaseorder.CashPOMenu;
import com.kratonsolution.belian.ui.orders.purchaseorder.POMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseMenu extends AbstractMenu
{
	private CashPOMenu cash = new CashPOMenu();
	
	private POMenu po = new POMenu();
	
	public PurchaseMenu()
	{
		setLabel(lang.get("navbar.menu.orders.purchase"));
		setImage("/icons/procurement16.png");
		
		if(!cash.isDisabled())
		{
			popup.appendChild(cash);
			popup.appendChild(new Menuseparator());
		}
		
		if(!po.isDisabled())
			popup.appendChild(po);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
