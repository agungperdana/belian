/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.dm.EmploymentRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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
