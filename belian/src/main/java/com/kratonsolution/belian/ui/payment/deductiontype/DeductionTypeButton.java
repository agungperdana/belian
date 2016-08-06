/**
 * 
 */
package com.kratonsolution.belian.ui.payment.deductiontype;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DeductionTypeButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public DeductionTypeButton()
	{
		setTooltiptext(lang.get("navbar.menu.payment.deductiontype"));
		setImage("/icons/deductiontype.png");
		setHeight("38px");
	}
}
