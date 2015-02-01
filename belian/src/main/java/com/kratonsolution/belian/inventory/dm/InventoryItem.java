/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kratonsolution.belian.global.EconomicResource;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="inventory_item")
public class InventoryItem implements EconomicResource
{
	@Id
	private String id;
	
	@DBRef
	private Product product;
	
	@DBRef
	private Facility facility;
	
	@DBRef
	private Container container;
	
	@Field("serial_number")
	private String serialNumber;
	
	@Field("on_hand")
	private BigDecimal onhand = BigDecimal.ZERO;

	@Override
	public void increment(BigDecimal value)
	{
		setOnhand(getOnhand().add(value));
	}

	@Override
	public void decrement(BigDecimal value)
	{
		if((getOnhand().subtract(value)).compareTo(BigDecimal.ZERO) >= 0)
			setOnhand(getOnhand().subtract(value));
		else
			setOnhand(BigDecimal.ZERO);
	}
}
