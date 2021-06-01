package com.kratonsolution.belian.access.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.api.RoleRouteName;
import com.kratonsolution.belian.access.api.application.RoleCreateCommand;
import com.kratonsolution.belian.access.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.access.api.application.RoleFilter;
import com.kratonsolution.belian.access.api.application.RoleService;
import com.kratonsolution.belian.access.api.application.RoleUpdateCommand;

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

}
