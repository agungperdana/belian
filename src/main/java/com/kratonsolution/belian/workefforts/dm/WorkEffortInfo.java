/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
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
@Table(name="work_effort_info")
public class WorkEffortInfo implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="name")
	private String name;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private WorkEffortType type = WorkEffortType.TASK;
	
	@Column(name="hour")
	private BigDecimal hour = BigDecimal.ONE;
	
	@Version
	private Long version;
	
	public WorkEffortInfo(){}
}
