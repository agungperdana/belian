package com.kratonsolution.belian.access.user.impl.application;

import java.util.Iterator;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.access.role.impl.orm.Role;
import com.kratonsolution.belian.access.role.impl.application.RoleEventListener;
import com.kratonsolution.belian.access.user.impl.orm.User;
import com.kratonsolution.belian.access.user.impl.orm.UserRole;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class RoleEventListenerImpl implements RoleEventListener
{
	private UserService service;

	@Override
	public void fireRoleRemoved(String id)
	{
		for(User user:service.findAll())
		{
			Iterator<UserRole> iterator = user.getRoles().iterator();
			while (iterator.hasNext())
			{
				UserRole userRole = (UserRole) iterator.next();
				if(userRole.getRole().getId().equals(id))
				{
					user.getRoles().remove(userRole);
					userRole.setRole(null);
					userRole.setUser(null);
					break;
				}
			}
			
			service.edit(user);
		}
	}

	@Override
	public void fireRoleAdded(Role role)
	{
		for(User user:service.findAll())
		{
			UserRole userRole = new UserRole();
			userRole.setId(UUID.randomUUID().toString());
			userRole.setRole(role);
			userRole.setUser(user);
			
			user.getRoles().add(userRole);
			
			service.edit(user);
		}
	}
}
