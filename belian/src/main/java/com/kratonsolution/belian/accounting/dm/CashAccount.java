/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.global.EconomicResource;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="cash_account")
public class CashAccount implements EconomicResource
{
	@Id
	private String id;
	
	@Column(name="number",nullable=false,unique=true)
	private String number;

	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;

	@ManyToOne
	@JoinColumn(name="fk_party_owner")
	private Party owner;
	
	@Column(name="status")
	private boolean active;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Version
	private Long version;

	public void increment(BigDecimal value)
	{
		setAmount(getAmount().add(value));
	}

	@Override
	public void decrement(BigDecimal value)
	{
		setAmount(getAmount().subtract(value));
	}
}
