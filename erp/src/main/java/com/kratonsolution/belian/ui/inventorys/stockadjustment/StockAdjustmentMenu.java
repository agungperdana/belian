
package com.kratonsolution.belian.ui.inventorys.stockadjustment;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class StockAdjustmentMenu extends AbstractMenuItem
{
	public StockAdjustmentMenu()
	{
		setLabel(lang.get("navbar.menu.inventory.stockadjustment"));
		setImage("/icons/stockadjustment16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_STOCK_ADJUSTMENT_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		StockAdjustmentWindow.newInstance(getPage());
	}
}
