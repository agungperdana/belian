/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Menu extends Listitem
{
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected void showSysadminBlockMessage()
	{
		SessionUtils utils = Springs.get(SessionUtils.class);
		if(utils.isSysAdmin())
		{
			Clients.showNotification("This module cannot be accessed using Sys Admin account.");
			return;
		}
	}
}
