/**
 * 
 */
package com.kratonsolution.belian.ui.finance.reports.payments;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PaymentReportDock extends AbstractDock
{
	public PaymentReportDock()
	{
		setImage("/icons/paymentreport32.png");
		setTooltiptext(lang.get("navbar.menu.finance.reports.payments"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.finance.reports.payments")))
			kernel.open(PaymentReportWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.finance.reports.payments"));
	}
}