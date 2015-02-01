/**
 * 
 */
package com.kratonsolution.belian.security.dm.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.kratonsolution.belian.security.dm.AccessRole;
import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.RoleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class RoleService
{
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role prepareAdd()
	{
		Role role = new Role();
		for(Module module:moduleRepository.findAll())
		{
			AccessRole accessRole = new AccessRole();
			accessRole.setModule(module);
			
			role.getAccesses().add(accessRole);
		}
		
		return role;
	}
	
	public Role prepareEdit(String id)
	{
		if(!Strings.isNullOrEmpty(id))
		{
			Role role = roleRepository.findOne(id);
			if(role != null)
			{
				for(Module module:moduleRepository.findAll())
				{
					boolean exist = false;
					for(AccessRole access:role.getAccesses())
					{						
						if(access.getModule().getId().equals(module.getId()))
						{
							exist = true;
							break;
						}
					}
					
					if(!exist)
					{
						AccessRole access = new AccessRole();
						access.setId(UUID.randomUUID().toString());
						access.setModule(module);
						
						role.getAccesses().add(access);
					}
				}
			}
			
			return role;
		}

		return new Role();
	}
}
