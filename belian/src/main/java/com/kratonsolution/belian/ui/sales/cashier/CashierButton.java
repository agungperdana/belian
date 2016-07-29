/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public CashierButton()
	{
		setImage("/icons/cashier.png");
		setTooltiptext(lang.get("navbar.menu.sales.cashier"));
		setHeight("38px");
	}
}
