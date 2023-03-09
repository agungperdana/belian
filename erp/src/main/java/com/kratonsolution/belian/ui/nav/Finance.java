
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.finance.invoices.InvoicesMenu;
import com.kratonsolution.belian.ui.finance.payments.PaymentsMenu;
import com.kratonsolution.belian.ui.finance.reports.FinancialReportsMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Finance extends AbstractMenu
{
	private InvoicesMenu invoicesMenu = new InvoicesMenu();
	
	private PaymentsMenu paymentsMenu = new PaymentsMenu();
	
	private FinancialReportsMenu reportsMenu = new FinancialReportsMenu();
	
	public Finance()
	{
		setLabel(lang.get("navbar.menu.finance"));
		setImage("/icons/finance16.png");
		
		if(!invoicesMenu.isDisabled())
		{
			popup.appendChild(invoicesMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!paymentsMenu.isDisabled())
		{
			popup.appendChild(paymentsMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!reportsMenu.isDisabled())
			popup.appendChild(reportsMenu);
			
		appendChild(popup);
	}
}
