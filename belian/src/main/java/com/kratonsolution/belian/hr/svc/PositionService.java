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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.hr.dm.PositionRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PositionService
{
	@Autowired
	private PositionRepository repository;
	
	@Secured("ROLE_POSITION_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_POSITION_READ")
	public Position findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_POSITION_READ")
	public List<Position> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_POSITION_READ")
	public List<Position> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_POSITION_CREATE")
	public void add(Position container)
	{
		container.setId(UUID.randomUUID().toString());
		repository.save(container);
	}
	
	@Secured("ROLE_POSITION_UPDATE")
	public void edit(Position container)
	{
		repository.saveAndFlush(container);
	}
	
	@Secured("ROLE_POSITION_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_POSITION_READ")
	public List<Position> findAllNotEqual(String positionId)
	{
		return repository.findAllNotEqual(positionId);
	}
}
