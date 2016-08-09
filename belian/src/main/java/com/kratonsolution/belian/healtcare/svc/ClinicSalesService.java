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

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.ClinicSales;
import com.kratonsolution.belian.healtcare.dm.ClinicSalesItem;
import com.kratonsolution.belian.healtcare.dm.ClinicSalesRepository;
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
public class ClinicSalesService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private ClinicSalesRepository repository;
	
	@Autowired
	private InventoryStockService stockService;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public int size()
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public int size(String key)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return 0;
		
		if(!Strings.isNullOrEmpty(key))
			return repository.count(utils.getOrganizationIds(), key).intValue();
		else
			return size();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public ClinicSales findOne(String id)
	{
		return repository.findOne(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public List<ClinicSales> findAll()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<ClinicSales>();

		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ",
			  "ROLE_PHARMACY_ORDER_READ",
			  "ROLE_CLINIC_SALES_READ",
			  "ROLE_CLINIC_SALES_INVOICE_REPORT_READ"})
	public List<ClinicSales> findAllPaid(String company,Date start,Date end)
	{
		return repository.findAllPaid(company,start,end);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public List<ClinicSales> findAllPaidRegistered()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<ClinicSales>();

		return repository.findAllPaidRegistered(new Date(System.currentTimeMillis()),utils.getOrganization().getId());
	}
			
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public List<ClinicSales> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<ClinicSales>();

		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public List<ClinicSales> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganizationIds() == null || utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds(),key);
		else
			return findAll(pageIndex, pageSize);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public List<ClinicSales> findAllPaid()
	{
		if(utils.getOrganization() == null)
			return new ArrayList<ClinicSales>();

		return repository.findAllPaid(DateTimes.currentDate(),utils.getOrganization().getId());
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured({"ROLE_PHARMACY_SALES_READ","ROLE_PHARMACY_ORDER_READ","ROLE_CLINIC_SALES_READ"})
	public int sizePaid()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(new Date(System.currentTimeMillis()),utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_PHARMACY_SALES_CREATE")
	public void add(ClinicSales medication)
	{
		medication.setTime(DateTimes.currentTime());
		repository.save(medication);
	}
	
	@Secured({"ROLE_PHARMACY_SALES_UPDATE","ROLE_PHARMACY_ORDER_UPDATE"})
	public void finish(ClinicSales medication)
	{
		if(utils.getOrganization() == null)
			throw new RuntimeException("Default Organization not exist,please go to user setting.");
		
		medication.setStatus(MedicalSalesStatus.Finished);
		repository.saveAndFlush(medication);
		
		if(medication.getStatus().equals(MedicalSalesStatus.Finished))
		{
			for(ClinicSalesItem item:medication.getItems())
			{
				if(!item.getMedicine().getComponents().isEmpty())
				{
					for(ProductComponent com:item.getMedicine().getComponents())
						stockService.issue(com.getProduct(), com.getQuantity().multiply(item.getQuantity()));
				}
				else
					stockService.issue(item.getMedicine(),item.getQuantity());
			}
		}
	}

	@Secured({"ROLE_PHARMACY_SALES_UPDATE","ROLE_PHARMACY_ORDER_UPDATE"})
	public void edit(ClinicSales medication)
	{
		repository.saveAndFlush(medication);
	}
	
	@Secured({"ROLE_PHARMACY_SALES_DELETE","ROLE_PHARMACY_ORDER_DELETE"})
	public void delete(@PathVariable String id)
	{
		ClinicSales medication = findOne(id);
		if(!medication.isPaid() && medication.getStatus().equals(MedicalSalesStatus.Registered))
			repository.delete(medication);
		else
			throw new RuntimeException("This medication order already prepared or finished.");
	}
}
