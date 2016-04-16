/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

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

import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.global.dm.Listable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="position")
public class Position implements Serializable,Listable
{	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start_date")
	private Date start;
	
	@Column(name="end_date")
	private Date end;
	
	@Column(name="actual_start_date")
	private Date actualStart;
	
	@Column(name="actual_end_date")
	private Date actualEnd;
	
	@Column(name="worktime_status")
	@Enumerated(EnumType.STRING)
	private WorktimeStatus worktimeStatus = WorktimeStatus.Fulltime;
	
	@Column(name="temporary_status")
	@Enumerated(EnumType.STRING)
	private EmploymentStatus employmentStatus = EmploymentStatus.Contract;
	
	@Column(name="salary_status")
	@Enumerated(EnumType.STRING)
	private SalaryStatus salaryStatus = SalaryStatus.Monthly;
	
	@Column(name="position_status_type")
	@Enumerated(EnumType.STRING)
	private PositionStatus positionStatusType = PositionStatus.Planned;
	
	@ManyToOne
	@JoinColumn(name="fk_budget_item")
	private BudgetItem budgetItem;
	
	@ManyToOne
	@JoinColumn(name="fk_position_type")
	private PositionType type;
	
	@ManyToOne
	@JoinColumn(name="fk_organization_owner")
	private Organization organization;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="position",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("start ASC")
	private Set<PositionResponsibility> responsibilitys = new HashSet<PositionResponsibility>();

	@OneToMany(mappedBy="position",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("start ASC")
	private Set<PositionFulfillment> fulfillments = new HashSet<PositionFulfillment>();
	
	@OneToMany(mappedBy="position",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("start ASC")
	private Set<PositionReportingStructure> reportings = new HashSet<PositionReportingStructure>();

	@Override
	public String getLabel()
	{
		return getType().getTitle();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
