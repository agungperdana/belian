package com.kratonsolution.belian.module.impl.application;

import java.util.List;
import java.util.UUID;

import com.kratonsolution.belian.module.impl.orm.Module;
import com.kratonsolution.belian.module.impl.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 1.0.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ModuleServiceImpl
{
	@Autowired
	private ModuleRepository repository;

	@Secured("ROLE_MODULE_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Module findOne(String id)
	{
		return repository.getReferenceById(id);
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
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
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
	}

	@Secured("ROLE_MODULE_UPDATE")
	public void edit(Module module)
	{
		repository.save(module);
	}

	@Secured("ROLE_MODULE_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
}