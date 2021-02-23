package com.kratonsolution.belian.config;

import org.apache.activemq.ActiveMQConnectionFactory;
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
	public ActiveMQConnectionFactory connectionFactory() {
		
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		factory.setTrustAllPackages(true);
		
		return factory;
	}
}
