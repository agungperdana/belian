/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PatientButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public PatientButton()
	{
		setImage("/icons/patient.png");
		setTooltiptext(lang.get("navbar.menu.healtcare.patient"));
		setHeight("38px");
	}
}
