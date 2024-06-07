package com.kratonsolution.belian.core.country.impl.application;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.core.country.impl.orm.Country;
import com.kratonsolution.belian.core.country.impl.repository.CountryRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class CountryService
{
	private CountryRepository repository;
	
	@Secured("ROLE_COUNTRY_READ")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Country findById(String id)
	{
		return repository.findById(id).orElse(null);
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
		return repository.findAll(PageRequest.of(pageindex, itemSize, Sort.by(Direction.ASC, "code"))).getContent();
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
