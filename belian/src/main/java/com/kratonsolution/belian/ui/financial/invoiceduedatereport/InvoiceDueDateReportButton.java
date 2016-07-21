/**
 * 
 */
package com.kratonsolution.belian.ui.financial.invoiceduedatereport;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceDueDateReportButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public InvoiceDueDateReportButton()
	{
		setImage("/icons/invoice-duedate.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.finance.invoiceduedatereport"));
	}
}
