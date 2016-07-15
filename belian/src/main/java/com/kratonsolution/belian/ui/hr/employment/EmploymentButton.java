/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public EmploymentButton()
	{
		setImage("/icons/employee.png");
		setTooltiptext(lang.get("navbar.menu.hr.employment"));
		setHeight("38px");
	}
}
