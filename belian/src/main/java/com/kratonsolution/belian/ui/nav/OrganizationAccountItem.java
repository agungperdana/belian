/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.organizationaccount.OrganizationAccountWindow;

/**
 * @author agungdodiperdana
 *
 */
public class OrganizationAccountItem extends Listitem
{
	public OrganizationAccountItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Organization GL Account");
		setImage("/icons/orgacc.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				OrganizationAccountWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof OrganizationAccountWindow)
						window = (OrganizationAccountWindow)component;
				}
				
				if(window == null)
					window = OrganizationAccountWindow.injectInto(getPage());
				
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
