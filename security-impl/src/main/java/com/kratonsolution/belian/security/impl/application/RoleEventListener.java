package com.kratonsolution.belian.security.impl.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.application.EventType;
import com.kratonsolution.belian.security.api.application.DeleteUserRoleCommand;
import com.kratonsolution.belian.security.api.application.RegisterNewUserRoleCommand;
import com.kratonsolution.belian.security.api.application.RoleEvent;
import com.kratonsolution.belian.security.api.application.UpdateUserRoleCommand;
import com.kratonsolution.belian.security.api.application.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Slf4j
@Service
public class RoleEventListener implements ApplicationListener<PayloadApplicationEvent<RoleEvent>>{

	@Autowired
	private UserService userService;

	@Override
	public void onApplicationEvent(PayloadApplicationEvent<RoleEvent> event) {

		if(event.getPayload().getType().equals(EventType.ADD)) {

			userService.getAllUsers().forEach(user -> {

				RegisterNewUserRoleCommand command = new RegisterNewUserRoleCommand();
				command.setUserName(user.getName());
				command.setRoleCode(event.getPayload().getData().getCode());
				command.setRoleName(event.getPayload().getData().getName());

				userService.addNewUserRole(command);

				log.info("Update user, registering new role {}", command.getRoleName());
			});
		}
		else if(event.getPayload().getType().equals(EventType.UPDATE)) {

			userService.getAllUsers().forEach(user -> {

				UpdateUserRoleCommand command = new UpdateUserRoleCommand();
				command.setUserName(user.getName());
				command.setRoleCode(event.getPayload().getData().getCode());
				command.setRoleName(event.getPayload().getData().getName());

				userService.updateUserRole(command);

				log.info("Update user, updating user_role {}", command.getRoleName());
			});
		}
		else if(event.getPayload().getType().equals(EventType.DELETE)) {

			userService.getAllUsers().forEach(user -> {

				DeleteUserRoleCommand command = new DeleteUserRoleCommand();
				command.setUserName(user.getName());
				command.setRoleCode(event.getPayload().getData().getCode());

				userService.deleteUserRole(command);

				log.info("Update user, deleting user_role {}", command.getRoleCode());
			});
		}
	}
}
