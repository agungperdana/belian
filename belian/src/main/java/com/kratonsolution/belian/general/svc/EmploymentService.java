/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.Employment;
import com.kratonsolution.belian.general.dm.EmploymentRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EmploymentService
{
	@Autowired
	private EmploymentRepository repository;
		
	@Secured("ROLE_EMPLOYMENT_READ")
	public Employment findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_EMPLOYMENT_CREATE")
	public void add(Employment geographic)
	{
		geographic.setId(UUID.randomUUID().toString());
		repository.save(geographic);
	}
	
	@Secured("ROLE_EMPLOYMENT_UPDATE")
	public void edit(Employment geographic)
	{
		repository.saveAndFlush(geographic);
	}
	
	@Secured("ROLE_EMPLOYMENT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_EMPLOYMENT_READ")
	public List<Employment> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
