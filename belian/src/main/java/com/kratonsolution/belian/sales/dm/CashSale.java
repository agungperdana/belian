/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicEvent;
import com.kratonsolution.belian.inventory.dm.InventoryItem;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="cash_sale")
public class CashSale extends EconomicEvent<InventoryItem>
{
	@ManyToOne
	@JoinColumn(name="fk_inventory_item")
	protected InventoryItem resource;
}
