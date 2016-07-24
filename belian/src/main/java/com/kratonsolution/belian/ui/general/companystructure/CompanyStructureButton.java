/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public CompanyStructureButton()
	{
		setImage("/icons/companystructure.png");
		setTooltiptext(lang.get("navbar.menu.general.companystructure"));
		setHeight("38px");
	}
}
