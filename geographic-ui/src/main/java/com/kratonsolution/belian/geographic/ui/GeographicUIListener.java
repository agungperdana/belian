package com.kratonsolution.belian.geographic.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.event.ModuleEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class GeographicUIListener implements ApplicationListener<ModuleEvent> {

	@Override
	public void onApplicationEvent(ModuleEvent event) {
		
		if(event.getModuleName().equals(GeographicUIInitializer.GEOGRAPHIC)) {
			new GeographicUIHandler();
		}
	}
}
