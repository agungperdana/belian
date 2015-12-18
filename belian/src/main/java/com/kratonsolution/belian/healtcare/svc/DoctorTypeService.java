/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.healtcare.dm.DoctorType;
import com.kratonsolution.belian.healtcare.dm.DoctorTypeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DoctorTypeService
{
	@Autowired
	private DoctorTypeRepository repository;
	
	@Secured("ROLE_DOCTORTYPE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_DOCTORTYPE_READ")
	public DoctorType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_DOCTORTYPE_READ")
	public List<DoctorType> findAll()
	{
		return repository.findAll();
	}
		
	@Secured("ROLE_DOCTORTYPE_READ")
	public List<DoctorType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_DOCTORTYPE_CREATE")
	public void add(DoctorType type)
	{
		type.setId(UUID.randomUUID().toString());
		repository.save(type);
	}
	
	@Secured("ROLE_DOCTORTYPE_UPDATE")
	public void edit(DoctorType type)
	{
		repository.saveAndFlush(type);
	}
	
	@Secured("ROLE_DOCTORTYPE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
