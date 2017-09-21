/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="paycheck_item")
public class PaycheckItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="method")
	private String method;
	
	@Column(name="account")
	private String account;
	
	@Column(name="bank")
	private String bank;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name="fk_paycheck")
	private Paycheck paycheck;
	
	@Version
	private Long version;
	
	public PaycheckItem(){}
}
