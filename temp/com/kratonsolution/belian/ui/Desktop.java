/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;

import com.google.common.base.Strings;
import com.kratonsolution.belian.ui.nav.IconBar;
import com.kratonsolution.belian.ui.nav.NavigationMenu;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Desktop extends GenericRichlet
{
	/* (non-Javadoc)
	 * @see org.zkoss.zk.ui.Richlet#service(org.zkoss.zk.ui.Page)
	 */
	@Override
	public void service(Page page) throws Exception
	{
		page.setTitle("BelianERP - 1.0");
		
		String device = page.getDesktop().getSession().getAttribute("device")!=null?page.getDesktop().getSession().getAttribute("device").toString():"";

		if(!Strings.isNullOrEmpty(device) && !device.equalsIgnoreCase("NORMAL"))
		{
			/**
			 * todo: handle request using mobile or tablet
			 */
		}
		else
		{
			IconBar.injectInto(page);
			NavigationMenu.injectInto(page);
			
//			new DoctorAppointmentTimer().setPage(page);
//			new StockReminder().setPage(page);
//			new StockExpiredReminder().setPage(page);
		}
	}
}