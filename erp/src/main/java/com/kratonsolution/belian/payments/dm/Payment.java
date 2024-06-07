
package com.kratonsolution.belian.payments.dm;

import java.math.BigDecimal;
import java.sql.Date;
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
import jakarta.persistence.Table;
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
