/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="work_effort")
public class WorkEffort implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="name")
	private String name;

	@Column(name="note")
	private String note;

	@Column(name="scheduled_start_date")
	private Date scheduledStartDate;

	@Column(name="scheduled_complete_date")
	private Date scheduledCompleteDate;

	@Column(name="actual_start_date")
	private Date actualStartDate;

	@Column(name="actual_complete_date")
	private Date actualCompleteDate;

	@Column(name="money_allowed")
	private BigDecimal moneyAllowed;

	@Column(name="hour_allowed")
	private BigDecimal hourAllowed;

	@Column(name="estimated_hour")
	private BigDecimal estimatedHour;

	@Column(name="actual_hour")
	private BigDecimal actualdHour;
	
	@Column(name="spesial_term")
	private String spesialTerm;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private WorkEffortType type = WorkEffortType.TASK;

	@Enumerated(EnumType.STRING)
	@Column(name="purpose_type")
	private WorkEffortPurposeType purposeType = WorkEffortPurposeType.PRODUCTION;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_production_run")
	private ProductionRunProperties productionRunProperties;
	
	@ManyToOne()
	@JoinColumn(name="fk_parent")
	private WorkEffort parent;
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortRole> roles = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortPartyAssignment> assignments = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortAssetAssignment> assets = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortDeliverableProduced> deliverables = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortInventoryProduced> inventorys = new HashSet<>();
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffort> childs = new HashSet<>();
	
	@OneToMany(mappedBy="effort")
	private Set<TimeEntry> timeEntrys = new HashSet<>();
}
