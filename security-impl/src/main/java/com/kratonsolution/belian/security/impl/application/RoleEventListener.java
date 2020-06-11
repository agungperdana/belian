/**
 * 
 */
package com.kratonsolution.belian.security.impl.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.security.api.RoleEvent;
import com.kratonsolution.belian.security.api.UserRoleData;
import com.kratonsolution.belian.security.api.application.UpdateUserCommand;
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
		
		userService.getAllUsers().forEach(user -> {
			
			UpdateUserCommand command = new UpdateUserCommand();
			command.setEmail(user.getEmail());
			command.setEnabled(user.isEnabled());
			command.setName(user.getName());
			command.getRoles().addAll(user.getRoles());
			
			UserRoleData userRole = new UserRoleData();
			userRole.setRoleCode(event.getPayload().getData().getCode());
			
			command.getRoles().add(userRole);
			
			userService.update(command);
			
			log.info("Update user {new role created by user}");
		});
	}
}
