package com.kratonsolution.belian.access.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.api.ModuleRouteName;
import com.kratonsolution.belian.access.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.access.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.access.api.application.ModuleFilter;
import com.kratonsolution.belian.access.api.application.ModuleService;
import com.kratonsolution.belian.access.api.application.ModuleUpdateCommand;
import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class ModuleRouter extends RouteBuilder {

	@Autowired
	private ModuleService service;
	
	private void initJMSRoute() {
		
		from(ModuleRouteName.CREATE).process(e->
			e.getMessage().setBody(service.create(e.getIn().getBody(ModuleCreateCommand.class))));
		
		from(ModuleRouteName.UPDATE).process(e->
			e.getMessage().setBody(service.update(e.getIn().getBody(ModuleUpdateCommand.class))));
		
		from(ModuleRouteName.DELETE).process(e->
			e.getMessage().setBody(service.delete(e.getIn().getBody(ModuleDeleteCommand.class))));
		
		from(ModuleRouteName.BY_CODE).process(e->
			e.getMessage().setBody(service.getByCode(e.getIn().getBody(String.class))));

		from(ModuleRouteName.ALL_MODULES).process(e->e.getMessage().setBody(service.getAllModules()));
		
		from(ModuleRouteName.ALL_MODULES_PAGING).process(e->{
			
			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(service.getAllModules((Integer)params[0], (Integer)params[1]));
		});
	    
		from(ModuleRouteName.ALL_MODULES_FILTER).process(e->{
			
			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(
					service.getAllModules((ModuleFilter)params[0], 
							(Integer)params[1], (Integer)params[2]));
		});
		
		from(ModuleRouteName.COUNT).setBody().constant(service.count());
		
		from(ModuleRouteName.COUNT_FILTER).process(e->
			e.getMessage().setBody(service.count(e.getIn().getBody(ModuleFilter.class))));
		
	}

	private void initRESTReoute() {
		
		rest()
			.path("modules")
			.get("/get/{code}")
			.route()
			.process(AuthProcess.forRole("SCR-MDL_READ"))
			.process((ex)->{
				ex.getMessage().setBody(ResponseBuilder.success(service.getByCode(ex.getIn().getHeader("code", String.class))));
			});
		
		rest()
			.path("/modules")
			.get("/all-modules")
			.route()
			.process(AuthProcess.forRole("SCR-MDL_READ"))
			.process((ex)->{
				ex.getMessage().setBody(ResponseBuilder.success(service.getAllModules()));
			});
		
		rest()
			.path("/modules")
			.post("/create")
			.bindingMode(RestBindingMode.json)
			.type(ModuleCreateCommand.class)
			.route()
			.process(AuthProcess.forRole("SCR-MDL_ADD"))
			.process((ex)->{
				ex.getMessage()
				  .setBody(ResponseBuilder
						  .success(service.create(ex.getIn().getBody(ModuleCreateCommand.class))));
			});
		
		rest()
			.path("/modules")
			.put("/edit")
			.bindingMode(RestBindingMode.json)
			.type(ModuleUpdateCommand.class)
			.route()
			.process(AuthProcess.forRole("SCR-MDL_EDIT"))
			.process((ex)->{
			ex.getMessage()
			  .setBody(ResponseBuilder
					  .success(service.update(ex.getIn().getBody(ModuleUpdateCommand.class))));
		});
		
		rest()
			.path("/modules")
			.delete("/delete")
			.bindingMode(RestBindingMode.json)
			.type(ModuleDeleteCommand.class)
			.route()
			.process(AuthProcess.forRole("SCR-MDL_DELETE"))
			.process((ex)->{
				ex.getMessage()
					.setBody(ResponseBuilder
					  .success(service.delete(ex.getIn().getBody(ModuleDeleteCommand.class))));
		});
	}

	@Override
	public void configure() throws Exception {
		initJMSRoute();
		initRESTReoute();
	}

}
