package com.kratonsolution.belian.core.party.impl.application;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.core.party.impl.orm.Organization;
import com.kratonsolution.belian.core.party.impl.repository.OrganizationRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class OrganizationService
{	
	private OrganizationRepository repository;
	
	private PartyService service;

	@Secured({"ROLE_ORGANIZATION_READ","ROLE_SYSTEM_READ"})
	public Organization findById(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findById(id).orElse(null);
	
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
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
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
		repository.deleteById(id);
	}
}
