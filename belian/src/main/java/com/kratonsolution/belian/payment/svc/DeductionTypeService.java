/**
 * 
 */
package com.kratonsolution.belian.payment.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;
import com.kratonsolution.belian.accounting.dm.JournalSettingRepository;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.payment.dm.DeductionType;
import com.kratonsolution.belian.payment.dm.DeductionTypeRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DeductionTypeService
{
	@Autowired
	private SessionUtils utils;
	
	@Autowired
	private DeductionTypeRepository repository;
	
	@Autowired
	private JournalSettingRepository journalRepository;
	
	@Autowired
	private InventoryItemRepository inventoryRepository;
	
	@Autowired
	private OrganizationAccountRepository accountRepository;

	@Autowired
	private AccountingPeriodRepository periodRepository;
	
	@Secured("ROLE_CASHSALES_READ")
	public int size()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public DeductionType findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<DeductionType> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_CASHSALES_READ")
	public List<DeductionType> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_CASHSALES_CREATE")
	public void add(DeductionType sales)
	{
		repository.save(sales);
	}
	
	@Secured("ROLE_CASHSALES_UPDATE")
	public void edit(DeductionType sales)
	{
		repository.saveAndFlush(sales);
	}
	
	@Secured("ROLE_CASHSALES_UPDATE")
	public void addPayment(DeductionType out)
	{
	}
	
	@Secured("ROLE_CASHSALES_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
