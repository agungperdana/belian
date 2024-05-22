package com.kratonsolution.belian.workefforts.svc;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.dm.OrderItemRepository;
import com.kratonsolution.belian.workefforts.dm.RateType;
import com.kratonsolution.belian.workefforts.dm.TimeEntry;
import com.kratonsolution.belian.workefforts.dm.WorkEffort;
import com.kratonsolution.belian.workefforts.dm.WorkEffortPartyAssignment;
import com.kratonsolution.belian.workefforts.dm.WorkEffortPartyRate;
import com.kratonsolution.belian.workefforts.dm.WorkEffortPartyRateRepository;
import com.kratonsolution.belian.workefforts.dm.WorkEffortRepository;
import com.kratonsolution.belian.workefforts.dm.WorkOrderItemFulfillment;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WorkEffortService extends AbstractService
{
	@Autowired
	private WorkEffortRepository repository;
	
	@Autowired
	private WorkEffortPartyRateRepository rateRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public int size(String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.count(key).intValue();
		else
			return size();
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public WorkEffort findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public List<WorkEffort> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public List<WorkEffort> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public List<WorkEffort> findAll(int pageIndex,int pageSize,String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(PageRequest.of(pageIndex, pageSize),key);
		else
			return findAll(pageIndex, pageSize);
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<WorkEffort> findAllUninvoiced()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAllUninvoiced(utils.getOrganization().getId());
	}
	
	@Secured("ROLE_WORK_EFFORT_CREATE")
	public void add(WorkEffort item)
	{
		repository.save(item);
		
		for(WorkOrderItemFulfillment fulfillment:item.getItemFulfillments())
		{
			OrderItem orderItem = orderItemRepo.findById(fulfillment.getOrderItem().getId()).orElse(null);
			if(orderItem != null)
			{
				orderItem.setWorkeffort(true);
				orderItemRepo.saveAndFlush(orderItem);
			}
		}
	}
	
	@Secured("ROLE_WORK_EFFORT_UPDATE")
	public void edit(WorkEffort item)
	{
		repository.saveAndFlush(item);
	}
	
	@Secured("ROLE_WORK_EFFORT_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public BigDecimal getTotalCost(WorkEffort effort)
	{
		BigDecimal cost = BigDecimal.ZERO;
		
		if(effort != null && effort.getActualStart() != null)
		{
			for(WorkEffortPartyAssignment assignment:effort.getAssignments())
			{
				List<WorkEffortPartyRate> rates = rateRepo.findAll(assignment.getParty().getId(), RateType.REGULAR_BILLING, new Date(effort.getActualEnd().getTime()));
				if(!rates.isEmpty())
				{
					for(TimeEntry entry:effort.getTimeEntrys())
					{
						if(entry.getTimeSheet() != null && entry.getTimeSheet().getWorker().getId().equals(assignment.getParty().getId()))
							cost = cost.add(rates.get(0).getRate().multiply(entry.getHours()));
					}
				}
			}
		}
		
		return cost;
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public BigDecimal getTotalHours(WorkEffort effort)
	{
		BigDecimal hours = BigDecimal.ZERO;
		
		if(effort != null && effort.getActualStart() != null)
		{
			for(WorkEffortPartyAssignment assignment:effort.getAssignments())
			{
				List<WorkEffortPartyRate> rates = rateRepo.findAll(assignment.getParty().getId(), RateType.REGULAR_BILLING, new Date(effort.getActualEnd().getTime()));
				if(!rates.isEmpty())
				{
					for(TimeEntry entry:effort.getTimeEntrys())
					{
						if(entry.getTimeSheet() != null && entry.getTimeSheet().getWorker().getId().equals(assignment.getParty().getId()))
							hours = hours.add(entry.getHours());
					}
				}
			}
		}
		
		return hours;
	}
}
