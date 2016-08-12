/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.supplier;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SupplierButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public SupplierButton()
	{
		setImage("/icons/supplier.png");
		setTooltiptext(lang.get("navbar.menu.procurement.supplier"));
		setHeight("38px");
	}
}
