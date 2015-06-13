/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.hr.dm.PositionType;
import com.kratonsolution.belian.hr.dm.PositionTypeRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class PositionTypeService
{
	//todo
	
	@Autowired
	private PositionTypeRepository repository;
	
	@Secured("ROLE_POSITIONTYPE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_POSITIONTYPE_READ")
	public PositionType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_POSITIONTYPE_READ")
	public List<PositionType> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_POSITIONTYPE_READ")
	public List<PositionType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_POSITIONTYPE_CREATE")
	public void add(PositionType container)
	{
		container.setId(UUID.randomUUID().toString());
		repository.save(container);
	}
	
	@Secured("ROLE_POSITIONTYPE_UPDATE")
	public void edit(PositionType container)
	{
		repository.saveAndFlush(container);
	}
	
	@Secured("ROLE_POSITIONTYPE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
