/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_purchase_order_item")
public class CashPurchaseOrderItem extends PurchaseOrderItem
{	
	@ManyToOne
	@JoinColumn(name="fk_cash_purchase_order")
	private CashPurchaseOrder purchaseOrder;
	
	public CashPurchaseOrderItem(){}
}
