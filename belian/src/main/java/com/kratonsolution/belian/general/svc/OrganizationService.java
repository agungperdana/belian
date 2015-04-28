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

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.OrganizationRepository;
import com.kratonsolution.belian.general.dm.Organization.IndustryType;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationService
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
	public List<Organization> findAllByIndustryType(IndustryType type)
	{
		return repository.findAllByType(type);
	}

	@Secured("ROLE_ORGANIZATION_READ")
	public List<Organization> findAllByRolesTypeName(String roleName)
	{
		return repository.findAllByRolesTypeName(roleName);
	}

	@Secured("ROLE_ORGANIZATION_READ")
	public List<Organization> findAllByRelationshipsRelationshipTypeName(String name)
	{
		return repository.findAllByRelationshipsRelationshipTypeName(name);
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
		repository.saveAndFlush(organization);
	}

	@Secured("ROLE_ORGANIZATION_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
