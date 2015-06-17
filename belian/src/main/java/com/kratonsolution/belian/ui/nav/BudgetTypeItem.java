/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.budgettype.BudgetTypeWindow;

/**
 * @author agungdodiperdana
 *
 */
public class BudgetTypeItem extends Listitem
{
	public BudgetTypeItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Budget Type");
		setImage("/icons/budgettype.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				BudgetTypeWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof BudgetTypeWindow)
						window = (BudgetTypeWindow)component;
				}
				
				if(window == null)
					window = BudgetTypeWindow.injectInto(getPage());
				
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
