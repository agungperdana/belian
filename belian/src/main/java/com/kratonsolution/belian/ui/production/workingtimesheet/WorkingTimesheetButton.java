/**
 * 
 */
package com.kratonsolution.belian.ui.production.workingtimesheet;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkingTimesheetButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public WorkingTimesheetButton()
	{
		setImage("/icons/timesheet.png");
		setTooltiptext(lang.get("navbar.menu.production.workingtimesheet"));
		setHeight("38px");
	}
}
