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
import com.kratonsolution.belian.healtcare.dm.LaboratoryBilling;
import com.kratonsolution.belian.healtcare.dm.LaboratoryBillingRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class LaboratoryBillingService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private LaboratoryBillingRepository repository;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABORATORY_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABORATORY_READ")
	public LaboratoryBilling findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABORATORY_READ")
	public List<LaboratoryBilling> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<LaboratoryBilling>();

		return repository.findAll();
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABORATORY_READ")
	public List<LaboratoryBilling> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<LaboratoryBilling>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_LABORATORY_CREATE")
	public void add(LaboratoryBilling type)
	{
		repository.save(type);
	}
	
	@Secured("ROLE_LABORATORY_UPDATE")
	public void edit(LaboratoryBilling type)
	{
		repository.saveAndFlush(type);
	}
	
	@Secured("ROLE_LABORATORY_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
