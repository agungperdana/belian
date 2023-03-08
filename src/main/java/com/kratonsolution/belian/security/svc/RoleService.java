
package com.kratonsolution.belian.security.svc;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.RoleEventListener;
import com.kratonsolution.belian.security.dm.RoleRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@AllArgsConstructor
@Service
@Transactional(rollbackFor=Exception.class)
public class RoleService
{
	private RoleRepository repository;

	private List<RoleEventListener> listeners;
	
	@Secured("ROLE_ACCESS_ROLE_READ")
	public Role getOne(String id)
	{
		return repository.getOne(id);
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

		Role role = repository.getOne(id);
		if(role != null && !role.isUndeleteable())
			repository.deleteById(id);
	}
}
