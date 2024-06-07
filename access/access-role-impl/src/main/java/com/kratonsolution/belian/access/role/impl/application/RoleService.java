package com.kratonsolution.belian.access.role.impl.application;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.access.module.impl.repository.ModuleRepository;
import com.kratonsolution.belian.access.role.impl.orm.Role;
import com.kratonsolution.belian.access.role.impl.repository.RoleRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class RoleService
{
	private RoleRepository repository;
	
	private ModuleRepository moduleRepository;
	
	private List<RoleEventListener> listeners;
	
	@Secured("ROLE_ACCESS_ROLE_READ")
	public Role findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_ACCESS_ROLE_READ")
	public List<Role> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ACCESS_ROLE_READ")
	public List<Role> findAll(int pageSize,int itemSize)
	{
		return repository.findAll(PageRequest.of(pageSize, itemSize)).getContent();
	}
	
	@Secured("ROLE_ACCESS_ROLE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_ACCESS_ROLE_CREATE")
	public void add(Role role)
	{
		repository.save(role);
	
		for(RoleEventListener listener:listeners)
			listener.fireRoleAdded(role);
	}
	
	@Secured("ROLE_ACCESS_ROLE_UPDATE")
	public void edit(Role role)
	{		
		repository.saveAndFlush(role);
	}
	
	@Secured("ROLE_ACCESS_ROLE_DELETE")
	public void delete(String id)
	{
		for(RoleEventListener listener:listeners)
			listener.fireRoleRemoved(id);

		Role role = repository.findById(id).orElse(null);
		if(role != null && !role.isUndeleteable())
			repository.deleteById(id);
	}
}
