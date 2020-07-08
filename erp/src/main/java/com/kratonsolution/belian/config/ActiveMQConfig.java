package com.kratonsolution.belian.config;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Configuration
public class ActiveMQConfig {

	@Bean
	public BrokerService broker() throws Exception{
		
		BrokerService service = new BrokerService();
		service.setPersistent(false);
		service.setUseJmx(true);
		service.addConnector("tcp://127.0.0.1:61616");
		
		return service;
	}
}
