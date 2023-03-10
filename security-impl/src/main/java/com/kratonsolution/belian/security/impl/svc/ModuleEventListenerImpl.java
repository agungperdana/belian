
package com.kratonsolution.belian.security.impl.svc;

import java.util.Iterator;
import java.util.UUID;

import com.kratonsolution.belian.security.impl.dm.AccessRole;
import com.kratonsolution.belian.security.impl.dm.Module;
import com.kratonsolution.belian.security.impl.dm.ModuleEventListener;
import com.kratonsolution.belian.security.impl.dm.Role;
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
public class ModuleEventListenerImpl implements ModuleEventListener
{
	private RoleService roleService;

	@Override
	public void fireModuleAdded(Module module)
	{
		if(module != null)
		{
			for(Role role:roleService.findAll())
			{
				AccessRole accessRole = new AccessRole();
				accessRole.setId(UUID.randomUUID().toString());
				accessRole.setModule(module);
				accessRole.setRole(role);
				
				role.getAccesses().add(accessRole);
				
				roleService.edit(role);
			}
		}
	}

	@Override
	public void fireModuleRemoved(String id)
	{
		for(Role role:roleService.findAll())
		{
			Iterator<AccessRole> iterator = role.getAccesses().iterator();
			while (iterator.hasNext())
			{
				AccessRole accessRole = (AccessRole) iterator.next();
				if(accessRole.getModule().getId().equals(id))
				{
					role.getAccesses().remove(accessRole);
					accessRole.setModule(null);
					accessRole.setRole(null);
					break;
				}
			}
			
			roleService.edit(role);
		}
	}
}