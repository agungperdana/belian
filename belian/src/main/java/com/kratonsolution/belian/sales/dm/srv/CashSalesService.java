/**
 * 
 */
package com.kratonsolution.belian.sales.dm.srv;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.CashAccountRepository;
import com.kratonsolution.belian.global.EconomicExchangeEvent;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.CashSalesRepository;

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
		sales.setNumber(sales.getId());
	}
}
