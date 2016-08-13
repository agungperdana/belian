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
import com.kratonsolution.belian.ui.general.geographic.GeographicWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeographicMenu extends Listitem
{
	private Language lang = Springs.get(Language.class);
	
	public GeographicMenu()
	{
		init();
	}
	
	public void init()
	{
		System.out.println(this);
		System.out.println(lang.get("navbar.menu.general.geographic"));
		
		setLabel(lang.get("navbar.menu.general.geographic"));
		setImage("/icons/geographic.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				GeographicWindow window = null;
				for(Component component:getPage().getRoots())
				{
					if(component instanceof GeographicWindow)
						window = (GeographicWindow)component;
				}
				
				if(window == null)
					window = GeographicWindow.injectInto(getPage());
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
