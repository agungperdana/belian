/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.companystructure.CompanyStructureWindow;

/**
 * @author agungdodiperdana
 *
 */
public class CompanyStructureItem extends Listitem
{
	public CompanyStructureItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Company Structure");
		setImage("/icons/companystructure.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CompanyStructureWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof CompanyStructureWindow)
						window = (CompanyStructureWindow)component;
				}
				
				if(window == null)
					window = CompanyStructureWindow.injectInto(getPage());
				
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
