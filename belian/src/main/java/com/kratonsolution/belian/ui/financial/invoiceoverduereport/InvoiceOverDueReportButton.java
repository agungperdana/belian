/**
 * 
 */
package com.kratonsolution.belian.ui.financial.invoiceoverduereport;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceOverDueReportButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public InvoiceOverDueReportButton()
	{
		setImage("/icons/invoice-overdue.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.finance.invoiceoverduereport"));
	}
}
