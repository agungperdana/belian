/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.sql.Date;
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
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.healtcare.dm.MedicationItem;
import com.kratonsolution.belian.healtcare.dm.MedicationRepository;
import com.kratonsolution.belian.healtcare.dm.MedicationStatus;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.svc.InventoryStockService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MedicationService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private MedicationRepository repository;
	
	@Autowired
	private InventoryStockService stockService;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICATION_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICATION_READ")
	public Medication findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICATION_READ")
	public List<Medication> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Medication>();

		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICATION_READ")
	public List<Medication> findAllPaidRegistered()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Medication>();

		return repository.findAllPaidRegistered(new Date(System.currentTimeMillis()),utils.getOrganization().getId());
	}
			
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICATION_READ")
	public List<Medication> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Medication>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICATION_READ")
	public List<Medication> findAllPaid()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<Medication>();

		return repository.findAllPaid(new Date(System.currentTimeMillis()),utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_MEDICATION_READ")
	public int sizePaid()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(new Date(System.currentTimeMillis()),utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_MEDICATION_CREATE")
	public void add(Medication medication)
	{
		repository.save(medication);
	}
	
	@Secured("ROLE_MEDICATION_UPDATE")
	public void finish(Medication medication)
	{
		if(utils.getOrganization() == null)
			throw new RuntimeException("Default Organization not exist,please go to user setting.");
		
		repository.saveAndFlush(medication);
		
		if(medication.getStatus().equals(MedicationStatus.Finished))
		{
			for(MedicationItem item:medication.getItems())
			{
				if(!item.getMedicine().getComponents().isEmpty())
				{
					for(ProductComponent com:item.getMedicine().getComponents())
						stockService.inventoryProccess(com.getProduct(), com.getQuantity().multiply(item.getQuantity()));
				}
				else
					stockService.inventoryProccess(item.getMedicine(),item.getQuantity());
			}
		}
	}

	@Secured("ROLE_MEDICATION_UPDATE")
	public void edit(Medication medication)
	{
		repository.saveAndFlush(medication);
	}
	
	@Secured("ROLE_MEDICATION_DELETE")
	public void delete(@PathVariable String id)
	{
		Medication medication = findOne(id);
		if(!medication.isPaid() && medication.getStatus().equals(MedicationStatus.Registered))
			repository.delete(medication);
		else
			throw new RuntimeException("This medication order already prepared or finished.");
	}
}
