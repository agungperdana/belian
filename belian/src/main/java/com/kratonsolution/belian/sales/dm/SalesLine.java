/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.global.DecrementEvent;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.Product;

/**
 * @author agungdodiperdana
 *
 */
@Setter
@Getter
public class SalesLine implements DecrementEvent
{
	@Id
	private String id;
	
	@DBRef
	private Product product;
	
	@DBRef
	private InventoryItem inventory;
	
	@Field("quantity")
	private BigDecimal quantity;
	
	@Override
	public InventoryItem getResource()
	{
		return getInventory();
	}

	@Override
	public BigDecimal getValue()
	{
		return getQuantity();
	}

	@Override
	public String getEventName()
	{
		return "Product Sale";
	}
}
