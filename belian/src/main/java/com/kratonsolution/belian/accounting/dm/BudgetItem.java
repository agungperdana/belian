/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.Listable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="budget_item")
public class BudgetItem implements Serializable, Listable
{
	@Id
	private String id;
	
	@Column(name="sequence")
	private int sequence;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="justification")
	private String justification;

	@Column(name="amount")
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name="fk_budget")
	private Budget budget;
	
	@Version
	private Long version;

	@Override
	public String getLabel()
	{
		return getPurpose();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}