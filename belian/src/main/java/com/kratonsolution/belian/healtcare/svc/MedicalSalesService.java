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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.MedicalSales;
import com.kratonsolution.belian.healtcare.dm.MedicalSalesItem;
import com.kratonsolution.belian.healtcare.dm.MedicalSalesRepository;
import com.kratonsolution.belian.healtcare.dm.MedicalSalesStatus;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.svc.InventoryStockService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MedicalSalesService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private MedicalSalesRepository repository;
	
	@Autowired
	private InventoryStockService stockService;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public MedicalSales findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public List<MedicalSales> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<MedicalSales>();

		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public List<MedicalSales> findAllPaidRegistered()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<MedicalSales>();

		return repository.findAllPaidRegistered(DateTimes.currentDate(),utils.getOrganization().getId());
	}
			
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public List<MedicalSales> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<MedicalSales>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public List<MedicalSales> findAllPaid()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<MedicalSales>();

		return repository.findAllPaid(DateTimes.currentDate(),utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public int sizePaid()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(DateTimes.currentDate(),utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_PHARMACY_SALES_CREATE")
	public void add(MedicalSales medical)
	{
		repository.save(medical);
	}
	
	@Secured({"ROLE_PHARMACY_SALES_UPDATE","ROLE_PHARMACY_ORDER_UPDATE"})
	public void finish(MedicalSales medical)
	{
		if(utils.getOrganization() == null)
			throw new RuntimeException("Default Organization not exist,please go to user setting.");
		
		medical.setStatus(MedicalSalesStatus.Finished);
		repository.saveAndFlush(medical);
		
		if(medical.getStatus().equals(MedicalSalesStatus.Finished))
		{
			for(MedicalSalesItem item:medical.getItems())
			{
				if(!item.getProduct().getComponents().isEmpty())
				{
					for(ProductComponent com:item.getProduct().getComponents())
						stockService.issue(com.getProduct(), com.getQuantity().multiply(item.getQuantity()));
				}
				else
					stockService.issue(item.getProduct(),item.getQuantity());
			}
		}
	}

	@Secured({"ROLE_PHARMACY_SALES_UPDATE","ROLE_PHARMACY_ORDER_UPDATE"})
	public void edit(MedicalSales medical)
	{
		repository.saveAndFlush(medical);
	}
	
	@Secured({"ROLE_PHARMACY_SALES_DELETE","ROLE_PHARMACY_ORDER_DELETE"})
	public void delete(String id)
	{
		MedicalSales medical = findOne(id);
		if(!medical.isPaid() && medical.getStatus().equals(MedicalSalesStatus.Registered))
			repository.delete(medical);
		else
			throw new RuntimeException("This medical order already prepared or finished.");
	}
}
