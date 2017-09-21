/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacyorder;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacyOrderButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public PharmacyOrderButton()
	{
		setImage("/icons/pharmacyorder.png");
		setTooltiptext(lang.get("navbar.menu.healtcare.apotekorder"));
		setHeight("38px");
	}
}
