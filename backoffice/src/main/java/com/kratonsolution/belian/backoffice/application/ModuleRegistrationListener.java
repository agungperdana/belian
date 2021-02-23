package com.kratonsolution.belian.backoffice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.event.ModuleRegistrationEvent;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Slf4j
@Service
public class ModuleRegistrationListener implements ApplicationListener<ModuleRegistrationEvent> {

	@Autowired
	private ModuleRegistry manager;
	
	@Override
	public void onApplicationEvent(@NonNull ModuleRegistrationEvent event) {
		
		manager.registerModule(event.getModuleInformation());
		log.info("Module {} activated", event.getModuleInformation());
	}
}
