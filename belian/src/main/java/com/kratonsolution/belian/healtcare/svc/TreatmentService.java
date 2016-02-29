/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.Treatment;
import com.kratonsolution.belian.healtcare.dm.TreatmentItem;
import com.kratonsolution.belian.healtcare.dm.TreatmentRepository;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.svc.InventoryStockService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TreatmentService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private TreatmentRepository repository;
	
	@Autowired
	private InventoryStockService stockService;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_TREATMENT_READ")
	public int size()
	{
		return 0;
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_TREATMENT_READ")
	public Treatment findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_TREATMENT_READ")
	public List<Treatment> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Treatment>();

		return repository.findAll();
	}
				
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_TREATMENT_READ")
	public List<Treatment> findAll(int pageIndex,int pageSize)
	{
		return null;
	}
	
	@Secured("ROLE_TREATMENT_CREATE")
	public void add(Treatment treatment)
	{
		repository.save(treatment);
		
		if(treatment.isBpjs())
		{
			for(TreatmentItem item:treatment.getItems())
			{
				if(!item.getService().getComponents().isEmpty())
				{
					for(ProductComponent com:item.getService().getComponents())
						stockService.inventoryProccess(com.getProduct(), com.getQuantity().multiply(item.getQuantity()));
				}
				else
					stockService.inventoryProccess(item.getService(),item.getQuantity());
			}
		}
	}
	
	@Secured("ROLE_TREATMENT_UPDATE")
	public void paid(Treatment treatment)
	{
		if(utils.getOrganization() == null)
			throw new RuntimeException("Default Organization not exist,please go to user setting.");
		
		repository.saveAndFlush(treatment);
		
		for(TreatmentItem item:treatment.getItems())
		{
			if(!item.getService().getComponents().isEmpty())
			{
				for(ProductComponent com:item.getService().getComponents())
				{
					System.out.println(com.getProduct().getName());
					stockService.inventoryProccess(com.getProduct(), com.getQuantity().multiply(item.getQuantity()));
				}
			}
			else
				stockService.inventoryProccess(item.getService(),item.getQuantity());
		}
	}
	
	@Secured("ROLE_TREATMENT_UPDATE")
	public void edit(Treatment treatment)
	{
		repository.saveAndFlush(treatment);
	}
	
	@Secured("ROLE_TREATMENT_DELETE")
	public void delete(@PathVariable String id)
	{
	}
}
