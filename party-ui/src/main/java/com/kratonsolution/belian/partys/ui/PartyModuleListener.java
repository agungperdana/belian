package com.kratonsolution.belian.partys.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.zkoss.util.resource.Labels;

import com.kratonsolution.belian.common.ui.event.ModuleEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class PartyModuleListener implements ApplicationListener<ModuleEvent> {

	@Override
	public void onApplicationEvent(ModuleEvent event) {
		
		if(event.getModuleName().equals(Labels.getLabel("label.caption.party"))) {
			PartyUIHandler.build();
		}
	}
}
