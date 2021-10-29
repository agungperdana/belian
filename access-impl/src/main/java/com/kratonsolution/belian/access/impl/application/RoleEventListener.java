package com.kratonsolution.belian.access.impl.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.api.application.DeleteUserRoleCommand;
import com.kratonsolution.belian.access.api.application.RegisterNewUserRoleCommand;
import com.kratonsolution.belian.access.api.application.UpdateUserRoleCommand;
import com.kratonsolution.belian.access.api.application.UserService;
import com.kratonsolution.belian.common.application.EventSourceName;
import com.kratonsolution.belian.common.application.SystemEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Slf4j
@Service
@Transactional
public class RoleEventListener implements ApplicationListener<PayloadApplicationEvent<SystemEvent>>{

	@Autowired
	private UserService userService;

	@Override
	public void onApplicationEvent(PayloadApplicationEvent<SystemEvent> payload) {

		SystemEvent event = payload.getPayload();
		if(event != null && event.getSource().equals(EventSourceName.ACCESS_ROLE)) {

			if(event.getType().equals(SystemEvent.ADD)) {

				userService.getAllUsers().forEach(user -> {

					RegisterNewUserRoleCommand command = new RegisterNewUserRoleCommand();
					command.setUserName(user.getName());
					command.setRoleCode(event.getAsString(SystemEvent.PAYLOAD_CODE).get());
					command.setRoleName(event.getAsString(SystemEvent.PAYLOAD_NAME).get());

					userService.addNewUserRole(command);

					log.info("Update user, registering new role {}", command.getRoleName());
				});
			}
			else if(event.getType().equals(SystemEvent.UPDATE)) {

				userService.getAllUsers().forEach(user -> {

					UpdateUserRoleCommand command = new UpdateUserRoleCommand();
					command.setUserName(user.getName());
					command.setRoleCode(event.getAsString(SystemEvent.PAYLOAD_CODE).get());
					command.setRoleName(event.getAsString(SystemEvent.PAYLOAD_NAME).get());

					userService.updateUserRole(command);

					log.info("Update user, updating user_role {}", command.getRoleName());
				});
			}
			else if(event.getType().equals(SystemEvent.DELETE)) {

				userService.getAllUsers().forEach(user -> {

					DeleteUserRoleCommand command = new DeleteUserRoleCommand();
					command.setUserName(user.getName());
					command.setRoleCode(event.getAsString(SystemEvent.PAYLOAD_CODE).get());

					userService.deleteUserRole(command);

					log.info("Update user, deleting user_role {}", command.getRoleCode());
				});
			}
		}
	}
}
