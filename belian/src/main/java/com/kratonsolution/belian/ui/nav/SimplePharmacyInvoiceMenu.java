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
import com.kratonsolution.belian.ui.healtcare.simplepharmacyinvoice.SimplePharmacyInvoiceWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SimplePharmacyInvoiceMenu extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public SimplePharmacyInvoiceMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.healtcare.simplepharmacyinvoice"));
		setImage("/icons/simple-pharmacy-invoice.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				SimplePharmacyInvoiceWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof SimplePharmacyInvoiceWindow)
						window = (SimplePharmacyInvoiceWindow)component;
				}
				
				if(window == null)
					window = SimplePharmacyInvoiceWindow.injectInto(getPage());
				
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
