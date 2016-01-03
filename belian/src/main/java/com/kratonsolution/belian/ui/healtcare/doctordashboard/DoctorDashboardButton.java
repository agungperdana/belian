/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorDashboardButton extends Toolbarbutton
{
	private Language language = Springs.get(Language.class);
	
	public DoctorDashboardButton()
	{
		setImage("/icons/doctordashboard.png");
		setHeight("38px");
	}
}
