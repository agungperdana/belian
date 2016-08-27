/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
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

import com.kratonsolution.belian.global.dm.ApproveAndReviewableItem;
import com.kratonsolution.belian.products.dm.Product;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="transfer_order_request_item")
public class TransferOrderRequestItem implements Serializable,ApproveAndReviewableItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_transfer_order")
	private TransferOrderRequest request;
	
	@OneToMany(mappedBy="requestedItem")
	private Set<GoodsTransferItem> items = new HashSet<GoodsTransferItem>();
	
	public TransferOrderRequestItem(){}

	@Override
	public BigDecimal getQuantity()
	{
		return quantity;
	}
	
	public BigDecimal getFullfilled()
	{
		BigDecimal decimal = BigDecimal.ZERO;
		for(GoodsTransferItem item:items)
			decimal = decimal.add(item.getQuantity());
		
		return decimal;
	}
	
	public boolean isDone()
	{
		return (getQuantity().compareTo(getFullfilled()) == 0);
	}

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
