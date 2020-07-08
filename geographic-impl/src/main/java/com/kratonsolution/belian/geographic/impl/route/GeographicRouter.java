package com.kratonsolution.belian.geographic.impl.route;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.geographic.api.GeographicRouteName;
import com.kratonsolution.belian.geographic.api.application.GeographicService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class GeographicRouter extends RouteBuilder {

	@Autowired
	private GeographicService service;
	
	@Override
	public void configure() throws Exception {
		from(GeographicRouteName.COUNT)
			.setBody()
			.constant(service.count());
		
		from(GeographicRouteName.ALL_GEOGRAPHICS_ROOTS)
			.process(e->e.getMessage().setBody(service.getAllGeographicRoots(), List.class));
	}
}
