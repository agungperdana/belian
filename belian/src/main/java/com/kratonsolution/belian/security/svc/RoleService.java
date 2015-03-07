/**
 * 
 */
package com.kratonsolution.belian.security.svc;

import java.util.List;
import java.util.UUID;

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
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RoleService
{
	@Autowired
	private RoleRepository repository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private List<RoleEventListener> listeners;
	
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
		role.setId(UUID.randomUUID().toString());
		repository.save(role);
	
		for(RoleEventListener listener:listeners)
			listener.fireRoleAdded(role);
	}
	
	@Secured("ROLE_RLE_UPDATE")
	public void edit(Role role)
	{		
		repository.saveAndFlush(role);
	}
	
	@Secured("ROLE_RLE_DELETE")
	public void delete(String id)
	{
		for(RoleEventListener listener:listeners)
			listener.fireRoleRemoved(id);
		
		repository.delete(id);
	}
}
