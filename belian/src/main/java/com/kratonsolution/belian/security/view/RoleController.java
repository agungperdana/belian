/**
 * 
 */
package com.kratonsolution.belian.security.view;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.kratonsolution.belian.security.dm.AccessRole;
import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.RoleAddedListener;
import com.kratonsolution.belian.security.dm.RoleRemovedListener;
import com.kratonsolution.belian.security.dm.RoleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class RoleController
{
	@Autowired
	private RoleRepository repository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private List<RoleAddedListener> addListeners;
	
	@Autowired
	private List<RoleRemovedListener> removeListeners;
	
	@Secured("ROLE_RLE_READ")
	public Role findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_RLE_READ")
	public List<Role> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_RLE_READ")
	public List<Role> findAll(int pageSize,int itemSize)
	{
		return repository.findAll(new PageRequest(pageSize, itemSize)).getContent();
	}
	
	@Secured("ROLE_RLE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_RLE_CREATE")
	public void add(Role role)
	{
		repository.save(role);
		
		for(RoleAddedListener listener:addListeners)
			listener.fireRoleAdded(role);
	}
	
	@Secured("ROLE_RLE_UPDATE")
	public void edit(Role role)
	{		
		repository.save(role);
	}
	
	@Secured("ROLE_RLE_DELETE")
	public void delete(String id)
	{
		for(RoleRemovedListener listener:removeListeners)
			listener.fireRoleRemoved(repository.findOne(id));
		
		repository.delete(id);
	}
	
	@Secured("ROLE_RLE_CREATE")
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
	
	@Secured("ROLE_RLE_UPDATE")
	public Role prepareEdit(String id)
	{
		if(!Strings.isNullOrEmpty(id))
		{
			Role role = repository.findOne(id);
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
