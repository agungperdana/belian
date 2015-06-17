/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="budget")
public class Budget implements Serializable
{
	@Id
	private String id;
	
	@Column(name="date_start")
	private Date start;
	
	@Column(name="date_end")
	private Date end;
	
	@ManyToOne
	@JoinColumn(name="fk_budget_type")
	private BudgetType type;
	
	@Column(name="description")
	private String description;

	@Version
	private Long version;

	@OneToMany(mappedBy="budget",cascade=CascadeType.REMOVE,orphanRemoval=true)
	private Set<BudgetItem> items = new HashSet<BudgetItem>();
}
