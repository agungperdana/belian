package com.kratonsolution.belian.access.module.adapter.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.module.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.access.module.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.access.module.api.application.ModuleFilter;
import com.kratonsolution.belian.access.module.api.application.ModuleService;
import com.kratonsolution.belian.access.module.api.application.ModuleUpdateCommand;
import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class ModuleRestRouter extends RouteBuilder {

	@Autowired
	private ModuleService service;

	@Override
	public void configure() throws Exception {

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
		.path("/modules/all-modules")
		.get("/{page}/{size}")
		.route()
		.process(AuthProcess.forRole("SCR-MDL_READ"))
		.process((ex)->{

			ModuleFilter filter = new ModuleFilter();
			filter.setPage(ex.getIn().getHeader("page", Integer.class));
			filter.setSize(ex.getIn().getHeader("size", Integer.class));

			ex.getMessage().setBody(ResponseBuilder.success(service.getAllModules(filter)));
		});

		rest()
		.path("/modules/filter")
		.get("/{page}/{size}/{key}")
		.bindingMode(RestBindingMode.json)
		.route()
		.process(AuthProcess.forRole("SCR-MDL_READ"))
		.process((ex)->{

			ModuleFilter filter = new ModuleFilter();
			filter.setKey(ex.getIn().getHeader("key", String.class));
			filter.setPage(ex.getIn().getHeader("page", Integer.class));
			filter.setSize(ex.getIn().getHeader("size", Integer.class));

			ex.getMessage().setBody(
					ResponseBuilder.success(
							service.getAllModules(filter)));
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

}
