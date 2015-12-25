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
import com.kratonsolution.belian.ui.accounting.coa.COAWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CoAItem extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public CoAItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.accounting.coa"));
		setImage("/icons/coa.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				COAWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof COAWindow)
						window = (COAWindow)component;
				}
				
				if(window == null)
					window = COAWindow.injectInto(getPage());
				
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
