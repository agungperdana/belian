/**
 * 
 */
package com.kratonsolution.belian.ui.hr.positiontyperate;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionTypeRateButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public PositionTypeRateButton()
	{
		setImage("/icons/positiontyperate.png");
		setTooltiptext(lang.get("navbar.menu.hr.positiontyperate"));
		setHeight("38px");
	}
}
