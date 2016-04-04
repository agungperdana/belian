/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

import com.kratonsolution.belian.general.dm.Organization;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="budget")
public class Budget implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="description")
	private String comment;

	@ManyToOne
	@JoinColumn(name="fk_organization_requested")
	private Organization organization;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private BudgetType type = BudgetType.Operating;

	@ManyToOne
	@JoinColumn(name="fk_last_status")
	private BudgetStatus lastStatus;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("sequence")
	private Set<BudgetItem> items = new HashSet<BudgetItem>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date")
	private Set<BudgetStatus> statuses = new HashSet<BudgetStatus>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<BudgetRole> roles = new HashSet<>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<BudgetRevision> revisions = new HashSet<>();
	
	@OneToMany(mappedBy="budget",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<BudgetReview> reviews = new HashSet<>();
	
	public Budget(){}
}
