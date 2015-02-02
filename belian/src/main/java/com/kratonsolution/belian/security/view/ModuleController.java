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

import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.ModuleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class ModuleController
{
	@Autowired
	private ModuleRepository repository;
		
	@Secured("ROLE_MODULE_READ")
	public Module findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_MODULE_READ")
	public List<Module> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_MODULE_READ")
	public List<Module> findAll(int pageindex,int itemSize)
	{
		return repository.findAll(new PageRequest(pageindex, itemSize)).getContent();
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
		repository.delete(id);
	}
}
