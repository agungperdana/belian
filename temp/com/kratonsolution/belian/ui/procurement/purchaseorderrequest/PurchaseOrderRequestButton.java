/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public PurchaseOrderRequestButton()
	{
		setImage("/icons/purchase_order_request.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.procurement.purchaseorderrequest"));
	}
}
