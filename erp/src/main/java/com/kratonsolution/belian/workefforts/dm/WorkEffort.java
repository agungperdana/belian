
package com.kratonsolution.belian.workefforts.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.Referenceable;
import com.kratonsolution.belian.requirement.dm.WorkRequirementFulfillment;

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
public class WorkEffort implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="invoiced")
	private boolean invoiced;
	
	@Column(name="number")
	private String number;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="scheduled_start")
	private Timestamp scheduledStart;
	
	@Column(name="scheduled_end")
	private Timestamp scheduledEnd;
	
	@Column(name="actual_start")
	private Timestamp actualStart;
	
	@Column(name="actual_end")
	private Timestamp actualEnd;
	
	@Column(name="hours")
	private BigDecimal hours = BigDecimal.ZERO;
	
	@Column(name="max_allowed_hours")
	private BigDecimal maxAllowedHours = BigDecimal.valueOf(Double.MAX_VALUE);
	
	@Column(name="max_allowed_money")
	private BigDecimal maxAllowedMoney = BigDecimal.valueOf(Double.MAX_VALUE);
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private WorkEffortType type = WorkEffortType.TASK;
	
	@Column(name="purpose")
	@Enumerated(EnumType.STRING)
	private WorkEffortPurposeType purpose = WorkEffortPurposeType.WORKFLOW;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="owner_id")),
		@AttributeOverride(name="value",column=@Column(name="owner_value"))
	})
	private IDValueRef owner;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortPartyAssignment> assignments = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="effort")
	private Set<TimeEntry> timeEntrys = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortPartyRate> rates = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkRequirementFulfillment> fulfillments = new HashSet<>();
	
	@OneToMany(mappedBy="effort",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkOrderItemFulfillment> itemFulfillments = new HashSet<>();
	
	public WorkEffort(){}

	@Override
	public String getLabel()
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		return format.format(getCreationDate())+"/"+getNumber()+"/"+getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
