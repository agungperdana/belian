/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.ApproveableItem;
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
@Table(name="purchase_order_request_item")
public class PurchaseOrderRequestItem implements ApproveableItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity;

	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_purchase_order_request")
	private PurchaseOrderRequest request;
	
	@Version
	private Long version;
	
	public PurchaseOrderRequestItem(){}

	@Override
	public String getResource()
	{
		return getProduct().getName();
	}

	@Override
	public String getUom()
	{
		return getProduct().getUom().getName();
	}
}
