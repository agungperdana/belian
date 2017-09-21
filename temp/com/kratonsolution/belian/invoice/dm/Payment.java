/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.partys.dm.Organization;

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
public class Payment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;

	@Column(name="reference")
	private String reference;
	
	@Column(name="note")
	private String note;

	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
		
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@Enumerated(EnumType.STRING)
	@Column(name="method_type")
	private PaymentMethodType methodType = PaymentMethodType.CASH;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private PaymentType type = PaymentType.RECEIPT;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="payment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PaymentApplication> applications = new HashSet<>();
	
	public Payment(){}
}
