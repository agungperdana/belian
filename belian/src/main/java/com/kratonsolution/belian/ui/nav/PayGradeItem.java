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
import com.kratonsolution.belian.ui.hr.paygrade.PayGradeWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PayGradeItem extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public PayGradeItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.hr.paygrade"));
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
