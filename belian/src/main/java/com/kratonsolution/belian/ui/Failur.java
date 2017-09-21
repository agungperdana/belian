/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Clients;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Failur extends GenericRichlet
{

	/* (non-Javadoc)
	 * @see org.zkoss.zk.ui.Richlet#service(org.zkoss.zk.ui.Page)
	 */
	@Override
	public void service(Page page) throws Exception
	{
		Clients.showNotification("Access fail,you dont have permision to access requested page.");
		Executions.sendRedirect("/");
	}
}
