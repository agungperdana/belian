/**
 * 
 */
package com.kratonsolution.belian.production.svc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.effort.dm.TimeEntry;
import com.kratonsolution.belian.effort.dm.Timesheet;
import com.kratonsolution.belian.effort.dm.TimesheetRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WorkingTimesheetService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private TimesheetRepository repository;
	
	@Secured("ROLE_WORKING_TIMESHEET_READ")
	public int getSize()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Secured("ROLE_WORKING_TIMESHEET_READ")
	public int getSize(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return getSize();

		return repository.count(utils.getOrganizationIds(),key).intValue();
	}
	
	@Secured("ROLE_WORKING_TIMESHEET_READ")
	public Timesheet findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_WORKING_TIMESHEET_READ")
	public List<Timesheet> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_WORKING_TIMESHEET_READ")
	public List<Timesheet> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Secured("ROLE_WORKING_TIMESHEET_READ")
	public List<Timesheet> findAll(int pageIndex,int pageSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);
		
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds(),key);
	}
	
	@Secured("ROLE_WORKING_TIMESHEET_CREATE")
	public void add(Timesheet timesheet)
	{
		repository.save(timesheet);
	}
	
	@Secured("ROLE_WORKING_TIMESHEET_UPDATE")
	public void edit(Timesheet timesheet,Collection<TimeEntry> entrys)
	{
		timesheet.getTimeEntrys().clear();
		repository.saveAndFlush(timesheet);
		
		timesheet.getTimeEntrys().addAll(entrys);
		repository.saveAndFlush(timesheet);
		
	}
	
	@Secured("ROLE_WORKING_TIMESHEET_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
