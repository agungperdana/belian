package com.kratonsolution.belian.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jetty.JettyHttpComponent;
import org.apache.camel.spi.RestConfiguration;
import org.apache.camel.support.jsse.KeyManagersParameters;
import org.apache.camel.support.jsse.KeyStoreParameters;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
@Slf4j
@Configuration
public class RestServerConfig {

	@Autowired
	private CamelContext camel;

	@Bean
	public RestConfiguration initJettyComponent() throws Exception {

		KeyStoreParameters ksp = new KeyStoreParameters();
		ksp.setResource(ResourceUtils.getFile("classpath:keystore.jks").getPath());
		ksp.setPassword("kurakuraninjaturtle");

		KeyManagersParameters kmp = new KeyManagersParameters();
		kmp.setKeyStore(ksp);
		kmp.setKeyPassword("kurakuraninjaturtle");

		SSLContextParameters scp = new SSLContextParameters();
		scp.setKeyManagers(kmp);

		JettyHttpComponent jetty = camel.getComponent("jetty", JettyHttpComponent.class);
		jetty.setSslContextParameters(scp);
		
		Map<String, String> cors = new HashMap<>();
		cors.put("Access-Control-Allow-Origin", "*");       
		cors.put("Access-Control-Allow-Headers", "access-control-allow-methods,access-control-allow-origin,authorization,content-type");        
		cors.put("Access-Control-Allow-Methods", "GET, DELETE, POST, OPTIONS, PUT");

		
		
		RestConfiguration restConfig = new RestConfiguration();
		restConfig.setComponent("jetty");
		restConfig.setHost("0.0.0.0");
		restConfig.setPort(8585);
		restConfig.setEnableCORS(true);
		
		log.info("Server {}", camel);
		log.info("Component {}", jetty);
		
		return restConfig;
	}
}
