/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctortype;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorTypeButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public DoctorTypeButton()
	{
		setImage("/icons/doctortype.png");
		setTooltiptext(lang.get("navbar.menu.healtcare.doctortype"));
		setHeight("38px");
	}
}
