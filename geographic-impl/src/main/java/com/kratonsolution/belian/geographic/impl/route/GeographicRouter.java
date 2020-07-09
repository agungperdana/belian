package com.kratonsolution.belian.geographic.impl.route;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.integration.IntegrationRouter;
import com.kratonsolution.belian.geographic.api.GeographicRouteName;
import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.api.application.GeographicCreateCommand;
import com.kratonsolution.belian.geographic.api.application.GeographicDeleteCommand;
import com.kratonsolution.belian.geographic.api.application.GeographicFilter;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.geographic.api.application.GeographicUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class GeographicRouter extends RouteBuilder implements IntegrationRouter {

	@Autowired
	private GeographicService service;

	@Override
	public void configure() throws Exception {

		initJMSRoute();
		initRESTReoute();
	}

	public void initJMSRoute() {
		
		from(GeographicRouteName.CRETATE).process(e->{

			GeographicCreateCommand command = e.getIn().getBody(GeographicCreateCommand.class);
			e.getMessage().setBody(service.create(command));
		});

		from(GeographicRouteName.UPDATE).process(e->{

			GeographicUpdateCommand command = e.getIn().getBody(GeographicUpdateCommand.class);
			e.getMessage().setBody(service.update(command));
		});
		
		from(GeographicRouteName.DELETE).process(e->{

			GeographicDeleteCommand command = e.getIn().getBody(GeographicDeleteCommand.class);
			e.getMessage().setBody(service.delete(command));
		});
		
		from(GeographicRouteName.BY_CODE)
			.process(e->e.getMessage().setBody(service.getByCode(e.getIn().getBody(String.class))));
		
		from(GeographicRouteName.ALL_GEOGRAPHICS)
			.process(e->e.getMessage().setBody(service.getAllGeographics(), List.class));

		from(GeographicRouteName.ALL_GEOGRAPHICS_ROOTS)
			.process(e->e.getMessage().setBody(service.getAllGeographicRoots(), List.class));
		
		from(GeographicRouteName.ALL_GEOGRAPHICS_WITH_PAGING).process(e->{
			
			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(service.getAllGeographics((Integer)params[0], (Integer)params[1]));
		});
		
		from(GeographicRouteName.ALL_GEOGRAPHICS_WITH_FILTER).process(e->{
			
			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(service.getAllGeographics((GeographicFilter)params[0],(Integer)params[1], (Integer)params[2]));
		});
		
		from(GeographicRouteName.ALL_BY_TYPE)
			.process(e->e.getMessage().setBody(service.getAllByType(e.getIn().getBody(GeographicType.class))));
		
		from(GeographicRouteName.COUNT)
			.setBody()
			.constant(service.count());
		
		from(GeographicRouteName.COUNT_FILTER)
			.process(e->e.getMessage().setBody(service.count(e.getIn().getBody(GeographicFilter.class))));
	}

	@Override
	public void initRESTReoute() {
		// TODO Auto-generated method stub
		
	}
}
