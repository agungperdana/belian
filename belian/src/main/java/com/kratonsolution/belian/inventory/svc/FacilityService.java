/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class FacilityService
{
	@Autowired
	private FacilityRepository repository;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_FACILITY_READ")
	public int size()
	{
		return repository.size().intValue();
	}
	
	@Secured({"ROLE_FACILITY_READ","ROLE_SYSTEM_READ"})
	public Facility findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
		
		return null;
	}
	
	@Secured({"ROLE_FACILITY_READ","ROLE_SYSTEM_READ"})
	public Facility findOneByCode(String code)
	{
		return repository.findOneByCode(code);
	}
	
	@Secured({"ROLE_FACILITY_READ","ROLE_SYSTEM_READ"})
	public List<Facility> findAllActive()
	{
		List<Facility> ins = new ArrayList<Facility>();
		
		for(FacilityOrganization organization:utils.getOrganization().getFacilitys())
		{
			if(organization.isEnabled())
				ins.add(organization.getFacility());
		}
	
		return ins;
	}
	
	@Secured("ROLE_FACILITY_READ")
	public List<Facility> findAll()
	{
		return repository.findAll(new Sort(Direction.ASC, "code","name"));
	}
	
	@Secured("ROLE_FACILITY_READ")
	public List<Facility> findAllParent()
	{
		return repository.findAllParent();
	}
	
	@Secured("ROLE_FACILITY_READ")
	public List<Facility> findAll(int pageIndex,int pageSize)
	{
		return repository.findAllParent(new PageRequest(pageIndex, pageSize));
	}
	
	@Secured("ROLE_FACILITY_CREATE")
	public void add(Facility facility)
	{
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
		repository.delete(id);
	}
}
