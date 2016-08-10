/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.simplepharmacyinvoice;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SimplePharmacyInvoiceButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public SimplePharmacyInvoiceButton()
	{
		setImage("/icons/simple-pharmacy-invoice.png");
		setTooltiptext(lang.get("navbar.menu.healtcare.simplepharmacyinvoice"));
		setHeight("38px");
	}
}
