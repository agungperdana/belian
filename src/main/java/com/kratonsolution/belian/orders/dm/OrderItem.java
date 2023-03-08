/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;
import com.kratonsolution.belian.requirement.dm.RequirementOrderCommitment;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="order_item")
@Inheritance(strategy=InheritanceType.JOINED)
public class OrderItem implements Referenceable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	protected BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="unit_price")
	protected BigDecimal untitPrice = BigDecimal.ONE;
		
	@Column(name="workeffort")
	protected boolean workeffort;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="uom_id")),
		@AttributeOverride(name="value",column=@Column(name="uom_value"))
	})
	protected IDValueRef uom;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	protected IDValueRef product;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_feature_id")),
		@AttributeOverride(name="value",column=@Column(name="product_feature_value"))
	})
	protected IDValueRef feature;
	
	@Column(name="note")
	protected String note;

	@Column(name="type")
	@Enumerated(EnumType.STRING)
	protected OrderItemType type = OrderItemType.PRODUCT;
	
	@ManyToOne
	@JoinColumn(name="fk_order")
	protected Order order;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="orderItem",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<RequirementOrderCommitment> orderCommitments = new HashSet<>();
	
	@OneToMany(mappedBy="orderItem",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderItemStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="orderItem",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date DESC")
	protected Set<OrderItemShippingInfo> shippingInfos = new HashSet<>();
	
	@OneToMany(mappedBy="orderItem",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date DESC")
	protected Set<OrderItemInvoiceInfo> invoiceInfos = new HashSet<>();
	
	public OrderItem(){}
	
	@Override
	public String getLabel()
	{
		return getProduct() != null?getProduct().getValue():"";
	}

	@Override
	public String getValue()
	{
		return getId();
	}
	
	public boolean isInvoiced()
	{
		for(OrderItemStatus status:getStatuses())
		{
			if(status.getType().equals(OrderItemStatusType.INVOICED))
				return true;
		}
		
		return false;
	}
	
	public boolean isShipped()
	{
		for(OrderItemStatus status:getStatuses())
		{
			if(status.getType().equals(OrderItemStatusType.SHIPPED))
				return true;
		}
		
		return false;
	}
	
	public BigDecimal getInvoiced()
	{
		BigDecimal amt = BigDecimal.ZERO;
		
		for(OrderItemInvoiceInfo info:getInvoiceInfos())
			amt = amt.add(info.getAmount());
			
		return amt;
	}
	
	public BigDecimal getShipped()
	{
		BigDecimal amt = BigDecimal.ZERO;
		
		for(OrderItemShippingInfo info:getShippingInfos())
			amt = amt.add(info.getAmount());
			
		return amt;
	}
	
	public void removeShippingInfo(BigDecimal amout)
	{
		Iterator<OrderItemShippingInfo> iterator = getShippingInfos().iterator();
		while (iterator.hasNext())
		{
			OrderItemShippingInfo info = (OrderItemShippingInfo) iterator.next();
			if(info.getAmount().compareTo(amout) == 0)
			{
				iterator.remove();
				break;
			}
		}
	}
	
	public void removeInvoiceInfo(BigDecimal amout)
	{
		Iterator<OrderItemInvoiceInfo> iterator = getInvoiceInfos().iterator();
		while (iterator.hasNext())
		{
			OrderItemInvoiceInfo info = (OrderItemInvoiceInfo) iterator.next();
			if(info.getAmount().compareTo(amout) == 0)
			{
				iterator.remove();
				break;
			}
		}
	}
}
