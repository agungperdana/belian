/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.ui.healtcare.doctorappointment.DoctorAppointmentTimer;
import com.kratonsolution.belian.ui.inventory.stockadmin.StockExpiredReminder;
import com.kratonsolution.belian.ui.inventory.stockadmin.StockReminder;
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
		IconBar.injectInto(page);
		NavigationMenu.injectInto(page);
		
		new DoctorAppointmentTimer().setPage(page);
		new StockReminder().setPage(page);
		new StockExpiredReminder().setPage(page);
	}
}