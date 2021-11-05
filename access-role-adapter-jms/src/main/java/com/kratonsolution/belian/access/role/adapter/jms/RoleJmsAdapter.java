package com.kratonsolution.belian.access.role.adapter.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kratonsolution.belian.access.role.api.RoleRouteName;
import com.kratonsolution.belian.access.role.api.application.RoleCreateCommand;
import com.kratonsolution.belian.access.role.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.access.role.api.application.RoleFilter;
import com.kratonsolution.belian.access.role.api.application.RoleService;
import com.kratonsolution.belian.access.role.api.application.RoleUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class RoleJmsAdapter extends RouteBuilder {

	@Autowired
	private RoleService service;

	@Override
	public void configure() throws Exception {

		Gson parser = new Gson();
		
		from(RoleRouteName.CREATE).process(e->
			e.getMessage().setBody(parser.toJson(service.create(e.getIn().getBody(RoleCreateCommand.class)))));

		from(RoleRouteName.UPDATE).process(e->
			e.getMessage().setBody(parser.toJson(service.update(e.getIn().getBody(RoleUpdateCommand.class)))));

		from(RoleRouteName.DELETE).process(e->
			e.getMessage().setBody(parser.toJson(service.delete(e.getIn().getBody(RoleDeleteCommand.class)))));

		from(RoleRouteName.BY_CODE).process(e->
			e.getMessage().setBody(parser.toJson(service.getByCode(e.getIn().getBody(String.class)))));

		from(RoleRouteName.ALL_ROLES).process(e -> e.getMessage().setBody(parser.toJson(service.getAllRoles())));

		from(RoleRouteName.ALL_ROLES_PAGING).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(parser.toJson(service.getAllRoles((Integer)params[0], (Integer)params[1])));
		});

		from(RoleRouteName.ALL_ROLES_FILTER).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(parser.toJson(service.getAllRoles((RoleFilter)params[0], (Integer)params[1], (Integer)params[2])));
		});

		from(RoleRouteName.COUNT).setBody().constant(service.count());

		from(RoleRouteName.COUNT_FILTER).process(e->e.getMessage().setBody(service.count(e.getIn().getBody(RoleFilter.class))));
	}
}
