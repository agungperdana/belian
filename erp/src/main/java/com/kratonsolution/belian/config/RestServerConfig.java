package com.kratonsolution.belian.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jetty.JettyHttpComponent;
import org.apache.camel.spi.RestConfiguration;
import org.apache.camel.spi.RestConfiguration.RestBindingMode;
import org.apache.camel.support.jsse.KeyManagersParameters;
import org.apache.camel.support.jsse.KeyStoreParameters;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
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
				
		RestConfiguration con = new RestConfiguration();
		con.setHost("0.0.0.0");
		con.setPort(8585);
		con.setEnableCORS(true);
		con.setBindingMode(RestBindingMode.json);

		Map<String, String> cors = new HashMap<>();
		cors.put("Access-Control-Allow-Origin", RestConfiguration.CORS_ACCESS_CONTROL_ALLOW_ORIGIN);
		cors.put("Access-Control-Allow-Method", RestConfiguration.CORS_ACCESS_CONTROL_ALLOW_METHODS);
		cors.put("Access-Control-Allow-Headers", RestConfiguration.CORS_ACCESS_CONTROL_ALLOW_HEADERS+", Authorization");
		cors.put("Access-Control-Max-Age", RestConfiguration.CORS_ACCESS_CONTROL_MAX_AGE);
		
		con.setCorsHeaders(cors);
				
		return con;
	}
	
	@Bean
	public ObjectMapper jacksonMapper() {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
		
		return mapper;
	}
}
