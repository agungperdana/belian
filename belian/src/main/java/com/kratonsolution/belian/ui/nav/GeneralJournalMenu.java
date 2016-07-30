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
import com.kratonsolution.belian.ui.financial.generaljournal.GeneralJournalReportWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeneralJournalMenu extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public GeneralJournalMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.finance.generaljournal"));
		setImage("/icons/general-journal.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				GeneralJournalReportWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof GeneralJournalReportWindow)
						window = (GeneralJournalReportWindow)component;
				}
				
				if(window == null)
					window = GeneralJournalReportWindow.injectInto(getPage());
				
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
