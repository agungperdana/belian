/**
 * 
 */
package com.kratonsolution.belian.ui.general.organization;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public OrganizationButton()
	{
		setImage("/icons/organization.png");
		setTooltiptext(lang.get("navbar.menu.general.organization"));
		setHeight("38px");
	}
}
