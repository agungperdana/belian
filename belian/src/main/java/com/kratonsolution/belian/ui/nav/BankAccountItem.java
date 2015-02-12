/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.bankaccount.BankAccountWindow;

/**
 * @author agungdodiperdana
 *
 */
public class BankAccountItem extends Listitem
{
	public BankAccountItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Bank Account");
		setImage("/icons/bank.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				BankAccountWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof BankAccountWindow)
						window = (BankAccountWindow)component;
				}
				
				if(window == null)
					window = BankAccountWindow.injectInto(getPage());
				
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
