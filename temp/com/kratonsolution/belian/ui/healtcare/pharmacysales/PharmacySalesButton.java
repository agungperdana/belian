/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.pharmacysales;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacySalesButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public PharmacySalesButton()
	{
		setImage("/icons/apotek.png");
		setTooltiptext(lang.get("navbar.menu.healtcare.apotek"));
		setHeight("38px");
	}
}
