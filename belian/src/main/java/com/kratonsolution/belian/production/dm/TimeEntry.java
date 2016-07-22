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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy=InheritanceType.JOINED)
public class TimeEntry implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();

	@Column(name="is_paid")
	protected boolean paid;
	
	@Column(name="date")
	protected Date date;

	@Column(name="start")
	protected Time start;
	
	@Column(name="end")
	protected Time end;
	
	@Column(name="hour")
	protected BigDecimal hour = BigDecimal.ZERO;
	
	@Column(name="comment")
	protected String comment;
	
	@ManyToOne
	@JoinColumn(name="fk_timesheet")
	protected Timesheet timesheet;
	
	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	protected WorkEffort effort;
	
	@Version
	protected Long version;
}
