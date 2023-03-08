/**
 * 
 */
package com.kratonsolution.belian.ui.finance.payments;

import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.finance.payments.disbursement.DisbursementMenu;
import com.kratonsolution.belian.ui.finance.payments.receipt.ReceiptMenu;
import com.kratonsolution.belian.ui.nav.AbstractMenu;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PaymentsMenu extends AbstractMenu
{
	private ReceiptMenu receipt = new ReceiptMenu();
	
	private DisbursementMenu disbursementMenu = new DisbursementMenu();
	
	public PaymentsMenu()
	{
		setLabel(lang.get("navbar.menu.finance.payments"));
		setImage("/icons/payments.png");
		
		if(!receipt.isDisabled())
		{
			popup.appendChild(receipt);
			popup.appendChild(new Menuseparator());
		}
		
		if(!disbursementMenu.isDisabled())
			popup.appendChild(disbursementMenu);
			
		appendChild(popup);
	}
}
