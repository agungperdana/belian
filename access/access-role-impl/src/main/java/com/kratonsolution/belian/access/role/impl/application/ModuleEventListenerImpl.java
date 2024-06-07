package com.kratonsolution.belian.access.role.impl.application;

import java.util.Iterator;
import java.util.UUID;

import com.kratonsolution.belian.access.module.impl.application.ModuleEventListener;
import com.kratonsolution.belian.access.role.impl.application.RoleService;
import com.kratonsolution.belian.access.role.impl.orm.Role;
import com.kratonsolution.belian.access.role.impl.orm.RoleModule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.access.module.impl.orm.Module;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
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
				RoleModule roleModule = new RoleModule();
				roleModule.setId(UUID.randomUUID().toString());
				roleModule.setModule(module);
				roleModule.setRole(role);
				
				role.getAccesses().add(roleModule);
				
				roleService.edit(role);
			}
		}
	}

	@Override
	public void fireModuleRemoved(String id)
	{
		for(Role role:roleService.findAll())
		{
			Iterator<RoleModule> iterator = role.getAccesses().iterator();
			while (iterator.hasNext())
			{
				RoleModule roleModule = (RoleModule) iterator.next();
				if(roleModule.getModule().getId().equals(id))
				{
					role.getAccesses().remove(roleModule);
					roleModule.setModule(null);
					roleModule.setRole(null);
					break;
				}
			}
			
			roleService.edit(role);
		}
	}
}
