package com.kratonsolution.belian.access.module.adapter.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.api.ModuleRouteName;
import com.kratonsolution.belian.access.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.access.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.access.api.application.ModuleFilter;
import com.kratonsolution.belian.access.api.application.ModuleService;
import com.kratonsolution.belian.access.api.application.ModuleUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class ModuleJmsRouter extends RouteBuilder {

	@Autowired
	private ModuleService service;

	@Override
	public void configure() throws Exception {

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

}
