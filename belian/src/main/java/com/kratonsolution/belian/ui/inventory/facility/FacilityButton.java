/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FacilityButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public FacilityButton()
	{
		setImage("/icons/facility.png");
		setTooltiptext(lang.get("navbar.menu.inventory.facility"));
		setHeight("38px");
	}
}
