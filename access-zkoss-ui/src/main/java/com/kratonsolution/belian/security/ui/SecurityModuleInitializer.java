package com.kratonsolution.belian.security.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;
import com.kratonsolution.belian.common.ui.event.ModuleRegistrationEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Slf4j
@Service
public class SecurityModuleInitializer implements ApplicationListener<ContextRefreshedEvent>{

	public static String SECURITY_USER = "com.kratonsolution.belian.security.user";
	public static String SECURITY_MODULE = "com.kratonsolution.belian.security.module";
	public static String SECURITY_ROLE = "com.kratonsolution.belian.security.role";
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		log.info("Publisher {}", publisher);
		
		ModuleRegistryInformation moduleInfo = new ModuleRegistryInformation();
		moduleInfo.setPosition(1);
		moduleInfo.setName(SECURITY_MODULE);
		moduleInfo.setNickName("Module");
		moduleInfo.setFisheyeImage(getClass().getResource("/images/fisheye/module.png"));
		moduleInfo.setLauncherImage(getClass().getResource("/images/registry/module.png"));

		ModuleRegistryInformation roleInfo = new ModuleRegistryInformation();
		roleInfo.setPosition(2);
		roleInfo.setName(SECURITY_ROLE);
		roleInfo.setNickName("Role");
		roleInfo.setFisheyeImage(getClass().getResource("/images/fisheye/role.png"));
		roleInfo.setLauncherImage(getClass().getResource("/images/registry/role.png"));
		
		ModuleRegistryInformation userInfo = new ModuleRegistryInformation();
		userInfo.setPosition(3);
		userInfo.setName(SECURITY_USER);
		userInfo.setNickName("User");
		userInfo.setFisheyeImage(getClass().getResource("/images/fisheye/user.png"));
		userInfo.setLauncherImage(getClass().getResource("/images/registry/user.png"));
		
		publisher.publishEvent(new ModuleRegistrationEvent(this, moduleInfo));
		publisher.publishEvent(new ModuleRegistrationEvent(this, userInfo));
		publisher.publishEvent(new ModuleRegistrationEvent(this, roleInfo));
	}
}
