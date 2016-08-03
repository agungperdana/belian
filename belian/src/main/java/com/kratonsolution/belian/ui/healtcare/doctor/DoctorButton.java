/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public DoctorButton()
	{
		setImage("/icons/doctor.png");
		setTooltiptext(lang.get("navbar.menu.healtcare.doctor"));
		setHeight("38px");
	}
}
