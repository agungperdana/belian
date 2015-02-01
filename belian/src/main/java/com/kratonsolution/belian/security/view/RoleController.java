/**
 * 
 */
package com.kratonsolution.belian.security.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.security.dm.ModuleEditor;
import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.dm.RoleRepository;
import com.kratonsolution.belian.security.dm.service.RoleService;

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
	private RoleService service;
	
	@Autowired
	private ModuleEditor moduleEditor;
	
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
	}
	
	@Secured("ROLE_RLE_UPDATE")
	public void edit(Role role)
	{		
		repository.save(role);
	}
	
	@Secured("ROLE_RLE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
