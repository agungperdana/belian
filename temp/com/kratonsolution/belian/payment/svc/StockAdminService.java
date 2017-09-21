/**
 * 
 */
package com.kratonsolution.belian.payment.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.StockAdmin;
import com.kratonsolution.belian.inventory.dm.StockAdminRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StockAdminService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private StockAdminRepository repository;
		
	@Secured({"ROLE_STOCK_ADMIN_READ","ROLE_SYSTEM_READ"})
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;
		
		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured({"ROLE_STOCK_ADMIN_READ","ROLE_SYSTEM_READ"})
	public StockAdmin findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured({"ROLE_STOCK_ADMIN_READ","ROLE_SYSTEM_READ"})
	public StockAdmin findOne()
	{
		if(utils.getOrganization() == null || utils.getEmployee() == null)
			return null;
		
		return repository.findOne(DateTimes.currentDate(), utils.getEmployee().getId(), utils.getOrganization().getId());
	}
	
	@Secured({"ROLE_STOCK_ADMIN_READ","ROLE_SYSTEM_READ"})
	public List<StockAdmin> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_STOCK_ADMIN_READ","ROLE_SYSTEM_READ"})
	public List<StockAdmin> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganization().getId());
	}
	
	@Secured("ROLE_STOCK_ADMIN_CREATE")
	public void add(StockAdmin sales)
	{
		repository.save(sales);
	}
	
	@Secured("ROLE_STOCK_ADMIN_UPDATE")
	public void edit(StockAdmin sales)
	{
		repository.saveAndFlush(sales);
	}
	
	@Secured("ROLE_STOCK_ADMIN_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
}
