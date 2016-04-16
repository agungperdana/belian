/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="position_reporting_structure")
public class PositionReportingStructure implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start_date")
	private Date start;
	
	@Column(name="end_date")
	private Date end;
	
	@Column(name="is_primary")
	private boolean primary;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="fk_position_reporting_to")
	private Position reportTo;
	
	@ManyToOne
	@JoinColumn(name="fk_position_parent")
	private Position position;
	
	@Version
	private Long version;
}
