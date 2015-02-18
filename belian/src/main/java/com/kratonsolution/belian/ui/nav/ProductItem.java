/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.ui.product.ProductWindow;

/**
 * @author agungdodiperdana
 *
 */
public class ProductItem extends Listitem
{
	public ProductItem()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Product");
		setImage("/icons/product.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ProductWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof ProductWindow)
						window = (ProductWindow)component;
				}
				
				if(window == null)
					window = ProductWindow.injectInto(getPage());
				
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
