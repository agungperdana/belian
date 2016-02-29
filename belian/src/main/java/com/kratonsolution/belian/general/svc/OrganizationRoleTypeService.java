/**
 * 
 */
package com.kratonsolution.belian.general.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.OrganizationRole;
import com.kratonsolution.belian.general.dm.OrganizationRoleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationRoleTypeService
{	
	@Autowired
	private OrganizationRoleRepository repository;
		
	@Secured("ROLE_ORGROLETYPE_READ")
	public OrganizationRole findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_ORGROLETYPE_READ")
	public List<OrganizationRole> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ORGROLETYPE_READ")
	public List<OrganizationRole> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_ORGROLETYPE_CREATE")
	public void add(OrganizationRole partyrole)
	{
		repository.save(partyrole);
	}
	
	@Secured("ROLE_ORGROLETYPE_UPDATE")
	public void edit(OrganizationRole partyrole)
	{
		repository.saveAndFlush(partyrole);
	}
	
	@Secured("ROLE_ORGROLETYPE_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
