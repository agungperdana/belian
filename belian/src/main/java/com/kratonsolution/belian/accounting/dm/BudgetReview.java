/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.EconomicAgent;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="budget_review")
public class BudgetReview implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private EconomicAgent party;
	
	@Column(name="result")
	private String result;
	
	@ManyToOne
	@JoinColumn(name="fk_budget")
	private Budget budget;
	
	@Version
	private Long version;

	public BudgetReview(){}
}
