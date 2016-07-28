/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.organizationaccount;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationAccountButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public OrganizationAccountButton()
	{
		setImage("/icons/orgacc.png");
		setTooltiptext(lang.get("navbar.menu.accounting.ogl"));
		setHeight("38px");
	}
}
