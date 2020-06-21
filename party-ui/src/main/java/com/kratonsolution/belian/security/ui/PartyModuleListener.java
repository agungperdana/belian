package com.kratonsolution.belian.security.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.event.ModuleOpenWindowEvent;
import com.kratonsolution.belian.security.ui.module.OrganizationHandler;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class PartyModuleListener implements ApplicationListener<ModuleOpenWindowEvent> {

	@Override
	public void onApplicationEvent(ModuleOpenWindowEvent event) {

		if(event.getModuleName().equals(PartyModuleInitializer.ORGANIZATION)) {
			new OrganizationHandler();
		}
	}
}
