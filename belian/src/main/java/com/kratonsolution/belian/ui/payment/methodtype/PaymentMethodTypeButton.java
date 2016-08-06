/**
 * 
 */
package com.kratonsolution.belian.ui.payment.methodtype;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PaymentMethodTypeButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public PaymentMethodTypeButton()
	{
		setImage("/icons/payment_method_type.png");
		setTooltiptext(lang.get("navbar.menu.payment.methodtype"));
		setHeight("38px");
	}
}
