
package com.kratonsolution.belian.requirement.svc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.AbstractService;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.requirement.dm.WorkRequirement;
import com.kratonsolution.belian.requirement.dm.WorkRequirementRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WorkRequirementService extends AbstractService
{
	@Autowired
	private WorkRequirementRepository repository;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Secured("ROLE_WORK_REQUIREMENT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_READ")
	public int size(String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.count(key).intValue();
		else
			return size();
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_READ")
	public WorkRequirement findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_READ")
	public List<WorkRequirement> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_READ")
	public List<WorkRequirement> findAllOpen()
	{
		Vector<StatusType> params = new Vector<>();
		params.add(StatusType.CANCELED);
		params.add(StatusType.DONE);
		
		return repository.findAllOpen(params);
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_READ")
	public List<WorkRequirement> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_READ")
	public List<WorkRequirement> findAll(int pageIndex,int pageSize,String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(PageRequest.of(pageIndex, pageSize),key);
		else
			return findAll(pageIndex, pageSize);
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<WorkRequirement> findAllForWorkEfforts()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<WorkRequirement>();
		
		return repository.findAllForWorkEfforts(utils.getOrganization().getId());
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_CREATE")
	public void add(WorkRequirement item)
	{
		repository.save(item);
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_UPDATE")
	public void edit(WorkRequirement item)
	{
		repository.saveAndFlush(item);
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
	
	@Secured("ROLE_WORK_REQUIREMENT_DELETE")
	public void delete(Collection<String> ids)
	{
		if(ids != null)
		{
			for(String id:ids)
				repository.deleteById(id);
		}
	}
}
