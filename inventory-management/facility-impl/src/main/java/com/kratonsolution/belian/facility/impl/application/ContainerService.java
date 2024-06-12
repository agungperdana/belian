package com.kratonsolution.belian.facility.impl.application;

import java.util.List;
import java.util.UUID;

import com.kratonsolution.belian.facility.impl.orm.Container;
import com.kratonsolution.belian.facility.impl.repository.ContainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class ContainerService
{
	private ContainerRepository repository;
	
	@Secured("ROLE_FACILITY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public Container findById(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findById(id).orElse(null);
		
		return null;
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public Container byName(String name)
	{
		if(Strings.isNullOrEmpty(name))
			return null;
	
		return repository.findByName(name);
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public List<Container> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_FACILITY_READ")
	public List<Container> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
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
		repository.deleteById(id);
	}
}
