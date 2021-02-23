package com.kratonsolution.belian.geographic.ui;

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
 * @since 2.0
 */
@Slf4j
@Service
public class GeographicUIInitializer implements ApplicationListener<ContextRefreshedEvent>{

	public static String GEOGRAPHIC = "com.kratonsolution.belian.geographic";
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		log.info("Publisher {}", publisher);
		
		ModuleRegistryInformation moduleInfo = new ModuleRegistryInformation();
		moduleInfo.setPosition(4);
		moduleInfo.setName(GEOGRAPHIC);
		moduleInfo.setNickName("Geographic");
		moduleInfo.setFisheyeImage(getClass().getResource("/images/fisheye/geographic.png"));
		moduleInfo.setLauncherImage(getClass().getResource("/images/registry/geographic.png"));
		
		publisher.publishEvent(new ModuleRegistrationEvent(this, moduleInfo));
	}
}
