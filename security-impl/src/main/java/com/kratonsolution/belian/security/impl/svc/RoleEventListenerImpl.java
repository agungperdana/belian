
package com.kratonsolution.belian.security.impl.svc;

import java.util.Iterator;
import java.util.UUID;

import com.kratonsolution.belian.security.impl.dm.Role;
import com.kratonsolution.belian.security.impl.dm.RoleEventListener;
import com.kratonsolution.belian.security.impl.dm.User;
import com.kratonsolution.belian.security.impl.dm.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@AllArgsConstructor
@Service
@Transactional(rollbackFor=Exception.class)
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
