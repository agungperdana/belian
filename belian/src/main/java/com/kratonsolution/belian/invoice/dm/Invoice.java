/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.dm.Referenceable;
import com.kratonsolution.belian.orders.dm.RoleType;
import com.kratonsolution.belian.payments.dm.InvoiceRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="invoice")
@Inheritance(strategy=InheritanceType.JOINED)
public class Invoice implements Referenceable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	protected String number;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="note")
	protected String note;
	
	@Column(name="message")
	protected String message;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="billed_from_party_id")),
		@AttributeOverride(name="value",column=@Column(name="billed_from_party_value"))
	})
	protected IDValueRef billedFromParty;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="billed_from_address_id")),
		@AttributeOverride(name="value",column=@Column(name="billed_from_address_value"))
	})
	protected IDValueRef billedFromAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="billed_from_contact_id")),
		@AttributeOverride(name="value",column=@Column(name="billed_from_contact_value"))
	})
	protected IDValueRef billedFromContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="billed_to_party_id")),
		@AttributeOverride(name="value",column=@Column(name="billed_to_party_value"))
	})
	protected IDValueRef billedToParty;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="billed_to_address_id")),
		@AttributeOverride(name="value",column=@Column(name="billed_to_address_value"))
	})
	protected IDValueRef billedToAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="billed_to_contact_id")),
		@AttributeOverride(name="value",column=@Column(name="billed_to_contact_value"))
	})
	protected IDValueRef billedToContact;
	
	@Version
	protected Long version;

	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<InvoiceItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<InvoiceRole> roles = new HashSet<>();

	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<InvoiceStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="invoice",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<InvoiceTerm> terms = new HashSet<>();
	
	public Invoice(){}
	
	public Invoice(IDValueRef ref)
	{
		if(ref != null && ref.getId() != null && !ref.getId().equals(""))
		{
			setId(ref.getId());
			setNumber(ref.getValue());
		}
	}
	
	public Invoice(InvoiceRef ref)
	{
		if(ref != null && ref.getId() != null && !ref.getId().equals(""))
		{
			setId(ref.getId());
			setNumber(ref.getNumber());
			setDate(ref.getDate());
		}
	}

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
	
	public BigDecimal getSubtotal()
	{
		BigDecimal total = BigDecimal.ZERO;
		
		for(InvoiceItem item:getItems())
			total = total.add(item.getAmount());
		
		return total;
	}
	
	public Date getDueDate()
	{
		for(InvoiceTerm term:getTerms())
		{
			if(term.getType().equals(InvoiceTermType.PAYMENT))
			{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(getDate());
				calendar.add(Calendar.DAY_OF_MONTH, term.getValue().intValue());
				
				return new Date(calendar.getTimeInMillis());
			}
		}
		
		return getDate();
	}
	
	public boolean isPaid()
	{
		for(InvoiceStatus status:getStatuses())
		{
			if(status.getType().equals(InvoiceStatusType.PAID))
				return true;
		}
		
		return false;
	}
	
	public InvoiceRef toInvoiceRef()
	{
		InvoiceRef ref = new InvoiceRef();
		ref.setDate(getDate());
		ref.setId(getId());
		ref.setNumber(getNumber());
		
		return ref;
	}
	
	public void addSendStatus()
	{
		InvoiceStatus status = new InvoiceStatus();
		status.setDate(new Timestamp(System.currentTimeMillis()));
		status.setInvoice(this);
		status.setType(InvoiceStatusType.SEND);
		
		getStatuses().add(status);
	}
	
	public void addPaymentTerm(BigDecimal amount)
	{
		InvoiceTerm term = new InvoiceTerm();
		term.setInvoice(this);
		term.setType(InvoiceTermType.PAYMENT);
		term.setValue(amount);
		
		getTerms().add(term);
	}
	
	public void addEnterer(IDValueRef enterer)
	{
		InvoiceRole role = new InvoiceRole();
		role.setDate(DateTimes.timestamp());
		role.setInvoice(this);
		role.setParty(enterer);
		role.setType(RoleType.ENTERED_BY);
		
		getRoles().add(role);
	}
	
	public String getPaidStatus()
	{
		if(isPaid())
			return "PAID";
		else
			return "UNPAID";
	}
}
