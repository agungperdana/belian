/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.currency;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CurrencyButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public CurrencyButton()
	{
		setImage("/icons/currency.png");
		setTooltiptext(lang.get("navbar.menu.accounting.currency"));
		setHeight("38px");
	}
}
