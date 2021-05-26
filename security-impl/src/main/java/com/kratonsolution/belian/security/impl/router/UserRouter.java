package com.kratonsolution.belian.security.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.router.BelianServiceRouter;
import com.kratonsolution.belian.security.api.UserFilter;
import com.kratonsolution.belian.security.api.UserRouteName;
import com.kratonsolution.belian.security.api.application.ChangePasswordCommand;
import com.kratonsolution.belian.security.api.application.DeleteUserRoleCommand;
import com.kratonsolution.belian.security.api.application.RegisterNewUserRoleCommand;
import com.kratonsolution.belian.security.api.application.UpdateUserRoleCommand;
import com.kratonsolution.belian.security.api.application.UserCreateCommand;
import com.kratonsolution.belian.security.api.application.UserDeleteCommand;
import com.kratonsolution.belian.security.api.application.UserService;
import com.kratonsolution.belian.security.api.application.UserUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class UserRouter extends RouteBuilder implements BelianServiceRouter {

	@Autowired
	private UserService service;
	
	@Override
	public void configure() throws Exception {
		
		initJMSRoute();
		initRESTRoute();
	}

	public void initJMSRoute() {

		from(UserRouteName.CREATE).transacted().process(e->
			e.getMessage().setBody(service.create(e.getIn().getBody(UserCreateCommand.class))));

		from(UserRouteName.UPDATE).transacted().process(e->
		e.getMessage().setBody(service.update(e.getIn().getBody(UserUpdateCommand.class))));

		from(UserRouteName.DELETE).transacted().process(e->
		e.getMessage().setBody(service.delete(e.getIn().getBody(UserDeleteCommand.class))));

		from(UserRouteName.BY_NAME).process(e->
		e.getMessage().setBody(service.getByName(e.getIn().getBody(String.class))));
		
		from(UserRouteName.BY_EMAIL).process(e->
		e.getMessage().setBody(service.getByEmail(e.getIn().getBody(String.class))));

		from(UserRouteName.ALL_USERS).process(e->e.getMessage().setBody(service.getAllUsers()));

		from(UserRouteName.ALL_USERS_PAGING).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(service.getAllUsers((Integer)params[0], (Integer)params[1]));
		});

		from(UserRouteName.ALL_USERS_FILTER).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(
					service.getAllUsers((UserFilter)params[0], 
							(Integer)params[1], (Integer)params[2]));
		});
		

		from(UserRouteName.COUNT).process(e->e.getMessage().setBody(Integer.valueOf(service.count())));

		from(UserRouteName.COUNT_FILTER).process(e->
			e.getMessage().setBody(service.count(e.getIn().getBody(UserFilter.class))));

		from(UserRouteName.ADD_ROLE).transacted().process(e->
			e.getMessage().setBody(service.addNewUserRole(e.getIn().getBody(RegisterNewUserRoleCommand.class))));
		
		from(UserRouteName.UPDATE_ROLE).transacted().process(e->
		e.getMessage().setBody(service.updateUserRole(e.getIn().getBody(UpdateUserRoleCommand.class))));
		
		from(UserRouteName.DELETE_ROLE).transacted().process(e->
		e.getMessage().setBody(service.deleteUserRole(e.getIn().getBody(DeleteUserRoleCommand.class))));
		
		from(UserRouteName.CHANGE_PASSWORD).transacted().process(e->
		e.getMessage().setBody(service.changePassword(e.getIn().getBody(ChangePasswordCommand.class))));
	}

	@Override
	public void initRESTRoute() {
		
		restConfiguration().component("jetty").host("127.0.0.1").port(8585);
		
		rest()
			.path("/users")
			.bindingMode(RestBindingMode.json)
			.get("/all-users").route().process(e->e.getMessage().setBody(service.getAllUsers()));
	}
}
