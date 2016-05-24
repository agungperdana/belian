/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="budget_revision")
public class BudgetRevision implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="sequence")
	private int sequence = 1;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_budget")
	private Budget budget;
	
	@Column(name="comment")
	private String comment;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="revision",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<BudgetRevisionItem> items = new HashSet<>();
	
	public BudgetRevision(){}
}