/**
 * 
 */
package com.kratonsolution.belian.ui.payment.recurringpayment;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public ReceiptButton()
	{
		setImage("/icons/receipt.png");
		setTooltiptext(lang.get("navbar.menu.payment.receipt"));
		setHeight("38px");
	}
}
