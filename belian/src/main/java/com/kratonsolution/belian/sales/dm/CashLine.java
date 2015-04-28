/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.DecrementCommitment;
import com.kratonsolution.belian.inventory.dm.InventoryItem;

/**
 * @author Agung Dodi Perdana
 *
 */
@Setter
@Getter
@Entity
@Table(name="sales_line")
public class CashLine extends DecrementCommitment<InventoryItem,CashSale>
{	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="fk_inventory_item")
	private InventoryItem resource;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_sales")
	private CashSales cashSales;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_cash_sales_event")
	private CashSale event;
}
