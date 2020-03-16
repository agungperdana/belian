package com.kratonsolution.belian.security.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Executions;

import com.kratonsolution.belian.common.ui.ModuleCommunicationEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class SecurityModuleCommunicationEventListener implements ApplicationListener<ModuleCommunicationEvent> {

	@Override
	public void onApplicationEvent(ModuleCommunicationEvent event) {
		
		if(event.getModuleName().equals(SecurityModuleInitializer.SECURITY_MODULE)) {
		
			if(event.getType().equals(ModuleCommunicationEvent.Type.OPEN)) {
				
				ModuleWindow window = new ModuleWindow();
				window.setPage(Executions.getCurrent().getDesktop().getFirstPage());
				window.doOverlapped();
			}
		}
	}

}
