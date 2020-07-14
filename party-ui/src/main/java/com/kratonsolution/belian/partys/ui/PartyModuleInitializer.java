package com.kratonsolution.belian.partys.ui;

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
 * @sinch 2.0
 */
@Slf4j
@Service
public class PartyModuleInitializer implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		log.info("Publisher {}", publisher);
		
		ModuleRegistryInformation info = new ModuleRegistryInformation();
		info.setPosition(5);
		info.setName(Labels.getLabel("label.caption.party"));
		info.setNickName(Labels.getLabel("label.caption.party.nickname"));
		info.setFisheyeImage(getClass().getResource("/images/fisheye/party.png"));
		info.setLauncherImage(getClass().getResource("/images/registry/party.png"));
		
		publisher.publishEvent(new ModuleRegistrationEvent(this, info));
	}
}
