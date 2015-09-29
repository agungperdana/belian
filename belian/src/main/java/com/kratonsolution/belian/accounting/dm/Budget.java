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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Organization;

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
	public enum Type{Operating,Capital}
	
	@Id
	private String id;
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="description")
	private String comment;

	@ManyToOne
	@JoinColumn(name="fk_organization_requested")
	private Organization partyRequested;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.Operating;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("sequence")
	private Set<BudgetItem> items = new HashSet<BudgetItem>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date")
	private Set<BudgetStatus> statuses = new HashSet<BudgetStatus>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date")
	private Set<BudgetReview> reviews = new HashSet<BudgetReview>();
}
