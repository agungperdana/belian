
package com.kratonsolution.belian.ui.finance.payments.disbursement;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class DisbursementMenu extends AbstractMenuItem
{
	public DisbursementMenu()
	{
		setLabel(lang.get("navbar.menu.finance.payments.disbursement"));
		setImage("/icons/disbursement16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_DISBURSEMENT_READ"));
	
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(DisbursementWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
