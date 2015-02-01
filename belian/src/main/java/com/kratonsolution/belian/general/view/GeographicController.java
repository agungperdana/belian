/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.GeographicRepository;
import com.kratonsolution.belian.security.dm.AccessGrantedFor;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class GeographicController
{
	@Autowired
	private GeographicRepository repository;
		
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_READ)
	public List<Geographic> findAll()
	{
		return repository.findAll();
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_READ)
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_CREATE)
	public boolean add(Geographic geographic)
	{
		repository.save(geographic);
		return true;
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_UPDATE)
	public boolean edit(Geographic geographic)
	{
		repository.save(geographic);
		return true;
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_DELETE)
	public boolean delete(String id)
	{
		repository.delete(id);
		return true;
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_READ)
	public Page<Geographic> findAll(int pageIndex,int itemsSize)
	{		
		PageRequest request = new PageRequest(pageIndex, itemsSize);
		return repository.findAll(request);
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_READ)
	public List<Geographic> findAll(Pageable pageable)
	{
		return repository.findAll(pageable).getContent();
	}
}
