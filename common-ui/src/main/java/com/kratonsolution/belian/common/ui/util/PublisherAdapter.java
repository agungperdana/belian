package com.kratonsolution.belian.common.ui.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */

@Service
public class PublisherAdapter {

	@Autowired
	private ApplicationEventPublisher publisher;

	public void publish(ApplicationEvent event) {
		publisher.publishEvent(event);
	}
}
