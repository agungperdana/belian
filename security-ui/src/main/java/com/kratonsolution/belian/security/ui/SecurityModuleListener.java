package com.kratonsolution.belian.security.ui;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.event.ModuleEvent;
import com.kratonsolution.belian.security.ui.module.SecurityModuleHandler;
import com.kratonsolution.belian.security.ui.role.SecurityRoleHandler;
import com.kratonsolution.belian.security.ui.user.SecurityUserHandler;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class SecurityModuleListener implements ApplicationListener<ModuleEvent> {

	@Override
	public void onApplicationEvent(ModuleEvent event) {

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
