/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.hr.dm.EmploymentApplication;
import com.kratonsolution.belian.hr.dm.EmploymentApplicationRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackOn=Exception.class)
public class EmploymentApplicationService
{
	@Autowired
	private EmploymentApplicationRepository repository;
	
	@Secured("ROLE_EMPYAPP_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_EMPYAPP_READ")
	public EmploymentApplication findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_EMPYAPP_READ")
	public List<EmploymentApplication> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_EMPYAPP_READ")
	public List<EmploymentApplication> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_EMPYAPP_CREATE")
	public void add(EmploymentApplication application)
	{
		application.setId(UUID.randomUUID().toString());
		repository.save(application);
	}
	
	@Secured("ROLE_EMPYAPP_UPDATE")
	public void edit(EmploymentApplication application)
	{
		repository.saveAndFlush(application);
	}
	
	@Secured("ROLE_EMPYAPP_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_EMPYAPP_READ")
	public List<EmploymentApplication> findAllByStatusType(EmploymentApplication.StatusType statusType)
	{
		return repository.findAllByStatusType(statusType);
	}
	
}
