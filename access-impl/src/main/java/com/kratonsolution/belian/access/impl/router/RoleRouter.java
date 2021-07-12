package com.kratonsolution.belian.access.impl.router;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.api.RoleRouteName;
import com.kratonsolution.belian.access.api.application.RoleCreateCommand;
import com.kratonsolution.belian.access.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.access.api.application.RoleFilter;
import com.kratonsolution.belian.access.api.application.RoleService;
import com.kratonsolution.belian.access.api.application.RoleUpdateCommand;
import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class RoleRouter extends RouteBuilder {

	@Autowired
	private RoleService service;
	
	@Override
	public void configure() throws Exception {
		
		initJMSRoute();
		initRestRoute();
	}
	
	private void initJMSRoute() {
		
		from(RoleRouteName.CREATE).process(e->
			e.getMessage().setBody(service.create(e.getIn().getBody(RoleCreateCommand.class))));
		
		from(RoleRouteName.UPDATE).process(e->
			e.getMessage().setBody(service.update(e.getIn().getBody(RoleUpdateCommand.class))));
		
		from(RoleRouteName.DELETE).process(e->
			e.getMessage().setBody(service.delete(e.getIn().getBody(RoleDeleteCommand.class))));
		
		from(RoleRouteName.BY_CODE).process(e->
			e.getMessage().setBody(service.getByCode(e.getIn().getBody(String.class))));

		from(RoleRouteName.ALL_ROLES).process(e->e.getMessage().setBody(service.getAllRoles()));
		
		from(RoleRouteName.ALL_ROLES_PAGING).process(e->{
			
			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(service.getAllRoles((Integer)params[0], (Integer)params[1]));
		});
	    
		from(RoleRouteName.ALL_ROLES_FILTER).process(e->{
			
			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(
					service.getAllRoles((RoleFilter)params[0], 
							(Integer)params[1], (Integer)params[2]));
		});
		
		from(RoleRouteName.COUNT).setBody().constant(service.count());
		
		from(RoleRouteName.COUNT_FILTER).process(e->
			e.getMessage().setBody(service.count(e.getIn().getBody(RoleFilter.class))));
		
	}
	
	private void initRestRoute() {
		
		rest()
			.consumes("application/json")
			.path("/roles/get")
			.get("/{code}")
			.route()
			.process(new AuthProcess("SCR-ROLE_READ"))
			.process((ex)->{
				
				ex.getMessage().setBody(
						ResponseBuilder.success(
								service.getByCode(ex.getIn().getHeader("code", String.class))));
			})
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.endRest();
		
		rest()
			.consumes("application/json")
			.path("/roles/all-roles")
			.get("/{page}/{size}")
			.route()
			.process(new AuthProcess("SCR-ROLE_READ"))
			.process((ex)->{
				
				RoleFilter filter = new RoleFilter();
				filter.setKey(ex.getIn().getHeader("key", String.class));
				filter.setPage(ex.getIn().getHeader("page", Integer.class));
				filter.setSize(ex.getIn().getHeader("size", Integer.class));
				
				ex.getMessage().setBody(ResponseBuilder.success(service.getAllRoles(filter)));
			})
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.endRest();
		
		rest()
			.consumes("application/json")
			.path("/roles/filter")
			.get("/{page}/{size}/{key}")
			.route()
			.process(new AuthProcess("SCR-ROLE_READ"))
			.process((ex)->{
			
				RoleFilter filter = new RoleFilter();
				filter.setKey(ex.getIn().getHeader("key", String.class));
				filter.setPage(ex.getIn().getHeader("page", Integer.class));
				filter.setSize(ex.getIn().getHeader("size", Integer.class));
				
				ex.getMessage().setBody(ResponseBuilder.success(service.getAllRoles(filter)));
			})
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.endRest();
		
		rest()
			.consumes("application/json")
			.path("/roles")
			.post("/create")
			.type(RoleCreateCommand.class)
			.route()
			.process(new AuthProcess("SCR-ROLE_ADD"))
			.process((ex)->{
			
				ex.getMessage().setBody(
						ResponseBuilder.success(
								service.create(ex.getIn().getBody(RoleCreateCommand.class))));
			})
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.endRest();
		
		rest()
			.consumes("application/json")
			.path("/roles")
			.put("/update")
			.type(RoleUpdateCommand.class)
			.route()
			.process(new AuthProcess("SCR-ROLE_EDIT"))
			.process((ex)->{
			
				ex.getMessage().setBody(
						ResponseBuilder.success(
								service.update(ex.getIn().getBody(RoleUpdateCommand.class))));
			})
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.endRest();
		
		rest()
			.consumes("application/json")
			.path("/roles")
			.delete("/delete")
			.type(RoleDeleteCommand.class)
			.route()
			.process(new AuthProcess("SCR-ROLE_DELETE"))
			.process((ex)->{
			
				ex.getMessage().setBody(
						ResponseBuilder.success(
								service.delete(ex.getIn().getBody(RoleDeleteCommand.class))));
			})
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.endRest();
	}

}
