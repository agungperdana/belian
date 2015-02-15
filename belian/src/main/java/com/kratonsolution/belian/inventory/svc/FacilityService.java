/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class FacilityService
{
	@Autowired
	private FacilityRepository repository;
	
	@Secured("ROLE_FACILITY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_FACILITY_READ")
	public Facility findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_FACILITY_READ")
	public List<Facility> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_FACILITY_READ")
	public List<Facility> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_FACILITY_CREATE")
	public void add(Facility currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_FACILITY_UPDATE")
	public void edit(Facility currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_FACILITY_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
