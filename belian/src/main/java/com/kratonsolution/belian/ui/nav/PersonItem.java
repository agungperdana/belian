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
import com.kratonsolution.belian.ui.general.person.PersonWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonItem extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public PersonItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.general.person"));
		setImage("/icons/person.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PersonWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof PersonWindow)
						window = (PersonWindow)component;
				}
				
				if(window == null)
					window = PersonWindow.injectInto(getPage());
				
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
