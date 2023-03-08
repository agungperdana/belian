/**
 * 
 */
package com.kratonsolution.belian.ui.finance.reports.payments;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PaymentReportMenu extends AbstractMenuItem
{
	public PaymentReportMenu()
	{
		setLabel(lang.get("navbar.menu.finance.reports.payments"));
		setImage("/icons/paymentreport16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_RECEIPT_REPORT_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(PaymentReportWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
