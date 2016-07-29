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
import com.kratonsolution.belian.healtcare.dm.MedicalTreatmentSales;
import com.kratonsolution.belian.healtcare.dm.MedicalTreatmentSalesItem;
import com.kratonsolution.belian.healtcare.dm.MedicalTreatmentSalesRepository;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.svc.InventoryStockService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MedicalTreatmentSalesService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private MedicalTreatmentSalesRepository repository;
	
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
	public MedicalTreatmentSales findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_TREATMENT_READ")
	public List<MedicalTreatmentSales> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<MedicalTreatmentSales>();

		return repository.findAll();
	}
				
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_TREATMENT_READ")
	public List<MedicalTreatmentSales> findAll(int pageIndex,int pageSize)
	{
		return null;
	}
	
	@Secured({"ROLE_TREATMENT_CREATE","ROLE_DOCTOR_APPOINTMENT_UPDATE"})
	public void add(MedicalTreatmentSales treatment)
	{
		repository.save(treatment);
		
		if(treatment.isBpjs())
		{
			for(MedicalTreatmentSalesItem item:treatment.getItems())
			{
				if(!item.getService().getComponents().isEmpty())
				{
					for(ProductComponent com:item.getService().getComponents())
						stockService.issue(com.getProduct(), com.getQuantity().multiply(item.getQuantity()));
				}
				else
					stockService.issue(item.getService(),item.getQuantity());
			}
		}
	}
	
	@Secured("ROLE_TREATMENT_UPDATE")
	public void paid(MedicalTreatmentSales treatment)
	{
		if(utils.getOrganization() == null)
			throw new RuntimeException("Default Organization not exist,please go to user setting.");
		
		repository.saveAndFlush(treatment);
		
		for(MedicalTreatmentSalesItem item:treatment.getItems())
		{
			if(!item.getService().getComponents().isEmpty())
			{
				for(ProductComponent com:item.getService().getComponents())
				{
					System.out.println(com.getProduct().getName());
					stockService.issue(com.getProduct(), com.getQuantity().multiply(item.getQuantity()));
				}
			}
			else
				stockService.issue(item.getService(),item.getQuantity());
		}
	}
	
	@Secured("ROLE_TREATMENT_UPDATE")
	public void edit(MedicalTreatmentSales treatment)
	{
		repository.saveAndFlush(treatment);
	}
	
	@Secured("ROLE_TREATMENT_DELETE")
	public void delete(@PathVariable String id)
	{
	}
}
