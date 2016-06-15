/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.ApproveAndReviewableItem;
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
public class PurchaseOrderRequestItem implements ApproveAndReviewableItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ZERO;

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
	
	@OneToMany(mappedBy="requestItem")
	private Set<PurchaseOrderItem> orderItems = new HashSet<>();
	
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
	
	public BigDecimal getOrdered()
	{
		BigDecimal ordered = BigDecimal.ZERO;
		
		for(PurchaseOrderItem item:orderItems)
			ordered = ordered.add(item.getQuantity());
		
		return ordered;
	}
	
	public boolean isOpen()
	{
		return getOrdered().compareTo(quantity) < 0;
	}
}
