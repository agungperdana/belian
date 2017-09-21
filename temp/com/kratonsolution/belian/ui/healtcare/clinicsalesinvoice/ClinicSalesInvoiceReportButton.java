/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.clinicsalesinvoice;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicSalesInvoiceReportButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public ClinicSalesInvoiceReportButton()
	{
		setImage("/icons/clinic-sales-invoice-report.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.healtcare.salesinvoice"));
	}
}
