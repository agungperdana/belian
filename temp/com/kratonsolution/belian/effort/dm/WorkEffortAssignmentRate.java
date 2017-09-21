/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.hr.dm.RateType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="work_effort_assignment_rate")
public class WorkEffortAssignmentRate implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="rate")
	private BigDecimal rate = BigDecimal.ONE;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RateType type = RateType.REGULAR_PAY;
	
	@ManyToOne
	@JoinColumn(name="fk_assignment")
	private WorkEffortPartyAssignment assignment;
	
	@Version
	private Long version;

	public WorkEffortAssignmentRate(){}
}
