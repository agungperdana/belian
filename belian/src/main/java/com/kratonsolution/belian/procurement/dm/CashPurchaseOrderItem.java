/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.ProductReceiveableItem;
import com.kratonsolution.belian.inventory.dm.Product;

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
public class CashPurchaseOrderItem implements Serializable,ProductReceiveableItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_cash_purchase_order")
	private CashPurchaseOrder purchaseOrder;

	@Version
	private Long version;
	
	public CashPurchaseOrderItem(){}
}
