/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

import java.io.Serializable;
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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="work_effort_status")
public class WorkEffortStatus implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private WorkEffortStatusType type = WorkEffortStatusType.CREATED;
	
	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	private WorkEffort effort;
	
	@Version
	private Long version;

	public WorkEffortStatus(){}
}
