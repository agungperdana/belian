
package com.kratonsolution.belian.geographic.impl.application;

import java.util.List;

import com.kratonsolution.belian.geographic.impl.orm.Geographic;
import com.kratonsolution.belian.geographic.impl.orm.GeographicType;
import com.kratonsolution.belian.geographic.impl.repository.GeographicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 1.0.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class GeographicService
{
	@Autowired
	private GeographicRepository repository;
		
	@Secured({"ROLE_GEOGRAPHIC_READ","ROLE_SYSTEM_READ"})
	public Geographic getOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.getOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_GEOGRAPHIC_READ","ROLE_SYSTEM_READ"})
	public List<Geographic> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_GEOGRAPHIC_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_GEOGRAPHIC_READ")
	public List<Geographic> findAllByType(GeographicType type)
	{
		if(type != null)
			return repository.findAllByType(type);
		else
			return findAll();
	}
	
	@Secured("ROLE_GEOGRAPHIC_CREATE")
	public void add(Geographic geographic)
	{
		repository.save(geographic);
	}
	
	@Secured("ROLE_GEOGRAPHIC_UPDATE")
	public void edit(Geographic geographic)
	{
		repository.saveAndFlush(geographic);
	}
	
	@Secured("ROLE_GEOGRAPHIC_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
	
	@Secured("ROLE_GEOGRAPHIC_READ")
	public List<Geographic> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, itemsSize)).getContent();
	}
}
