
package com.kratonsolution.belian.ui.finance.payments.receipt;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ReceiptMenu extends AbstractMenuItem
{
	public ReceiptMenu()
	{
		setLabel(lang.get("navbar.menu.finance.payments.receipt"));
		setImage("/icons/receipt16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_RECEIPT_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(ReceiptWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
