/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.dm.ContainerRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class ContainerService
{
	@Autowired
	private ContainerRepository repository;
	
	@Secured("ROLE_CONTAINER_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_CONTAINER_READ")
	public Container findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CONTAINER_READ")
	public List<Container> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CONTAINER_READ")
	public List<Container> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_CONTAINER_CREATE")
	public void add(Container container)
	{
		repository.save(container);
	}
	
	@Secured("ROLE_CONTAINER_UPDATE")
	public void edit(Container container)
	{
		repository.save(container);
	}
	
	@Secured("ROLE_CONTAINER_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
