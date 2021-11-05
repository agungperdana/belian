package com.kratonsolution.belian.access.module.adapter.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kratonsolution.belian.access.module.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.access.module.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.access.module.api.application.ModuleFilter;
import com.kratonsolution.belian.access.module.api.application.ModuleService;
import com.kratonsolution.belian.access.module.api.application.ModuleUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class ModuleJmsRouter extends RouteBuilder {

	@Autowired
	private ModuleService service;
	
	static final String CREATE = "activemq:module-create?exchangePattern=InOut";
	static final String UPDATE = "activemq:module-update?exchangePattern=InOut";
	static final String DELETE = "activemq:module-delete?exchangePattern=InOut";
	static final String BY_CODE = "activemq:module-getbycode?exchangePattern=InOut";
	static final String ALL_MODULES = "activemq:module-getallmodules?exchangePattern=InOut";
	static final String ALL_MODULES_PAGING = "activemq:module-getallmodules-paging?exchangePattern=InOut";
	static final String ALL_MODULES_FILTER = "activemq:module-getallmodules-filter?exchangePattern=InOut";
	static final String COUNT = "activemq:module-count?exchangePattern=InOut";
	static final String COUNT_FILTER = "activemq:module-count-paging?exchangePattern=InOut";
	
	private Gson parser = new Gson();
	
	@Override
	public void configure() throws Exception {
		
		from(CREATE).process(e->
			e.getMessage().setBody(parser.toJson(service.create(e.getIn().getBody(ModuleCreateCommand.class)))));

		from(UPDATE).process(e->
			e.getMessage().setBody(parser.toJson(service.update(e.getIn().getBody(ModuleUpdateCommand.class)))));

		from(DELETE).process(e->
			e.getMessage().setBody(parser.toJson(service.delete(e.getIn().getBody(ModuleDeleteCommand.class)))));

		from(BY_CODE).process(e->
			e.getMessage().setBody(parser.toJson(service.getByCode(e.getIn().getBody(String.class)))));

		from(ALL_MODULES).process(e->e.getMessage().setBody(service.getAllModules()));

		from(ALL_MODULES_PAGING).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(parser.toJson(service.getAllModules((Integer)params[0], (Integer)params[1])));
		});

		from(ALL_MODULES_FILTER).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(parser.toJson(service.getAllModules((ModuleFilter)params[0], (Integer)params[1], (Integer)params[2])));
		});

		from(COUNT).setBody().constant(service.count());

		from(COUNT_FILTER).process(e -> e.getMessage().setBody(service.count(e.getIn().getBody(ModuleFilter.class))));

	}

}
