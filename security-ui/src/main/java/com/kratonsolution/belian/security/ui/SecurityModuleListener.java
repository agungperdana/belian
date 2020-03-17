package com.kratonsolution.belian.security.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.ModuleOpenWindowEvent;
import com.kratonsolution.belian.security.ui.handler.SecurityModuleHandler;
import com.kratonsolution.belian.security.ui.handler.SecurityRoleHandler;
import com.kratonsolution.belian.security.ui.handler.SecurityUserHandler;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class SecurityModuleListener implements ApplicationListener<ModuleOpenWindowEvent> {

	@Override
	public void onApplicationEvent(ModuleOpenWindowEvent event) {

		if(event.getModuleName().equals(SecurityModuleInitializer.SECURITY_MODULE)) {
			new SecurityModuleHandler();
		}
		else if(event.getModuleName().equals(SecurityModuleInitializer.SECURITY_USER)) {
			new SecurityUserHandler();
		}
		else if(event.getModuleName().equals(SecurityModuleInitializer.SECURITY_ROLE)) {
			new SecurityRoleHandler();
		}
	}
}
