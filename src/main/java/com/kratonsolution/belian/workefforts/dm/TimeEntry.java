/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="time_entry")
public class TimeEntry implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Timestamp start;
	
	@Column(name="end")
	private Timestamp end;
	
	@Column(name="hours")
	private BigDecimal hours = BigDecimal.ONE;

	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	private WorkEffort effort;
	
	@ManyToOne
	@JoinColumn(name="fk_time_sheet")
	private TimeSheet timeSheet;
}
