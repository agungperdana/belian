package com.kratonsolution.belian.geographic.impl.route;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
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
public class GeographicRouter extends RouteBuilder {

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

	public void initRESTReoute() {
		
		rest()
			.path("/geographics/get")
			.get("/{code}")
			.route()
			.process(new AuthProcess("GEOGRAPHIC_READ"))
			.process(e->{
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.getByCode(e.getIn().getHeader("code", String.class))));
			})
			.endRest();
		
		rest()
			.path("/geographics/all-geographics-roots")
			.get("/{page}/{size}")
			.route()
			.process(new AuthProcess("GEOGRAPHIC_READ"))
			.process(e->{
				
				GeographicFilter filter = new GeographicFilter();
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				filter.setRoot(true);
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.getAllGeographics(filter)));
			})
			.endRest();
		
		rest()
			.path("/geographics/filter-roots")
			.get("/{page}/{size}/{key}")
			.route()
			.process(new AuthProcess("GEOGRAPHIC_READ"))
			.process(e->{
				
				GeographicFilter filter = new GeographicFilter();
				filter.setKey(e.getIn().getHeader("key", String.class));
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				filter.setRoot(true);
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.getAllGeographics(filter)));
			})
			.endRest();
		
		rest()
			.path("/geographics/all-geographics")
			.get("/{page}/{size}")
			.route()
			.process(new AuthProcess("GEOGRAPHIC_READ"))
			.process(e->{
				
				GeographicFilter filter = new GeographicFilter();
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.getAllGeographics(filter)));
			})
			.endRest();
		
		rest()
			.path("/geographics/filter")
			.get("/{page}/{size}/{key}")
			.route()
			.process(new AuthProcess("GEOGRAPHIC_READ"))
			.process(e->{
				
				GeographicFilter filter = new GeographicFilter();
				filter.setKey(e.getIn().getHeader("key", String.class));
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.getAllGeographics(filter)));
			})
			.endRest();
		
		rest()
			.path("/geographics")
			.post("/create")
			.type(GeographicCreateCommand.class)
			.route()
			.process(new AuthProcess("GEOGRAPHIC_ADD"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.create(e.getIn().getBody(GeographicCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/geographics")
			.put("/update")
			.type(GeographicUpdateCommand.class)
			.route()
			.process(new AuthProcess("GEOGRAPHIC_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.update(e.getIn().getBody(GeographicUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/geographics")
			.delete("/delete")
			.type(GeographicDeleteCommand.class)
			.route()
			.process(new AuthProcess("GEOGRAPHIC_DELETE"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.delete(e.getIn().getBody(GeographicDeleteCommand.class))));
			})
			.endRest();
	}
}
