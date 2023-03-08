/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.api.dm.IDValueRef;

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
public class TimeSheet implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="comment")
	private String comment;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="worker_id")),
		@AttributeOverride(name="value",column=@Column(name="worker_value"))
	})
	private IDValueRef worker;
	
	@OneToMany(mappedBy="timeSheet",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<TimeEntry> entrys = new HashSet<>();
	
	@OneToMany(mappedBy="timeSheet",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<TimeSheetRole> roles = new HashSet<>();
}
