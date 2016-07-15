/**
 * 
 */
package com.kratonsolution.belian.production.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="time_entry")
public class TimeEntry implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date;

	@Column(name="start")
	private Time start;
	
	@Column(name="end")
	private Time end;
	
	@Column(name="hour")
	private BigDecimal hour = BigDecimal.ZERO;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="fk_timesheet")
	private Timesheet timesheet;
	
	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	private WorkEffort effort;
	
	@Version
	private Long version;
}
