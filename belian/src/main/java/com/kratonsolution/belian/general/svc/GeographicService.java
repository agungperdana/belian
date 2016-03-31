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
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.GeographicRepository;
import com.kratonsolution.belian.security.dm.AccessGrantedFor;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class GeographicService
{
	@Autowired
	private GeographicRepository repository;
		
	@Secured({AccessGrantedFor.ROLE_GEOGRAPHIC_READ,"ROLE_SYSTEM_READ"})
	public Geographic findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({AccessGrantedFor.ROLE_GEOGRAPHIC_READ,"ROLE_SYSTEM_READ"})
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
	public void add(Geographic geographic)
	{
		geographic.setId(UUID.randomUUID().toString());
		repository.save(geographic);
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_UPDATE)
	public void edit(Geographic geographic)
	{
		repository.saveAndFlush(geographic);
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_DELETE)
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured(AccessGrantedFor.ROLE_GEOGRAPHIC_READ)
	public List<Geographic> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
