/**
 * 
 */
package com.kratonsolution.belian.ui.payment.receipt;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RecurringPaymentButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public RecurringPaymentButton()
	{
		setImage("/icons/recurringpayment.png");
		setTooltiptext(lang.get("navbar.menu.payment.recurringpayment"));
		setHeight("38px");
	}
}
