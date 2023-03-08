
package com.kratonsolution.belian.workefforts.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
