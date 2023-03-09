
package com.kratonsolution.belian.inventory.svc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class FacilityService extends AbstractService
{
	@Autowired
	private FacilityRepository repository;
	
	@Secured("ROLE_FACILITY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public Facility getOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.getOne(id);
		
		return null;
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public Facility byName(String name)
	{
		if(Strings.isNullOrEmpty(name))
			return null;
	
		return repository.getOneByName(name);
	}
	
	public List<FacilityOrganization> findOrganizations()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAllFor(utils.getOrganization().getId());
	}
	
	public List<FacilityOrganization> findOrganizations(String organization)
	{
		if(Strings.isNullOrEmpty(organization))
			return new ArrayList<>();
		
		return repository.findAllFor(organization);
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public List<Facility> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_FACILITY_READ")
	public List<Facility> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_FACILITY_CREATE")
	public void add(Facility facility)
	{
		facility.setId(UUID.randomUUID().toString());
		repository.save(facility);
	}
	
	@Secured("ROLE_FACILITY_UPDATE")
	public void edit(Facility facility)
	{
		repository.saveAndFlush(facility);
	}
	
	@Secured("ROLE_FACILITY_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.deleteById(id);
	}
}
