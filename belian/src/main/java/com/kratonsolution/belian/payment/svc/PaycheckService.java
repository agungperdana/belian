/**
 * 
 */
package com.kratonsolution.belian.payment.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.payment.dm.Paycheck;
import com.kratonsolution.belian.payment.dm.PaycheckRepository;
import com.kratonsolution.belian.production.dm.TimeEntry;
import com.kratonsolution.belian.production.dm.TimeEntryRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PaycheckService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private PaycheckRepository repository;
	
	@Autowired
	private TimeEntryRepository timeEntryRepo;
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PAYCHECK_READ")
	public int size()
	{
		if(utils.getOrganizationIds() == null && utils.getOrganizationIds().isEmpty())
			return 0;

		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PAYCHECK_READ")
	public int size(String key)
	{
		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganizationIds(),key).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PAYCHECK_READ")
	public Paycheck findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PAYCHECK_READ")
	public List<Paycheck> findAll()
	{
		if(utils.getOrganizationIds() == null && utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
		
		return repository.findAll(utils.getOrganizationIds());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PAYCHECK_READ")
	public List<Paycheck> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() == null && utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PAYCHECK_READ")
	public List<Paycheck> findAll(int pageIndex,int pageSize,String key)
	{
		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds(),key);
	}
	
	@Secured("ROLE_PAYCHECK_CREATE")
	public void add(Paycheck check)
	{
		List<TimeEntry> entrys = timeEntryRepo.findAllUnpaid(check.getEmployment().getEmployee().getParty().getId(), check.getStart(), check.getEnd());
		if(entrys.isEmpty())
			throw new RuntimeException(check.getEmployment().getEmployee().getParty().getName()+" doesnot have and payable time entry.");

		for(TimeEntry entry:entrys)
		{
			entry.setPaid(true);
			timeEntryRepo.saveAndFlush(entry);
		}
		
		repository.save(check);
	}
	
	@Secured("ROLE_PAYCHECK_UPDATE")
	public void edit(Paycheck check)
	{
		repository.saveAndFlush(check);
	}
	
	@Secured("ROLE_PAYCHECK_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
