/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.DecrementCommitment;
import com.kratonsolution.belian.inventory.dm.InventoryItem;

/**
 * @author agungdodiperdana
 *
 */
@Setter
@Getter
@Entity
@Table(name="sales_line")
public class CashLine extends DecrementCommitment<InventoryItem,CashSaleEvent>
{
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="fk_inventory_item")
	private InventoryItem item;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_sales")
	private CashSales cashSales;
	
	@Version
	private Long version;

	@Override
	public InventoryItem getResource()
	{
		return this.item;
	}

	@Override
	public CashSaleEvent getEvent()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
