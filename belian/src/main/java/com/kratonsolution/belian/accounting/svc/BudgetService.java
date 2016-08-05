/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetRepository;
import com.kratonsolution.belian.common.SessionUtils;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BudgetService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private BudgetRepository repository;
	
	@Secured("ROLE_BUDGET_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_BUDGET_READ")
	public int count()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;
		
		return repository.count(utils.getOrganizationIds());
	}
	
	@Secured("ROLE_BUDGET_READ")
	public Budget findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_BUDGET_READ")
	public List<Budget> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_BUDGET_READ")
	public List<Budget> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();
			
		return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
	}
	
	@Secured("ROLE_BUDGET_CREATE")
	public void add(Budget budget)
	{
		repository.save(budget);
	}
	
	@Secured("ROLE_BUDGET_UPDATE")
	public void edit(Budget budget)
	{
		repository.saveAndFlush(budget);
	}
	
	@Secured("ROLE_BUDGET_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
