/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.accountingsetting.AccountingSettingWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AccountingSettingItem extends Listitem
{
	public AccountingSettingItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Accounting Setting");
		setImage("/icons/accountingsetting.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				AccountingSettingWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof AccountingSettingWindow)
						window = (AccountingSettingWindow)component;
				}
				
				if(window == null)
					window = new AccountingSettingWindow();
				
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
