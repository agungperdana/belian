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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.general.dm.PartyRole.Type;
import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.dm.DoctorRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DoctorService
{
	@Autowired
	private DoctorRepository repository;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public Doctor findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<Doctor> findAll()
	{
		return repository.findAll();
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public List<Doctor> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_DOCTOR_CREATE")
	public void add(Doctor type)
	{
		type.setId(UUID.randomUUID().toString());
		repository.save(type);
	}
	
	@Secured("ROLE_DOCTOR_UPDATE")
	public void edit(Doctor type)
	{
		repository.saveAndFlush(type);
	}
	
	@Secured("ROLE_DOCTOR_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_DOCTOR_READ")
	public Doctor findOneByPartyIdAndType(String id,Type type)
	{
		return repository.findOneByPartyIdAndType(id, type);
	}
}
