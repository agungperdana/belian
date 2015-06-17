/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.BudgetType;
import com.kratonsolution.belian.accounting.dm.BudgetTypeRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BudgetTypeService
{
	@Autowired
	private BudgetTypeRepository repository;
	
	@Secured("ROLE_BUDGETTYPE_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_BUDGETTYPE_READ")
	public BudgetType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_BUDGETTYPE_READ")
	public List<BudgetType> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_BUDGETTYPE_READ")
	public List<BudgetType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_BUDGETTYPE_CREATE")
	public void add(BudgetType bank)
	{
		bank.setId(UUID.randomUUID().toString());
		repository.save(bank);
	}
	
	@Secured("ROLE_BUDGETTYPE_UPDATE")
	public void edit(BudgetType bank)
	{
		repository.saveAndFlush(bank);
	}
	
	@Secured("ROLE_BUDGETTYPE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
