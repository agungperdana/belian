/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockadjustment;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public StockAdjustmentButton()
	{
		setImage("/icons/stock_adjustment.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.inventory.stockadjustment"));
	}
}
