package com.kratonsolution.belian.security.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.zkoss.util.resource.Labels;

import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;
import com.kratonsolution.belian.common.ui.event.ModuleRegistrationEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Slf4j
@Service
public class PartyModuleInitializer implements ApplicationListener<ContextRefreshedEvent>{

	public static String ORGANIZATION = "com.kratonsolution.belian.party.organization";
	public static String PERSON = "com.kratonsolution.belian.party.person";
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		log.info("Publisher {}", publisher);
		
		ModuleRegistryInformation organizationInfo = new ModuleRegistryInformation();
		organizationInfo.setPosition(5);
		organizationInfo.setName(ORGANIZATION);
		organizationInfo.setNickName(Labels.getLabel("caption.label.organization"));
		organizationInfo.setFisheyeImage(getClass().getResource("/images/fisheye/organization.png"));
		organizationInfo.setLauncherImage(getClass().getResource("/images/registry/organization.png"));
		
		publisher.publishEvent(new ModuleRegistrationEvent(this, organizationInfo));
	}
}
