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

import com.google.common.base.Strings;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.dm.OrganizationRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationService
{	
	@Autowired
	private OrganizationRepository repository;
	
	@Autowired
	private PartyService service;

	@Secured({"ROLE_ORGANIZATION_READ","ROLE_SYSTEM_READ"})
	public Organization findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}

	@Secured({"ROLE_ORGANIZATION_READ","ROLE_SYSTEM_READ"})
	public List<Organization> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_ORGANIZATION_READ","ROLE_SYSTEM_READ"})
	public List<Organization> findAllNotIn(List<String> ids)
	{
		if(ids != null && !ids.isEmpty())
			return repository.findAllNot(ids);
		
		return repository.findAll();
	}

	@Secured({"ROLE_ORGANIZATION_READ","ROLE_SYSTEM_READ"})
	public List<Organization> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}

	@Secured("ROLE_ORGANIZATION_READ")
	public List<Organization> findAllByIndustryType(IndustrySegmentation type)
	{
		return repository.findAllByType(type);
	}

	@Secured("ROLE_ORGANIZATION_READ")
	public List<Organization> findAllByRolesTypeName(String roleName)
	{
		return null;
	}

	@Secured("ROLE_ORGANIZATION_READ")
	public List<Organization> findAllByRelationshipsRelationshipTypeName(String name)
	{
		return null;
	}

	@Secured({"ROLE_ORGANIZATION_READ","ROLE_SYSTEM_READ"})
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
		repository.saveAndFlush(organization);
	}

	@Secured("ROLE_ORGANIZATION_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
