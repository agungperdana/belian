/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.dm.ContainerRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ContainerService
{
	@Autowired
	private ContainerRepository repository;
	
	@Secured("ROLE_FACILITY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public Container findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
		
		return null;
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public Container byName(String name)
	{
		if(Strings.isNullOrEmpty(name))
			return null;
	
		return repository.findOneByName(name);
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public List<Container> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_FACILITY_READ")
	public List<Container> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_FACILITY_CREATE")
	public void add(Container container)
	{
		container.setId(UUID.randomUUID().toString());
		repository.save(container);
	}
	
	@Secured("ROLE_FACILITY_UPDATE")
	public void edit(Container container)
	{
		repository.saveAndFlush(container);
	}
	
	@Secured("ROLE_FACILITY_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
