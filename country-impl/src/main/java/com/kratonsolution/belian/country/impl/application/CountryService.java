
package com.kratonsolution.belian.country.impl.application;

import java.util.List;

import com.kratonsolution.belian.country.impl.orm.Country;
import com.kratonsolution.belian.country.impl.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CountryService
{
	@Autowired
	private CountryRepository repository;
	
	@Secured("ROLE_COUNTRY_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Country getOne(String id)
	{
		return repository.getOne(id);
	}
	
	@Secured("ROLE_COUNTRY_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Country> findAll()
	{
		return repository.findAll(Sort.by(Sort.Direction.ASC,"code"));
	}
	
	@Secured("ROLE_COUNTRY_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Country> findAll(int pageindex,int itemSize)
	{
		return repository.findAll(PageRequest.of(pageindex, itemSize,Sort.by(Direction.ASC, "code"))).getContent();
	}
	
	@Secured("ROLE_COUNTRY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_COUNTRY_CREATE")
	public void add(Country module)
	{
		repository.save(module);
	}
	
	@Secured("ROLE_COUNTRY_UPDATE")
	public void edit(Country module)
	{
		repository.save(module);
	}
	
	@Secured("ROLE_COUNTRY_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
}
