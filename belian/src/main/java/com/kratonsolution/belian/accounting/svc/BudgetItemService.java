/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.dm.BudgetItemRepository;
import com.kratonsolution.belian.common.SessionUtils;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BudgetItemService
{
	@Autowired
	private BudgetItemRepository repository;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_BUDGETITEM_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_BUDGETITEM_READ")
	public int sequence(String budget)
	{
		Integer last = repository.lastSequence(budget);
		if(last == null)
			return 1;
		
		return last+1;
	}
	
	@Secured("ROLE_BUDGETITEM_READ")
	public BudgetItem findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
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
		repository.save(item);
	}
	
	@Secured("ROLE_BUDGETITEM_UPDATE")
	public void edit(BudgetItem item)
	{
		repository.saveAndFlush(item);
	}
	
	@Secured("ROLE_BUDGETITEM_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_BUDGETITEM_READ")
	public List<BudgetItem> findAllByOwner()
	{
		return repository.findAllByOwner(utils.getOrganization().getId());
	}
}
