/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.global.DecrementEvent;
import com.kratonsolution.belian.inventory.dm.InventoryItem;

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
	
	@Field("product_id")
	private String productId;
	
	@Field("product_name")
	private String productName;
	
	@Field("inventory_item_id")
	private String inventoryId;
	
	@Field("quantity")
	private BigDecimal quantity;
	
	@Override
	public InventoryItem getResource()
	{
		InventoryItem item = new InventoryItem();
		item.setId(inventoryId);
		
		return item;
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
