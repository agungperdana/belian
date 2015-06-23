/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

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

import com.kratonsolution.belian.accounting.dm.BudgetItem;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="position")
public class Position implements Serializable
{
	public enum WorktimeStatus{Fulltime,Parttime,Freelance}
	
	public enum EmploymentStatus{Permanent,Contract}
	
	public enum SalaryStatus{Monthly,Weekly,Daily,Hourly}
	
	public enum PositionStatusType{Planned,Open,Closed}
	
	@Id
	private String id;
	
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
	private PositionStatusType positionStatusType = PositionStatusType.Planned;
	
	@ManyToOne
	@JoinColumn(name="fk_budget_item")
	private BudgetItem budgetItem;
	
	@ManyToOne
	@JoinColumn(name="fk_position_type")
	private PositionType type;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="position",cascade=CascadeType.REMOVE,orphanRemoval=true)
	@OrderBy("start ASC")
	private Set<PositionResponsibility> responsibilitys = new HashSet<PositionResponsibility>();
}
