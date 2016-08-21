/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="work_effort_role")
public class WorkEffortRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Enumerated(EnumType.STRING)
	@JoinColumn(name="type")
	private WorkEffortRoleType type = WorkEffortRoleType.SUPERVISOR;
	
	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	private WorkEffort effort;
	
	@Version
	private Long version;
}
