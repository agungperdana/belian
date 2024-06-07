
package com.kratonsolution.belian.ui.inventorys.stockadjustment;

import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.AbstractWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentWindow extends AbstractWindow
{
	public static StockAdjustmentWindow newInstance(Page page)
	{
		StockAdjustmentWindow window = new StockAdjustmentWindow();
		window.init();
		window.setPage(page);
		window.doOverlapped();
		
		return window;
	}
	
	private StockAdjustmentWindow()
	{
		super();
	}
	
	protected void init()
	{
		caption.setImage("/icons/stockadjustment32.png");
		caption.setLabel(lang.get("navbar.menu.inventory.stockadjustment"));
		appendChild(new StockAdjustmentGridContent());
	}	
}
