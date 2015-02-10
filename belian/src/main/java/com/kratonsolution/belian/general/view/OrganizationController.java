/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.OrganizationRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class OrganizationController
{	
	@Autowired
	private OrganizationRepository repository;
		
	@Secured("ROLE_ORGANIZATION_READ")
	public Organization findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_ORGANIZATION_READ")
	public List<Organization> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_ORGANIZATION_READ")
	public List<Organization> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_ORGANIZATION_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_ORGANIZATION_CREATE")
	public void add(Organization organization)
	{
		organization.setId(UUID.randomUUID().toString());
		repository.save(organization);
	}
	
	@Secured("ROLE_ORGANIZATION_UPDATE")
	public void edit(Organization organization)
	{
		repository.save(organization);
	}
	
	@Secured("ROLE_ORGANIZATION_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
