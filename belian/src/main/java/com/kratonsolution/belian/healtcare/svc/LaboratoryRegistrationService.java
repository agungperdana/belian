/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.LaboratoryRegistration;
import com.kratonsolution.belian.healtcare.dm.LaboratoryRegistrationRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class LaboratoryRegistrationService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private LaboratoryRegistrationRepository repository;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABS_REGISTRATION_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABS_REGISTRATION_READ")
	public LaboratoryRegistration findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABS_REGISTRATION_READ")
	public List<LaboratoryRegistration> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<LaboratoryRegistration>();

		return repository.findAll();
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABS_REGISTRATION_READ")
	public List<LaboratoryRegistration> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<LaboratoryRegistration>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_LABS_REGISTRATION_CREATE")
	public void add(LaboratoryRegistration lab)
	{
		repository.save(lab);
	}
	
	@Secured("ROLE_LABS_REGISTRATION_UPDATE")
	public void edit(LaboratoryRegistration lab)
	{
		repository.saveAndFlush(lab);
	}
	
	@Secured("ROLE_LABS_REGISTRATION_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
