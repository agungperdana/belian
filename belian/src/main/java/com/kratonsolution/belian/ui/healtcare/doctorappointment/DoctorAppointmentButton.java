/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorappointment;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorAppointmentButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public DoctorAppointmentButton()
	{
		setImage("/icons/doctorappointment.png");
		setTooltiptext(lang.get("navbar.menu.healtcare.appointment"));
		setHeight("38px");
	}
}
