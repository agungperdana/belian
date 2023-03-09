
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.accounting.currency.CurrencyMenu;
import com.kratonsolution.belian.ui.accounting.tax.TaxMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Accounting extends AbstractMenu
{
	private CurrencyMenu currency = new CurrencyMenu();
	
	private TaxMenu tax = new TaxMenu();
	
	public Accounting()
	{
		setLabel(lang.get("navbar.menu.accounting"));
		setImage("/icons/accounting16.png");
		
		Menupopup popup = new Menupopup();

		if(!currency.isDisabled())
		{
			popup.appendChild(currency);
			popup.appendChild(new Menuseparator());
		}

		if(!tax.isDisabled())
			popup.appendChild(tax);
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}