/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.coa;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class COAButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public COAButton()
	{
		setImage("/icons/coa.png");
		setTooltiptext(lang.get("navbar.menu.accounting.coa"));
		setHeight("38px");
	}
}
