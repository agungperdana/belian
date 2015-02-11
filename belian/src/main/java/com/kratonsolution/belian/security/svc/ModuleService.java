/**
 * 
 */
package com.kratonsolution.belian.security.svc;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

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
public class ModuleService
{
	@Autowired
	private ModuleRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
		
	@Secured("ROLE_MODULE_READ")
	public Module findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_MODULE_READ")
	public List<Module> findAll()
	{
		return repository.findAllByDeleted(false);
	}
	
	@Secured("ROLE_MODULE_READ")
	public List<Module> findAll(int pageindex,int itemSize)
	{
		return repository.findAllByDeleted(false,new PageRequest(pageindex, itemSize));
	}
	
	@Secured("ROLE_MODULE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_MODULE_CREATE")
	public void add(Module module)
	{
		module.setId(UUID.randomUUID().toString());
		repository.save(module);
	}
	
	@Secured("ROLE_MODULE_UPDATE")
	public void edit(Module module)
	{
		repository.save(module);
	}
	
	@Secured("ROLE_MODULE_DELETE")
	public void delete(String id)
	{
		for(Role role:roleRepository.findAll())
		{
			Iterator<AccessRole> iterator = role.getAccesses().iterator();
			while (iterator.hasNext())
			{
				AccessRole accessRole = (AccessRole) iterator.next();
				if(accessRole.getModule() == null || accessRole.getModule().getId().equals(id))
					iterator.remove();
			}
			
			roleRepository.save(role);
			repository.delete(id);
		}
	}
}
