/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.cashpurchaseorder;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashPurchaseOrderButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public CashPurchaseOrderButton()
	{
		setImage("/icons/cash_purchase_order.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.procurement.cashpurchaseorder"));
	}
}
