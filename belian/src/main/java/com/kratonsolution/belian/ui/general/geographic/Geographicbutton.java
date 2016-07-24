/**
 * 
 */
package com.kratonsolution.belian.ui.general.geographic;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Geographicbutton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public Geographicbutton()
	{
		setImage("/icons/geographic.png");
		setTooltiptext(lang.get("navbar.menu.general.geographic"));
		setHeight("38px");
	}
}
