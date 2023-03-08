/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

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
@Table(name="work_effort_party_assignment")
public class WorkEffortPartyAssignment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="party_id")),
		@AttributeOverride(name="value",column=@Column(name="party_value"))
	})
	private IDValueRef party;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="facility_id")),
		@AttributeOverride(name="value",column=@Column(name="facility_value"))
	})
	private IDValueRef facility;
	
	@ManyToOne
	@JoinColumn(name="fk_work_effort")
	private WorkEffort effort;

	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private WorkEffortRoleType type = WorkEffortRoleType.CREATOR;
	
	@Version
	private Long version;
	
	public WorkEffortPartyAssignment(){}
}
