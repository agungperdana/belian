package com.kratonsolution.belian.impl.security.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.commonspring.ModuleRegistrationEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class SecurityModule implements ApplicationListener<ContextStartedEvent>{

	public static String SECURITY_USER = "com.kratonsolution.belian.security.user";
	public static String SECURITY_MODULE = "com.kratonsolution.belian.security.module";
	public static String SECURITY_ROLE = "com.kratonsolution.belian.security.role";
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		
		publisher.publishEvent(new ModuleRegistrationEvent(this, SECURITY_MODULE));
		publisher.publishEvent(new ModuleRegistrationEvent(this, SECURITY_USER));
		publisher.publishEvent(new ModuleRegistrationEvent(this, SECURITY_ROLE));
	}
}
