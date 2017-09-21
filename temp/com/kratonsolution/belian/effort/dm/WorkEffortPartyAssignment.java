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

import com.kratonsolution.belian.partys.dm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="work_effort_party_assignment")
public class WorkEffortPartyAssignment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;

	@Column(name="end")
	private Date end;

	@Column(name="comment")
	private String comment;

	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;

	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	private WorkEffort effort;

	@Version
	private Long version;
	
	@OneToMany(mappedBy="assignment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<WorkEffortAssignmentRate> rates = new HashSet<>();

	public WorkEffortPartyAssignment(){}
}
