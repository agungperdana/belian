
package com.kratonsolution.belian.security.impl.svc;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.kratonsolution.belian.security.impl.dm.Module;
import com.kratonsolution.belian.security.impl.dm.ModuleEventListener;
import com.kratonsolution.belian.security.impl.dm.ModuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@AllArgsConstructor
@Service
@Transactional(rollbackFor=Exception.class)
public class ModuleService
{
	private ModuleRepository repository;

	private Set<ModuleEventListener> listeners;
	
	@Secured("ROLE_MODULE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Module getOne(String id)
	{
		return repository.getOne(id);
	}
	
	@Secured("ROLE_MODULE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Module> findAll()
	{
		return repository.findAll(Sort.by(Sort.Direction.ASC,"code"));
	}
	
	@Secured("ROLE_MODULE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Module> findAll(int pageindex,int itemSize)
	{
		return repository.findAll(PageRequest.of(pageindex, itemSize, Sort.by(Direction.ASC, "code"))).getContent();
	}
	
	@Secured("ROLE_MODULE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Module> findAll(int pageindex, int itemSize, String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageindex, itemSize);
		else
			return repository.findAll(PageRequest.of(pageindex, itemSize),key);
	}
	
	@Secured("ROLE_MODULE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_MODULE_READ")
	public int size(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return size();
		else
			return repository.count(key).intValue();
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
		
		repository.deleteById(id);
	}
}
