/**
 * 
 */
package com.kratonsolution.belian.sales.dm.srv;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.accounting.dm.CashAccountRepository;
import com.kratonsolution.belian.global.DecrementEvent;
import com.kratonsolution.belian.global.EconomicExchangeEvent;
import com.kratonsolution.belian.global.IncrementEvent;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesRepository;
import com.kratonsolution.belian.sales.dm.SalesLine;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class CashSalesService
{
	@Autowired
	private CashSalesRepository repository;
	
	@Autowired
	private CashAccountRepository cashAccountRepository;
	
	@Autowired
	private InventoryItemRepository inventoryItemRepository;

	@EconomicExchangeEvent
	public void create(CashSales sales)
	{
		sales.setId(UUID.randomUUID().toString());
		sales.getPayment().setId(UUID.randomUUID().toString());
		
		repository.save(sales);
		
		for(IncrementEvent event:sales.getIncrementEvents())
		{
			CashAccount account = cashAccountRepository.findOne(event.getResource().getId());
			if(account == null)
				throw new RuntimeException("Cash account not exist!");
			
			account.increment(event.getValue());
			cashAccountRepository.save(account);
		}
		
		for(DecrementEvent event:sales.getDecrementEvents())
		{
			InventoryItem item = inventoryItemRepository.findOne(event.getResource().getId());
			if(item == null)
				throw new RuntimeException("Inventory item doest not exist!");
			
			item.decrement(event.getValue());
			inventoryItemRepository.save(item);
		
			SalesLine line = (SalesLine)event;
			line.setProductId(item.getProductId());
			line.setProductName(item.getProductName());
		}
		
		repository.save(sales);
	}
}
