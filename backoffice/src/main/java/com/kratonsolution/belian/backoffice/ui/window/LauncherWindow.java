package com.kratonsolution.belian.backoffice.ui.window;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.backoffice.application.ModuleRegistry;
import com.kratonsolution.belian.backoffice.application.PublisherAdapter;
import com.kratonsolution.belian.backoffice.ui.Springs;
import com.kratonsolution.belian.common.ui.ModuleCommunicationEvent;
import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LauncherWindow extends Window {

	private static final long serialVersionUID = 1L;

	private Listbox listbox = new Listbox();
	
	public LauncherWindow() {
		
		setBorder(false);
		setWidth("50%");
		setHeight("40%");
		setPosition("center");
		setTopmost();
		
		listbox.setHflex("1");
		listbox.setVflex("1");
		
		appendChild(listbox);
		
		initContent();
	}
	
	private void initContent() {
		
		PublisherAdapter publisher = Springs.get(PublisherAdapter.class);
		if(publisher != null) {
			
			ModuleRegistry registry = Springs.get(ModuleRegistry.class);
			if(registry != null) {
				
				for(ModuleRegistryInformation info:registry.getRegistyrs()) {
					
					listbox.appendItem(info.getNickName(), info.getLauncherImage())
						.addEventListener(Events.ON_CLICK, e -> {
							
							publisher.publish(new ModuleCommunicationEvent(this, info.name, ModuleCommunicationEvent.Type.OPEN));
						});
				}
			}
		}
	}
}
