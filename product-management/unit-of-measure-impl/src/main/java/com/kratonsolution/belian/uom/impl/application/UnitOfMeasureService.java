package com.kratonsolution.belian.uom.impl.application;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.uom.impl.orm.UOMFactor;
import com.kratonsolution.belian.uom.impl.orm.UnitOfMeasure;
import com.kratonsolution.belian.uom.impl.repository.UnitOfMeasureRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UnitOfMeasureService
{
	@Autowired
	private UnitOfMeasureRepository repository;
	
	@Secured("ROLE_UOM_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_UOM_READ")
	public UnitOfMeasure findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_UOM_READ")
	public List<UnitOfMeasure> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_UOM_READ")
	public List<UnitOfMeasure> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_UOM_CREATE")
	public void add(UnitOfMeasure uom)
	{
		uom.setId(UUID.randomUUID().toString());
		repository.save(uom);
	}
	
	@Secured("ROLE_UOM_UPDATE")
	public void edit(UnitOfMeasure uom,Collection<UOMFactor> factors)
	{
		uom.getFactors().clear();
		repository.saveAndFlush(uom);
		
		uom.getFactors().addAll(factors);
		repository.saveAndFlush(uom);
	}
	
	@Secured("ROLE_UOM_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.deleteById(id);
	}
}
