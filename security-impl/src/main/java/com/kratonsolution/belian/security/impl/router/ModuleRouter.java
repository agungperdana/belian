package com.kratonsolution.belian.security.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.integration.IntegrationRouter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class ModuleRouter extends RouteBuilder implements IntegrationRouter {

	@Override
	public void initJMSRoute() {
	}

	@Override
	public void initRESTReoute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure() throws Exception {
		initJMSRoute();
		initRESTReoute();
	}

}
