/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.budget;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Budgetbutton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public Budgetbutton()
	{
		setImage("/icons/budget.png");
		setTooltiptext(lang.get("navbar.menu.accounting.budget"));
		setHeight("38px");
	}
}
