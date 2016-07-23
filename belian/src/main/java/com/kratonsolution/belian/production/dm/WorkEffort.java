/**
 * 
 */
package com.kratonsolution.belian.production.dm;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Person;

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
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class WorkEffort implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="start")
	protected Time start;
	
	@Column(name="end")
	protected Time end;
	
	@Enumerated(EnumType.STRING)
	@Column(name="work_effort_type")
	protected WorkEffortType type = WorkEffortType.Task;
	
	@Enumerated(EnumType.STRING)
	@Column(name="work_effort_purpose")
	protected WorkEffortPurpose purpose = WorkEffortPurpose.Production;

	@ManyToOne
	@JoinColumn(name="fk_person")
	protected Person worker;
	
	@Version
	protected Long version;
	
	@OneToMany(mappedBy="effort")
	protected Set<TimeEntry> timeEntrys = new HashSet<>();
	
	public abstract <T extends Requirement> T getRequirement();
}
