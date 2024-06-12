package com.kratonsolution.belian.facility.impl.application;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.AbstractService;
import com.kratonsolution.belian.facility.impl.orm.Facility;
import com.kratonsolution.belian.facility.impl.orm.FacilityOrganization;
import com.kratonsolution.belian.facility.impl.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class FacilityService extends AbstractService
{
	private FacilityRepository repository;
	
	@Secured("ROLE_FACILITY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public Facility findById(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findById(id).orElse(null);
		
		return null;
	}
	
	@Secured({"ROLE_FACILITY_READ"})
	public Facility byName(String name)
	{
		if(Strings.isNullOrEmpty(name))
			return null;
	
		return repository.findByName(name);
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
