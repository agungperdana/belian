package com.kratonsolution.belian.role.impl.application;

import com.kratonsolution.belian.role.impl.orm.Role;
import com.kratonsolution.belian.role.impl.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@AllArgsConstructor
@Service
@Transactional(rollbackFor=Exception.class)
public class RoleService
{
	private RoleRepository repository;

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
	public List<Role> findAll(int pageSize, int itemSize)
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
	}
	
	@Secured("ROLE_ACCESS_ROLE_UPDATE")
	public void edit(Role role)
	{		
		repository.saveAndFlush(role);
	}
	
	@Secured("ROLE_ACCESS_ROLE_DELETE")
	public void delete(String id)
	{
		Role role = repository.getOne(id);
		if(role != null && !role.isUndeleteable())
			repository.deleteById(id);
	}
}
