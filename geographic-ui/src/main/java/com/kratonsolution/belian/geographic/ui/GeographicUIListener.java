package com.kratonsolution.belian.geographic.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.event.ModuleOpenWindowEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class GeographicUIListener implements ApplicationListener<ModuleOpenWindowEvent> {

	@Override
	public void onApplicationEvent(ModuleOpenWindowEvent event) {
		
		new GeographicUIHandler();
	}
}
