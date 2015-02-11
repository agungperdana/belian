/**
 * 
 */
package com.kratonsolution.belian.security.svc;

import java.util.Iterator;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.RoleAddedListener;
import com.kratonsolution.belian.security.dm.RoleRemovedListener;
import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.security.dm.UserRepository;
import com.kratonsolution.belian.security.dm.UserRole;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class RoleEventListener implements RoleAddedListener,RoleRemovedListener
{
	@Autowired
	private UserRepository repository;
	
	@Override
	public void fireRoleRemoved(Role role)
	{
		for(User user:repository.findAll())
		{
			Iterator<UserRole> roles = user.getRoles().iterator();
			while (roles.hasNext())
			{
				UserRole userRole = (UserRole) roles.next();
				if(userRole.getRole().getId().equals(role.getId()))
					roles.remove();
			}
			
			repository.save(user);
		}
	}

	@Override
	public void fireRoleAdded(Role role)
	{
		for(User user:repository.findAll())
		{
			UserRole userRole = new UserRole();
			userRole.setId(UUID.randomUUID().toString());
			userRole.setRole(role);
			
			user.getRoles().add(userRole);
			repository.save(user);
		}
	}
}
