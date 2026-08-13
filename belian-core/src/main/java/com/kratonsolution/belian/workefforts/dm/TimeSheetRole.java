
package com.kratonsolution.belian.workefforts.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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
