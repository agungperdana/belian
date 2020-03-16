package com.kratonsolution.belian.security.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.ui.ModuleRegistrationEvent;
import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;

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
		moduleInfo.setName(SECURITY_MODULE);
		moduleInfo.setNickName("Module");
		moduleInfo.setFisheyeImage("/images/fisheye/module.png");
		moduleInfo.setLauncherImage("/images/registry/module.png");
		
		ModuleRegistryInformation userInfo = new ModuleRegistryInformation();
		userInfo.setName(SECURITY_USER);
		userInfo.setNickName("User");
		userInfo.setFisheyeImage("/images/fisheye/user.png");
		userInfo.setLauncherImage("/images/registrt/user.png");
		
		ModuleRegistryInformation roleInfo = new ModuleRegistryInformation();
		roleInfo.setName(SECURITY_ROLE);
		roleInfo.setNickName("Role");
		roleInfo.setFisheyeImage("/images/fisheye/role.png");
		roleInfo.setLauncherImage("/images/registrt/role.png");
		
		publisher.publishEvent(new ModuleRegistrationEvent(this, moduleInfo));
		publisher.publishEvent(new ModuleRegistrationEvent(this, userInfo));
		publisher.publishEvent(new ModuleRegistrationEvent(this, roleInfo));
	}
}
