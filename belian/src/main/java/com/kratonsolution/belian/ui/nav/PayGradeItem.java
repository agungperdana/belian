/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.paygrade.PayGradeWindow;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PayGradeItem extends Listitem
{
	public PayGradeItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Pay Grade");
		setImage("/icons/paygrade.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PayGradeWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof PayGradeWindow)
						window = (PayGradeWindow)component;
				}
				
				if(window == null)
					window = PayGradeWindow.injectInto(getPage());
				
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
