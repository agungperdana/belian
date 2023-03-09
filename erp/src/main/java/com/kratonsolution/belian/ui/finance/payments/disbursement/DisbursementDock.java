
package com.kratonsolution.belian.ui.finance.payments.disbursement;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractDock;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DisbursementDock extends AbstractDock
{
	public DisbursementDock()
	{
		setImage("/icons/disbursement32.png");
		setTooltiptext(lang.get("navbar.menu.finance.payments.disbursement"));
		addEventListener(Events.ON_CLICK, this);
		addEventListener(Events.ON_CHECK, this);
	}
	
	@Override
	public void onEvent(Event event) throws Exception
	{
		if(!kernel.isExist(lang.get("navbar.menu.finance.payments.disbursement")))
			kernel.open(DisbursementWindow.newInstance(getPage()));
		else
			kernel.open(lang.get("navbar.menu.finance.payments.disbursement"));
	}
}