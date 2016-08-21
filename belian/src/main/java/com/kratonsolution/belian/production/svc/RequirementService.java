/**
 * 
 */
package com.kratonsolution.belian.production.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.effort.dm.RequirementRepository;
import com.kratonsolution.belian.order.dm.Requirement;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RequirementService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private RequirementRepository repository;
	
	@Secured("ROLE_REQUIREMENT_READ")
	public int size()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Secured("ROLE_REQUIREMENT_READ")
	public int size(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganizationIds(),key).intValue();
	}
	
	@Secured("ROLE_REQUIREMENT_READ")
	public Requirement findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_REQUIREMENT_READ")
	public List<Requirement> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_REQUIREMENT_READ")
	public List<Requirement> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Secured("ROLE_REQUIREMENT_READ")
	public List<Requirement> findAll(int pageIndex,int pageSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);
		
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds(),key);
	}
	
	@Secured("ROLE_REQUIREMENT_CREATE")
	public void add(Requirement sales)
	{
		repository.save(sales);
	}
	
	@Secured("ROLE_REQUIREMENT_UPDATE")
	public void edit(Requirement sales)
	{
		repository.saveAndFlush(sales);
	}
	
	@Secured("ROLE_REQUIREMENT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
