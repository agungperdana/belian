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

import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasureRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
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
	public UnitOfMeasure findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_UOM_READ")
	public List<UnitOfMeasure> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_UOM_READ")
	public List<UnitOfMeasure> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_UOM_CREATE")
	public void add(UnitOfMeasure currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_UOM_UPDATE")
	public void edit(UnitOfMeasure currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_UOM_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
