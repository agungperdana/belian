/**
 * 
 */
package com.kratonsolution.belian.ui.hr.benefittype;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BenefitTypeButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public BenefitTypeButton()
	{
		setImage("/icons/benefittype.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.hr.benefittype"));
	}
}
