/**
 * 
 */
package com.kratonsolution.belian.global.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.Approveable;
import com.kratonsolution.belian.global.dm.ApproveableRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ApproveableService
{	
	@Autowired
	private ApproveableRepository repository;

	@Secured("ROLE_APPROVEABLE_READ")
	public Approveable findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_APPROVEABLE_READ")
	public List<Approveable> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_APPROVEABLE_READ")
	public List<Approveable> findAllNew()
	{
		return repository.findAllNew();
	}

	@Secured("ROLE_APPROVEABLE_READ")
	public List<Approveable> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}

	@Secured("ROLE_APPROVEABLE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}

	@Secured("ROLE_APPROVEABLE_CREATE")
	public void add(Approveable companyStructure)
	{
		repository.save(companyStructure);
	}

	@Secured("ROLE_APPROVEABLE_UPDATE")
	public void edit(Approveable companyStructure)
	{
		repository.saveAndFlush(companyStructure);
	}

	@Secured("ROLE_APPROVEABLE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
