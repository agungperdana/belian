package com.kratonsolution.belian.access.user.adapter.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kratonsolution.belian.access.role.driver.jms.RoleData;
import com.kratonsolution.belian.access.role.driver.jms.RoleJmsDriver;
import com.kratonsolution.belian.access.user.api.UserData;
import com.kratonsolution.belian.access.user.api.UserFilter;
import com.kratonsolution.belian.access.user.api.application.SignInCommand;
import com.kratonsolution.belian.access.user.api.application.UserCreateCommand;
import com.kratonsolution.belian.access.user.api.application.UserDeleteCommand;
import com.kratonsolution.belian.access.user.api.application.UserService;
import com.kratonsolution.belian.access.user.api.application.UserUpdateCommand;
import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.companystructure.driver.jms.CompanyStructureData;
import com.kratonsolution.belian.companystructure.driver.jms.CompanyStructureJmsDriver;
import com.kratonsolution.belian.security.jwt.JWTConstant;
import com.kratonsolution.belian.security.jwt.JWTTokenUtil;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class UserRestAdapter extends RouteBuilder {

	@Autowired
	private UserService service;
	
	@Autowired
	private RoleJmsDriver roleService;
	
	@Autowired
	private CompanyStructureJmsDriver csDriver;

	@Override
	public void configure() throws Exception {

		rest()
			.path("/users/get")
			.get("/{email}")
			.route()
			.process(new AuthProcess("SCR-USR_READ"))
			.process(e -> e.getMessage().setBody(
					ResponseBuilder.success(
							service.getByEmail(e.getIn().getHeader("email", String.class)))))
			.endRest();

		rest()
			.path("/users/filter")
			.get("/{page}/{size}/{key}").route()
			.process(new AuthProcess("SCR-USR_READ"))
			.process(ex -> {
	
				UserFilter filter = new UserFilter();
				filter.setKey(ex.getIn().getHeader("key", String.class));
				filter.setPage(ex.getIn().getHeader("page", Integer.class));
				filter.setSize(ex.getIn().getHeader("size", Integer.class));
	
				ex.getMessage().setBody(ResponseBuilder.success(service.getAllUsers(filter)));
			})
			.setHeader("Access-Control-Allow-Origin", constant("*"))
			.endRest();

		rest()
		.path("/users/all-users")
		.get("/{page}/{size}")
		.route()
		.process(new AuthProcess("SCR-USR_READ"))
		.process(ex->{

			System.out.println(ex.getIn().getHeader("user"));
			
			UserFilter filter = new UserFilter();
			filter.setPage(ex.getIn().getHeader("page", Integer.class));
			filter.setSize(ex.getIn().getHeader("size", Integer.class));

			ex.getMessage().setBody(ResponseBuilder.success(service.getAllUsers(filter)));
		})
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.endRest();

		rest()
		.path("/users")
		.post("/create")
		.type(UserCreateCommand.class)
		.route()
		.process(new AuthProcess("SCR-USR_ADD"))
		.process(e -> {
			e.getMessage().setBody(
					ResponseBuilder.success(
							service.create(e.getIn().getBody(UserCreateCommand.class))));
		})
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.endRest();

		rest()
		.path("/users")
		.put("/update")
		.type(UserUpdateCommand.class)
		.route()
		.process(new AuthProcess("SCR-USR_EDIT"))
		.process(e -> {
			e.getMessage().setBody(
					ResponseBuilder.success(
							service.update(e.getIn().getBody(UserUpdateCommand.class))));
		})
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.endRest();

		rest()
		.path("/users")
		.delete("/delete")
		.type(UserDeleteCommand.class)
		.route()
		.process(new AuthProcess("SCR-USR_DELETE"))
		.process(e -> {
			e.getMessage().setBody(
					ResponseBuilder.success(
							service.delete(e.getIn().getBody(UserDeleteCommand.class))));
		})
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.endRest();

		rest()
		.consumes("application/json")
		.path("")
		.post("/login")
		.type(SignInCommand.class)
		.route().process(e->{

			UserData data = service.signIn(e.getIn().getBody(SignInCommand.class));

			Map<String, Object> response = new HashMap<>();
			response.put("status", data != null);

			if(data != null) {						
				
				long expiredTime = System.currentTimeMillis() + JWTConstant.EXPIRED;
				
				response.put("token", JWTTokenUtil.encode(new Gson().toJson(buildUserMap(data)), expiredTime));
				response.put("user", data);
				response.put("expiredTime", expiredTime);
			}

			e.getMessage().setBody(response);
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

		List<Map<String, String>> roles = new ArrayList<>();

		data.getRoles().forEach(role->{

			if(role.isEnabled()) {

				RoleData roleData = roleService.getByCode(role.getRoleCode());
				if(roleData != null) {

					roleData.getModules().forEach(mod->{

						if(mod.isRead()) {

							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_READ");
							roles.add(roleName);
						}

						if(mod.isAdd()) {

							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_ADD");
							roles.add(roleName);
						}

						if(mod.isEdit()) {

							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_EDIT");
							roles.add(roleName);
						}

						if(mod.isDelete()) {

							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_DELETE");
							roles.add(roleName);
						}

						if(mod.isPrint()) {

							Map<String, String> roleName = new HashMap<>();
							roleName.put("name", mod.getModuleCode().toUpperCase()+"_PRINT");
							roles.add(roleName);
						}
					});
				}
			}
		});

		user.put("roles", roles);
		
		List<CompanyStructureData> organizations = new ArrayList<>();
		
		if(Optional.ofNullable(data.getOrganizationCode()).isPresent()) {
			
			organizations.addAll(csDriver.getAllStructure(data.getOrganizationCode()));
		}

		user.put("organizations", organizations);
		
		return user;
	}
}
