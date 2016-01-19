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
import com.kratonsolution.belian.ui.healtcare.labsresgistration.LabsRegistrationWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabsRegistrationItem extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public LabsRegistrationItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.healtcare.labsregistration"));
		setImage("/icons/labsregistration.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				LabsRegistrationWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof LabsRegistrationWindow)
						window = (LabsRegistrationWindow)component;
				}
				
				if(window == null)
					window = LabsRegistrationWindow.injectInto(getPage());
				
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
