
package com.kratonsolution.belian.ui.finance.reports;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.finance.reports.disbursement.DisbursementReportMenu;
import com.kratonsolution.belian.ui.finance.reports.payments.PaymentReportMenu;
import com.kratonsolution.belian.ui.finance.reports.receipt.ReceiptReportMenu;
import com.kratonsolution.belian.ui.finance.reports.salesinvoice.SalesInvoiceReportMenu;
import com.kratonsolution.belian.ui.nav.AbstractMenu;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class FinancialReportsMenu extends AbstractMenu
{
	private SalesInvoiceReportMenu salesInvoiceReportMenu = new SalesInvoiceReportMenu();
	
	private ReceiptReportMenu receipt = new ReceiptReportMenu();
	
	private DisbursementReportMenu disbursementMenu = new DisbursementReportMenu();
	
	private PaymentReportMenu paymentsMenu = new PaymentReportMenu();
	
	public FinancialReportsMenu()
	{
		setLabel(lang.get("navbar.menu.finance.reports"));
		setImage("/icons/financialreports16.png");
		
		if(!salesInvoiceReportMenu.isDisabled())
		{
			popup.appendChild(salesInvoiceReportMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!receipt.isDisabled())
		{
			popup.appendChild(receipt);
			popup.appendChild(new Menuseparator());
		}
			
		if(!disbursementMenu.isDisabled())
		{
			popup.appendChild(disbursementMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!paymentsMenu.isDisabled())
			popup.appendChild(paymentsMenu);
		
		appendChild(popup);
	}
}
