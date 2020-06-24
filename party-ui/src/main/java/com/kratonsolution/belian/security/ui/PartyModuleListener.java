package com.kratonsolution.belian.security.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.event.ContentEvent;
import com.kratonsolution.belian.common.ui.event.ModuleOpenWindowEvent;
import com.kratonsolution.belian.security.ui.module.OrganizationUIEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class PartyModuleListener implements ApplicationListener<ModuleOpenWindowEvent> {

	@Override
	public void onApplicationEvent(ModuleOpenWindowEvent event) {

		EventQueues.lookup(OrganizationUIEvent.class.getSimpleName())
					.publish(new OrganizationUIEvent(ContentEvent.OPEN_WINDOW, "ORGANIZATION"));
	}
}
