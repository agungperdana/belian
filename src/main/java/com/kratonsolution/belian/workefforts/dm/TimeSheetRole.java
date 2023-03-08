/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

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
public class TimeSheetRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="timesheet_role_type")
	@Enumerated(EnumType.STRING)
	private TimeSheetRoleType type = TimeSheetRoleType.ENTERER;

	@ManyToOne
	@JoinColumn(name="fk_timesheet")
	private TimeSheet timeSheet;
	
	@Version
	private Long version;

	public TimeSheetRole(){}
}
