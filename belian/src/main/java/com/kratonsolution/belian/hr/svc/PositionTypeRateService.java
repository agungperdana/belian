/**
 * 
 */
package com.kratonsolution.belian.hr.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.hr.dm.PositionTypeRate;
import com.kratonsolution.belian.hr.dm.PositionTypeRateRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PositionTypeRateService
{
	@Autowired
	private PositionTypeRateRepository repository;
	
	@Secured("ROLE_POSITIONTYPERATE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_POSITIONTYPERATE_READ")
	public PositionTypeRate findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_POSITIONTYPERATE_READ")
	public List<PositionTypeRate> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_POSITIONTYPERATE_READ")
	public List<PositionTypeRate> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_POSITIONTYPERATE_CREATE")
	public void add(PositionTypeRate rate)
	{
		rate.setId(UUID.randomUUID().toString());
		repository.save(rate);
	}
	
	@Secured("ROLE_POSITIONTYPERATE_UPDATE")
	public void edit(PositionTypeRate rate)
	{
		repository.saveAndFlush(rate);
	}
	
	@Secured("ROLE_POSITIONTYPERATE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
