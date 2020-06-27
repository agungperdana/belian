package com.kratonsolution.belian.partys.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.event.ModuleEvent;
import com.kratonsolution.belian.party.impl.model.Organization;
import com.kratonsolution.belian.partys.ui.organization.OrganizationHandler;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class PartyModuleListener implements ApplicationListener<ModuleEvent> {

	@Override
	public void onApplicationEvent(ModuleEvent event) {
		
		if(event.getModuleName().equals(Organization.class.getName())) {
			OrganizationHandler.build();
		}
	}
}
