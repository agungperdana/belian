/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
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
@Table(name="timesheet_role")
public class TimesheetRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private TimesheetRoleType type = TimesheetRoleType.ENTERER;

	@ManyToOne
	@JoinColumn(name="fk_timesheet")
	private Timesheet timesheet;
	
	@Version
	private Long version;
}
