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
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.healtcare.dm.LaboratoryItem;
import com.kratonsolution.belian.healtcare.dm.LaboratoryRepository;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.svc.InventoryStockService;

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
	private LaboratoryRepository repository;
	
	@Autowired
	private InventoryStockService stockService;
	
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
	public Laboratory findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABS_REGISTRATION_READ")
	public List<Laboratory> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Laboratory>();

		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABS_REGISTRATION_READ")
	public List<Laboratory> findAllPaid()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Laboratory>();

		return repository.findAllPaid(utils.getOrganization().getId());
	}
			
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_LABS_REGISTRATION_READ")
	public List<Laboratory> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Laboratory>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_LABS_REGISTRATION_CREATE")
	public void add(Laboratory lab)
	{
		repository.save(lab);
	}
	
	@Secured("ROLE_LABS_REGISTRATION_UPDATE")
	public void edit(Laboratory lab)
	{
		repository.save(lab);
	}
	
	@Secured("ROLE_LABS_REGISTRATION_UPDATE")
	public void handle(Laboratory lab)
	{
		repository.save(lab);
		
		for(LaboratoryItem item:lab.getItems())
		{
			if(!item.getService().getComponents().isEmpty())
			{
				for(ProductComponent com:item.getService().getComponents())
					stockService.issue(com.getProduct(), item.getQuantity().multiply(com.getQuantity()));
			}
			else
				stockService.issue(item.getService(), item.getQuantity());
		}		
		
	}
	
	@Secured("ROLE_LABS_REGISTRATION_DELETE")
	public void delete(@PathVariable String id)
	{
		Laboratory lab = findOne(id);
		if(!lab.isPaid())
			repository.delete(lab);
	}
}
