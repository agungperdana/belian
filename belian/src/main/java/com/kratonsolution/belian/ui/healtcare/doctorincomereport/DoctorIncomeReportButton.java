/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctorincomereport;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorIncomeReportButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public DoctorIncomeReportButton()
	{
		setImage("/icons/profitloss.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.healtcare.doctorincomereport"));
	}
}
