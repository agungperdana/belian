/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.sales.billing.BillingWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BillingItem extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public BillingItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.sales.billing"));
		setImage("/icons/billing32.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				BillingWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof BillingWindow)
						window = (BillingWindow)component;
				}
				
				if(window == null)
					window = BillingWindow.injectInto(getPage());
				
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
