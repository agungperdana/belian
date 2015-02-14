/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.nav.NavigationMenu;
import com.kratonsolution.belian.ui.nav.NavigatorBar;

/**
 * @author agungdodiperdana
 *
 */
public class Desktop extends GenericRichlet
{
	/* (non-Javadoc)
	 * @see org.zkoss.zk.ui.Richlet#service(org.zkoss.zk.ui.Page)
	 */
	@Override
	public void service(Page page) throws Exception
	{
		NavigatorBar.injectInto(page);
		NavigationMenu.injectInto(page);
	}
}