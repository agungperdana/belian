package com.kratonsolution.belian.config;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jetty.JettyHttpComponent;
import org.apache.camel.component.rest.RestComponent;
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
	public void initJettyComponent() throws Exception {

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
		
//		RestComponent rest = server.getComponent("rest", RestComponent.class);
//		rest.setHost("https://0.0.0.0:9998");
		
		log.info("Server {}", camel);
		log.info("Component {}", jetty);
//		log.info("REST {}", rest);
	}
	//	
	//	@Bean
	//	public Server initServer() {
	//
	//		Server server = new Server();
	//
	//		try {
	//			HttpConfiguration https = new HttpConfiguration();
	//			https.addCustomizer(new SecureRequestCustomizer());
	//
	//			SslContextFactory sslContextFactory = new SslContextFactory.Server();
	//			sslContextFactory.setKeyStorePath(ResourceUtils.getFile("classpath:keystore.jks").getPath());
	//			sslContextFactory.setKeyStorePassword("kurakuraninjaturtle");
	//			sslContextFactory.setKeyManagerPassword("kurakuraninjaturtle");
	//
	//			ServerConnector sslConnector = new ServerConnector(server,
	//					new SslConnectionFactory(sslContextFactory, "http/1.1"),
	//					new HttpConnectionFactory(https));
	//			
	//			sslConnector.setPort(9998);
	//			
	//			server.setConnectors(new Connector[] {sslConnector});
	//			server.start();
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return server;
	//	}
}
