
package com.kratonsolution.belian.workefforts.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.workefforts.dm.TimeEntry;
import com.kratonsolution.belian.workefforts.dm.TimeEntryRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TimeEntryService extends AbstractService
{
	@Autowired
	private TimeEntryRepository repository;
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public TimeEntry getOne(String id)
	{
		return repository.getOne(id);
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public List<TimeEntry> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_WORK_EFFORT_READ")
	public List<TimeEntry> findAll(String company)
	{
		return repository.findAll(company);
	}
	
	@Secured("ROLE_WORK_EFFORT_CREATE")
	public void add(TimeEntry item)
	{
		repository.save(item);
	}
	
	@Secured("ROLE_WORK_EFFORT_UPDATE")
	public void edit(TimeEntry item)
	{
		repository.saveAndFlush(item);
	}
	
	@Secured("ROLE_WORK_EFFORT_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
}
