package com.kratonsolution.belian.access.user.adapter.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.user.api.UserFilter;
import com.kratonsolution.belian.access.user.api.application.ChangePasswordCommand;
import com.kratonsolution.belian.access.user.api.application.DeleteUserRoleCommand;
import com.kratonsolution.belian.access.user.api.application.RegisterNewUserRoleCommand;
import com.kratonsolution.belian.access.user.api.application.UpdateUserRoleCommand;
import com.kratonsolution.belian.access.user.api.application.UserCreateCommand;
import com.kratonsolution.belian.access.user.api.application.UserDeleteCommand;
import com.kratonsolution.belian.access.user.api.application.UserService;
import com.kratonsolution.belian.access.user.api.application.UserUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class UserJmsAdapter extends RouteBuilder {

	@Autowired
	private UserService service;

	static final String CREATE = "activemq:user-create?exchangePattern=InOut";
	static final String UPDATE = "activemq:user-update?exchangePattern=InOut";
	static final String DELETE = "activemq:user-delete?exchangePattern=InOut";
	static final String BY_NAME = "activemq:user-getbyname?exchangePattern=InOut";
	static final String BY_EMAIL = "activemq:user-getbyemail?exchangePattern=InOut";
	static final String JMS_ALL_USERS = "activemq:user-getallusers?exchangePattern=InOut";
	static final String ALL_USERS_PAGING = "activemq:user-getallusers-paging?exchangePattern=InOut";
	static final String ALL_USERS_FILTER = "activemq:user-getallusers-filter?exchangePattern=InOut";
	static final String COUNT = "activemq:user-count?exchangePattern=InOut";
	static final String COUNT_FILTER = "activemq:user-count-paging?exchangePattern=InOut";
	static final String ADD_ROLE = "activemq:user-add-new-user-role?exchangePattern=InOut";
	static final String UPDATE_ROLE = "activemq:user-update-user-role?exchangePattern=InOut";
	static final String DELETE_ROLE = "activemq:user-delete-user-role?exchangePattern=InOut";
	static final String CHANGE_PASSWORD = "activemq:user-change-password?exchangePattern=InOut";
	static final String ALL_USERS = "direct:user-getallusers";
	
	@Override
	public void configure() throws Exception {

		from(CREATE).transacted().process(e->
		e.getMessage().setBody(service.create(e.getIn().getBody(UserCreateCommand.class))));

		from(UPDATE).transacted().process(e->
		e.getMessage().setBody(service.update(e.getIn().getBody(UserUpdateCommand.class))));

		from(DELETE).transacted().process(e->
		e.getMessage().setBody(service.delete(e.getIn().getBody(UserDeleteCommand.class))));

		from(BY_NAME).process(e->
		e.getMessage().setBody(service.getByName(e.getIn().getBody(String.class))));

		from(BY_EMAIL).process(e->
		e.getMessage().setBody(service.getByEmail(e.getIn().getBody(String.class))));

		from(JMS_ALL_USERS).process(e->e.getMessage().setBody(service.getAllUsers()));

		from(ALL_USERS_PAGING).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(service.getAllUsers((Integer)params[0], (Integer)params[1]));
		});

		from(ALL_USERS_FILTER).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(
					service.getAllUsers((UserFilter)params[0], 
							(Integer)params[1], (Integer)params[2]));
		});


		from(COUNT).process(e->e.getMessage().setBody(Integer.valueOf(service.count())));

		from(COUNT_FILTER).process(e->
		e.getMessage().setBody(service.count(e.getIn().getBody(UserFilter.class))));

		from(ADD_ROLE).transacted().process(e->
		e.getMessage().setBody(service.addNewUserRole(e.getIn().getBody(RegisterNewUserRoleCommand.class))));

		from(UPDATE_ROLE).transacted().process(e->
		e.getMessage().setBody(service.updateUserRole(e.getIn().getBody(UpdateUserRoleCommand.class))));

		from(DELETE_ROLE).transacted().process(e->
		e.getMessage().setBody(service.deleteUserRole(e.getIn().getBody(DeleteUserRoleCommand.class))));

		from(CHANGE_PASSWORD).transacted().process(e->
		e.getMessage().setBody(service.changePassword(e.getIn().getBody(ChangePasswordCommand.class))));
	}
}
