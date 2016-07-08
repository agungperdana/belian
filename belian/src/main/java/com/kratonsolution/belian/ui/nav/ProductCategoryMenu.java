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
import com.kratonsolution.belian.ui.inventory.prodcategory.ProductCategoryWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryMenu extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public ProductCategoryMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.inventory.category"));
		setImage("/icons/category.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
//				SessionUtils utils = Springs.get(SessionUtils.class);
//				if(utils.isSysAdmin())
//				{
//					Clients.showNotification("This module cannot be accessed using Sys Admin account.");
//					return;
//				}
				
				ProductCategoryWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof ProductCategoryWindow)
						window = (ProductCategoryWindow)component;
				}
				
				if(window == null)
					window = ProductCategoryWindow.injectInto(getPage());
				
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
