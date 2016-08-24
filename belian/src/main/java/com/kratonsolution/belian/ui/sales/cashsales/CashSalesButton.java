/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashsales;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashSalesButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public CashSalesButton()
	{
		setImage("/icons/cashsales.png");
		setTooltiptext(lang.get("navbar.menu.sales.cashsales"));
		setHeight("38px");
	}
}
