
package com.kratonsolution.belian.shipment.dm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_item")
public class ShipmentItem implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;

	@Column(name="content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="fk_shipment")
	private Shipment shipment;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_shipping_document")
	private ShippingDocument document;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	protected IDValueRef product;
	
	@Transient
	protected boolean delete;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="shipmentItem",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentOrder> orders = new HashSet<>();
	
	@OneToMany(mappedBy="shipmentItem",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date DESC")
	private Set<ShipmentItemIssuanceInfo> issuanceInfos = new HashSet<>();
	
	@OneToMany(mappedBy="shipmentItem",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date DESC")
	private Set<ShipmentItemReceiptInfo> receiptInfos = new HashSet<>();
	
	public ShipmentItem(){}

	@Override
	public String getLabel()
	{
		return getProduct().getValue();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
	
	public BigDecimal getTotal()
	{
		BigDecimal amt = BigDecimal.ZERO;
		
		for(ShipmentOrder order:orders)
			amt = amt.add(order.getQuantity().multiply(order.getUnitPrice()));
		
		return amt;
	}
	
	public void removeIssuanceInfo(BigDecimal amount)
	{
		Iterator<ShipmentItemIssuanceInfo> iterator = getIssuanceInfos().iterator();
		while (iterator.hasNext())
		{
			ShipmentItemIssuanceInfo info = (ShipmentItemIssuanceInfo) iterator.next();
			if(info.getAmount().compareTo(amount) == 0)
			{
				iterator.remove();
				break;
			}
		}
	}
	
	public void removeReceiptInfo(BigDecimal amount)
	{
		Iterator<ShipmentItemReceiptInfo> iterator = getReceiptInfos().iterator();
		while (iterator.hasNext())
		{
			ShipmentItemReceiptInfo info = (ShipmentItemReceiptInfo) iterator.next();
			if(info.getAmount().compareTo(amount) == 0)
			{
				iterator.remove();
				break;
			}
		}
	}
	
	public BigDecimal getIssuance()
	{
		BigDecimal amt = BigDecimal.ZERO;
		
		for(ShipmentItemIssuanceInfo info:getIssuanceInfos())
			amt = amt.add(info.getAmount());
		
		return amt;
	}
	
	public BigDecimal getReceipted()
	{
		BigDecimal amt = BigDecimal.ZERO;
		
		for(ShipmentItemReceiptInfo info:getReceiptInfos())
			amt = amt.add(info.getAmount());
		
		return amt;
	}
	
	public boolean isIssuable()
	{
		return getQuantity().compareTo(getIssuance()) > 0;
	}
	
	public boolean isReceiptable()
	{
		return getQuantity().compareTo(getReceipted()) > 0;
	}
}
