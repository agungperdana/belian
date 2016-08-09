/**
 * 
 */
package com.kratonsolution.belian.ui.hr.application;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentApplicationButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public EmploymentApplicationButton()
	{
		setImage("/icons/employment_application.png");
		setTooltiptext(lang.get("navbar.menu.hr.application"));
		setHeight("38px");
	}
}
