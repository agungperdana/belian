/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.journalentry.JournalEntryWindow;

/**
 * @author agungdodiperdana
 *
 */
public class JournalEntryItem extends Listitem
{
	public JournalEntryItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Journal Entry");
		setImage("/icons/journalentry.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				JournalEntryWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof JournalEntryWindow)
						window = (JournalEntryWindow)component;
				}
				
				if(window == null)
					window = JournalEntryWindow.injectInto(getPage());
				
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
