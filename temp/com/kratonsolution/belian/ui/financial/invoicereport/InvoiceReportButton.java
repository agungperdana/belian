/**
 * 
 */
package com.kratonsolution.belian.ui.financial.invoicereport;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceReportButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public InvoiceReportButton()
	{
		setImage("/icons/invoice-report.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.finance.invoicereport"));
	}
}
