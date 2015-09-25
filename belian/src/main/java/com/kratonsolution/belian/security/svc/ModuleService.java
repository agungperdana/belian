/**
 * 
 */
package com.kratonsolution.belian.security.svc;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.security.dm.Module;
import com.kratonsolution.belian.security.dm.ModuleEventListener;
import com.kratonsolution.belian.security.dm.ModuleRepository;
import com.kratonsolution.belian.security.dm.RoleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class ModuleService
{
	@Autowired
	private ModuleRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private Set<ModuleEventListener> listeners;
	
	@Secured("ROLE_MODULE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Module findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_MODULE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Module> findAll()
	{
		return repository.findAll(new Sort(Sort.Direction.ASC,"code"));
	}
	
	@Secured("ROLE_MODULE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
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

		for(ModuleEventListener listener:listeners)
			listener.fireModuleAdded(module);
	}
	
	@Secured("ROLE_MODULE_UPDATE")
	public void edit(Module module)
	{
		repository.save(module);
	}
	
	@Secured("ROLE_MODULE_DELETE")
	public void delete(String id)
	{
		for(ModuleEventListener listener:listeners)
			listener.fireModuleRemoved(id);
		
		repository.delete(id);
	}
}
