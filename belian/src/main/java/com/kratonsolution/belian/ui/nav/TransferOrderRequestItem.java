/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.inventory.transferrequest.TransferOrderRequestWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TransferOrderRequestItem extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public TransferOrderRequestItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.inventory.transferrequest"));
		setImage("/icons/transfer_request.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				SessionUtils utils = Springs.get(SessionUtils.class);
				if(utils.isSysAdmin())
				{
					Clients.showNotification("This module cannot be accessed using Sys Admin account.");
					return;
				}
				
				TransferOrderRequestWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof TransferOrderRequestWindow)
						window = (TransferOrderRequestWindow)component;
				}
				
				if(window == null)
					window = TransferOrderRequestWindow.injectInto(getPage());
				
				else if(!window.isVisible())
				{
					window.setVisible(true);
					window.setTopmost();
				}
				else
					window.setTopmost();
			}
		});
	}
}
