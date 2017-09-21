/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
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
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_POSITION_READ")
	public int size()
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.count(utils.getOrganizationIds()).intValue();
	
		return 0;
	}
	
	@Secured("ROLE_POSITION_READ")
	public int size(String key)
	{
		if(!Strings.isNullOrEmpty(key))
			repository.count(utils.getOrganizationIds(),key);

		return size();
	}
	
	@Secured("ROLE_POSITION_READ")
	public Position findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_POSITION_READ")
	public List<Position> findAll()
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.findAll(utils.getOrganizationIds());

		return new ArrayList<>();
	}
		
	@Secured("ROLE_POSITION_READ")
	public List<Position> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() != null && !utils.getOrganizationIds().isEmpty())
			return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	
		return new ArrayList<>();
	}
	
	@Secured("ROLE_POSITION_READ")
	public List<Position> findAll(int pageIndex,int pageSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex,pageSize);
	
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds(),key);
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
