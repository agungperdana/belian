/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicResource;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="inventory_item")
public class InventoryItem implements EconomicResource
{
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_facility")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name="fk_container")
	private Container container;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="onhand")
	private BigDecimal onhand = BigDecimal.ZERO;

	@Version
	private Long version;
	
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
