/**
 * 
 */
package com.kratonsolution.belian.general.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	public Geographic findOne(String id)
	{
		return repository.findOne(id);
	}
	
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
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_READ)
	public List<Geographic> findAllByType(Geographic.Type type)
	{
		return repository.findAllByType(type);
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
	public List<Geographic> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
