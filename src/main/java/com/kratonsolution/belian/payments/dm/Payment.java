/**
 * 
 */
package com.kratonsolution.belian.payments.dm;

import java.math.BigDecimal;
import java.sql.Date;
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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name="payment")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Payment implements Referenceable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	protected String number;
	
	@Column(name="reference")
	protected String reference;
	
	@Column(name="efective_date")
	protected Date efectiveDate;
	
	@Column(name="amount")
	protected BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="commend")
	protected String commend;
	
	@Enumerated(EnumType.STRING)
	@Column(name="method")
	protected PaymentMethodType method = PaymentMethodType.CASH;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="payer_id")),
		@AttributeOverride(name="value",column=@Column(name="payer_value"))
	})
	protected IDValueRef payer;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="receiver_id")),
		@AttributeOverride(name="value",column=@Column(name="receiver_value"))
	})
	protected IDValueRef receiver;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="payment",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<PaymentApplication> applications = new HashSet<>();
	
	public Payment(){}
	
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
	
	public abstract String getType();

	public abstract BigDecimal getPaymentAmt();
}
