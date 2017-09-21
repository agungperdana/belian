/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.math.BigDecimal;
import java.util.HashSet;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="invoice_item")
public class InvoiceItem implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="taxable")
	private boolean taxable;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ZERO;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private InvoiceItemType type = InvoiceItemType.INVOICE_PRODUCT;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	private IDValueRef product;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="feature_id")),
		@AttributeOverride(name="value",column=@Column(name="feature_value"))
	})
	private IDValueRef feature;
		
	@ManyToOne
	@JoinColumn(name="fk_sold_with")
	private InvoiceItem soldWith;
	
	@ManyToOne
	@JoinColumn(name="fk_invoice")
	private Invoice invoice;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<OrderItemBilling> orderItemBillings = new HashSet<>();
	
	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentItemBilling> shipmentItemBillings = new HashSet<>();

	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<TimeEntryBilling> timeEntryBillings = new HashSet<>();

	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortBilling> workEffortBillings = new HashSet<>();

	public InvoiceItem(){}
	
	public InvoiceItem(IDValueRef ref)
	{
		if(isValid(ref))
		{
			setId(ref.getId());
		}
	}

	@Override
	public String getLabel()
	{
		switch (type)
		{
			case INVOICE_PRODUCT:
				return getProduct()!=null?getProduct().getValue():"";
			case INVOICE_PRODUCT_FEATURE:
				return getFeature()!=null?getFeature().getValue():"";
			default:
				return type.display();
		}
	}
	
	public String getLabel(String lang)
	{
		switch (type)
		{
			case INVOICE_PRODUCT:
				return getProduct()!=null?getProduct().getValue():"";
			case INVOICE_PRODUCT_FEATURE:
				return getFeature()!=null?getFeature().getValue():"";
			default:
				return type.display(lang);
		}
	}

	@Override
	public String getValue()
	{
		return getId();
	}
	
	public boolean isSaveable()
	{
		return(!getOrderItemBillings().isEmpty() ||
				!getShipmentItemBillings().isEmpty() || 
				!getWorkEffortBillings().isEmpty() ||
				!getTimeEntryBillings().isEmpty());
	}
}
