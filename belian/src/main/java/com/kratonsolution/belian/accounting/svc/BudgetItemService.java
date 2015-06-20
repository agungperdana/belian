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

import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.dm.BudgetItemRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BudgetItemService
{
	@Autowired
	private BudgetItemRepository repository;
	
	@Secured("ROLE_BUDGETITEM_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_BUDGETITEM_READ")
	public BudgetItem findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_BUDGETITEM_READ")
	public List<BudgetItem> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_BUDGETITEM_READ")
	public List<BudgetItem> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_BUDGETITEM_CREATE")
	public void add(BudgetItem item)
	{
		item.setId(UUID.randomUUID().toString());
		repository.save(item);
	}
	
	@Secured("ROLE_BUDGETITEM_UPDATE")
	public void edit(BudgetItem item)
	{
		repository.saveAndFlush(item);
	}
	
	@Secured("ROLE_BUDGETITEM_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
