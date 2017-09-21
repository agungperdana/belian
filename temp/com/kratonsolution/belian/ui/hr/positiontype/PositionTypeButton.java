/**
 * 
 */
package com.kratonsolution.belian.ui.hr.positiontype;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionTypeButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public PositionTypeButton()
	{
		setImage("/icons/positiontype.png");
		setTooltiptext(lang.get("navbar.menu.hr.positiontype"));
		setHeight("38px");
	}
}
