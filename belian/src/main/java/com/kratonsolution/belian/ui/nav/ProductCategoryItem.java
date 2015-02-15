/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.prodcategory.ProductCategoryWindow;

/**
 * @author agungdodiperdana
 *
 */
public class ProductCategoryItem extends Listitem
{
	public ProductCategoryItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Product Category");
		setImage("/icons/category.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
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
