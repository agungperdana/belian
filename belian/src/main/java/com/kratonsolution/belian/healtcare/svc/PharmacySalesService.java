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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.MedicalSalesStatus;
import com.kratonsolution.belian.healtcare.dm.PharmacySales;
import com.kratonsolution.belian.healtcare.dm.PharmacySalesItem;
import com.kratonsolution.belian.healtcare.dm.PharmacySalesRepository;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.svc.InventoryStockService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PharmacySalesService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private PharmacySalesRepository repository;
	
	@Autowired
	private InventoryStockService stockService;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public int size()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public PharmacySales findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public List<PharmacySales> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<PharmacySales>();

		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public List<PharmacySales> findAllPaidRegistered()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<PharmacySales>();

		return repository.findAllPaidRegistered(DateTimes.currentDate(),utils.getOrganizationIds());
	}
			
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public List<PharmacySales> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<PharmacySales>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public List<PharmacySales> findAllPaid()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<PharmacySales>();

		return repository.findAllPaid(DateTimes.currentDate(),utils.getOrganizationIds());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ"})
	public int sizePaid()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(new Date(System.currentTimeMillis()),utils.getOrganizationIds()).intValue();
	}
	
	@Secured("ROLE_PHARMACY_SALES_CREATE")
	public void add(PharmacySales sales)
	{
		sales.setTime(DateTimes.currentTime());
		repository.save(sales);
	}
	
	@Secured({"ROLE_PHARMACY_SALES_UPDATE","ROLE_PHARMACY_ORDER_UPDATE"})
	public void finish(PharmacySales sales)
	{
		if(utils.getOrganization() == null)
			throw new RuntimeException("Default Organization not exist,please go to user setting.");
		
		sales.setStatus(MedicalSalesStatus.Finished);
		repository.saveAndFlush(sales);
		
		if(sales.getStatus().equals(MedicalSalesStatus.Finished))
		{
			for(PharmacySalesItem item:sales.getItems())
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
	public void edit(PharmacySales sales)
	{
		repository.save(sales);
	}
	
	@Secured({"ROLE_PHARMACY_SALES_DELETE","ROLE_PHARMACY_ORDER_DELETE"})
	public void delete(@PathVariable String id)
	{
		PharmacySales sales = findOne(id);
		if(!sales.isPaid() && sales.getStatus().equals(MedicalSalesStatus.Registered))
			repository.delete(sales);
		else
			throw new RuntimeException("This sales order already prepared or finished.");
	}
}
