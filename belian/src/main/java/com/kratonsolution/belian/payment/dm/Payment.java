/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

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
public abstract class Payment implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="reference")
	protected String reference;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="amount")
	protected BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="note")
	protected String note;
	
	@ManyToOne
	@JoinColumn(name="fk_payment_method_type")
	protected PaymentMethodType type;
	
	@Version
	protected Long version;
	
	public Payment(){}
}
