
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Referenceable;
import com.kratonsolution.belian.global.dm.StatusType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="orders")
@Inheritance(strategy=InheritanceType.JOINED)
public class Order implements Referenceable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="document_number",unique=true)
	protected String number;
	
	@Column(name="order_date")
	protected Date orderDate;
	
	@Column(name="entry_date")
	protected Date entryDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	protected OrderType type = OrderType.STANDARD;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="taking_order_id")),
		@AttributeOverride(name="value",column=@Column(name="taking_order_value"))
	})
	protected IDValueRef partyTakingOrder;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="placing_order_id")),
		@AttributeOverride(name="value",column=@Column(name="placing_order_value"))
	})
	protected IDValueRef partyPlacingOrder;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="bill_to_party_id")),
		@AttributeOverride(name="value",column=@Column(name="bill_to_party_value"))
	})
	protected IDValueRef billToParty;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="billing_address_id")),
		@AttributeOverride(name="value",column=@Column(name="billing_address_value"))
	})
	protected IDValueRef billToAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="bill_to_contact_id")),
		@AttributeOverride(name="value",column=@Column(name="bill_to_contact_value"))
	})
	protected IDValueRef billToContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="ship_to_party_id")),
		@AttributeOverride(name="value",column=@Column(name="ship_to_party_value"))
	})
	protected IDValueRef shipToParty;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="shipping_address_id")),
		@AttributeOverride(name="value",column=@Column(name="shipping_address_value"))
	})
	protected IDValueRef shipToAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="ship_to_contact_id")),
		@AttributeOverride(name="value",column=@Column(name="ship_to_contact_value"))
	})
	protected IDValueRef shipToContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="currency_id")),
		@AttributeOverride(name="value",column=@Column(name="currency_value"))
	})
	protected IDValueRef currency;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderRole> partyOrderRoles = new HashSet<>();
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date DESC")
	protected Set<OrderStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderTerm> terms = new HashSet<>();
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderAdjustment> adjustments = new HashSet<>();
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderItem> items = new HashSet<>();
	
	public Order(){}

	@Override
	public String getLabel()
	{
		return getNumber();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
	
	public BigDecimal getTotalItems()
	{
		BigDecimal decimal = BigDecimal.ZERO;
		
		for(OrderItem orderItem:getItems())
			decimal = decimal.add(orderItem.getQuantity().multiply(orderItem.getUntitPrice()));
		
		return decimal;
	}
	
	public BigDecimal getTotalAdjustments()
	{
		BigDecimal decimal = BigDecimal.ZERO;
		
		for(OrderAdjustment add:getAdjustments())
		{
			if(add.getType().equals(OrderAdjustmentType.DISCOUNT))
			{
				if(add.getAmount() != null && add.getAmount().compareTo(BigDecimal.ZERO) > 0)
					decimal = decimal.subtract(add.getAmount());
				else if(add.getPercent() != null && add.getPercent().compareTo(BigDecimal.ZERO) > 0)
					decimal = decimal.subtract(getTotalItems().multiply(add.getPercent()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP));
			}
			else
			{
				if(add.getAmount() != null && add.getAmount().compareTo(BigDecimal.ZERO) > 0)
					decimal = decimal.add(add.getAmount());
				else if(add.getPercent() != null && add.getPercent().compareTo(BigDecimal.ZERO) > 0)
					decimal = decimal.add(getTotalItems().multiply(add.getPercent()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP));
			}
		}
		
		return decimal;
	}
	
	public boolean isOpen()
	{
		for(OrderStatus status:getStatuses())
		{
			if(status.getType().equals(StatusType.CANCELED) || status.getType().equals(StatusType.DONE))
				return false;
		}
		
		return true;
	}
	
	public void addCreateStatus()
	{
		OrderStatus created = new OrderStatus();
		created.setDate(new Timestamp(System.currentTimeMillis()));
		created.setOrder(this);
		created.setType(StatusType.CREATED);

		getStatuses().add(created);
	}
	
	public void addDoneStatus()
	{
		OrderStatus done = new OrderStatus();
		done.setDate(new Timestamp(System.currentTimeMillis()));
		done.setOrder(this);
		done.setType(StatusType.DONE);
		
		getStatuses().add(done);
	}

	public void addCashTerm()
	{
		OrderTerm term = new OrderTerm();
		term.setOrder(this);
		term.setType(OrderTermType.CREDIT_TERM);
		term.setAmount(BigDecimal.ONE);
		
		getTerms().add(term);
	}
	
	public void addMonthTerm()
	{
		OrderTerm term = new OrderTerm();
		term.setOrder(this);
		term.setType(OrderTermType.CREDIT_TERM);
		term.setAmount(BigDecimal.valueOf(30));
		
		getTerms().add(term);
	}
	
	public boolean isCash()
	{
		for(OrderTerm term:getTerms())
		{
			if(term.getType().equals(OrderTermType.CREDIT_TERM) && term.getAmount().compareTo(BigDecimal.ONE) == 0)
				return true;
		}
		
		return false;
	}
}
