/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.partys.dm.Organization;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="timesheet")
public class Timesheet implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@ManyToOne
	@JoinColumn(name="fk_worker")
	private Worker worker;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="timesheet",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<TimeEntry> timeEntrys = new HashSet<>();
	
	@OneToMany(mappedBy="timesheet",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<TimesheetRole> roles = new HashSet<>();
	
	public Timesheet(){}
}
