package com.kratonsolution.belian.access.impl.router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kratonsolution.belian.access.api.RoleData;
import com.kratonsolution.belian.access.api.UserData;
import com.kratonsolution.belian.access.api.UserFilter;
import com.kratonsolution.belian.access.api.UserRouteName;
import com.kratonsolution.belian.access.api.application.ChangePasswordCommand;
import com.kratonsolution.belian.access.api.application.DeleteUserRoleCommand;
import com.kratonsolution.belian.access.api.application.RegisterNewUserRoleCommand;
import com.kratonsolution.belian.access.api.application.RoleService;
import com.kratonsolution.belian.access.api.application.SignInCommand;
import com.kratonsolution.belian.access.api.application.UpdateUserRoleCommand;
import com.kratonsolution.belian.access.api.application.UserCreateCommand;
import com.kratonsolution.belian.access.api.application.UserDeleteCommand;
import com.kratonsolution.belian.access.api.application.UserService;
import com.kratonsolution.belian.access.api.application.UserUpdateCommand;
import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.common.router.BelianServiceRouter;
import com.kratonsolution.belian.security.jwt.JWTTokenGenerator;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class UserRouter extends RouteBuilder implements BelianServiceRouter {

	@Autowired
	private UserService service;
	
	@Autowired
	private RoleService roleService;
	
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

		from(UserRouteName.JMS_ALL_USERS).process(e->e.getMessage().setBody(service.getAllUsers()));

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
		
		rest()
			.path("/users")
			.bindingMode(RestBindingMode.json)
			.get("/all-users").route()
			.process(new AuthProcess("SCR-USR_READ"))
			.process(e->e.getMessage().setBody(service.getAllUsers()))
			.endRest();
		
		rest()
			.path("/users")
			.bindingMode(RestBindingMode.json)
			.get("/all-users/{start}/{end}").route()
			.process(new AuthProcess("SCR-USR_READ"))
			.process(e->e.getMessage().setBody(service.getAllUsers(
								e.getIn().getHeader("start", Integer.class), 
								e.getIn().getHeader("end", Integer.class))))
			.endRest();
		
		rest()
			.consumes("application/json")
			.path("")
			.bindingMode(RestBindingMode.json)
			.post("/login").route().process(e->{

				@SuppressWarnings("unchecked")
				Map<String, String> map = e.getIn().getBody(Map.class);
				if(map != null) {
										
					SignInCommand command = new SignInCommand();
					command.setUsername(map.get("username"));
					command.setPassword(map.get("password"));
					
					UserData data = service.signIn(command);

					Map<String, Object> response = new HashMap<>();
					response.put("status", data != null);
					
					if(data != null) {						
						response.put("token", JWTTokenGenerator.encode(new Gson().toJson(buildUserMap(data))));
					}
					
					e.getMessage().setBody(response);
					
				}
			})
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
			.endRest();
	}
	
	private Map<String, Object> buildUserMap(UserData data) {
		
		Map<String, Object> user = new HashMap<>();
		user.put("name", data.getName());
		user.put("email", data.getEmail());
		user.put("enabled", data.isEnabled());
		user.put("locked", data.isLocked());
		
		List<Map<String, String>> list = new ArrayList<>();
		
		data.getRoles().forEach(role->{
			
			if(role.isEnabled()) {
				
				RoleData roleData = roleService.getByCode(role.getRoleCode());
				if(roleData != null) {

					roleData.getModules().forEach(mod->{
						
						if(mod.isRead()) {
							
							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_READ");
							list.add(roleName);
						}

						if(mod.isAdd()) {
							
							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_ADD");
							list.add(roleName);
						}
						
						if(mod.isEdit()) {
							
							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_EDIT");
							list.add(roleName);
						}
						
						if(mod.isDelete()) {
							
							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_DELETE");
							list.add(roleName);
						}
						
						if(mod.isPrint()) {
							
							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_PRINT");
							list.add(roleName);
						}
					});
				}
			}
		});
		
		user.put("roles", list);
		
		return user;
	}
}
