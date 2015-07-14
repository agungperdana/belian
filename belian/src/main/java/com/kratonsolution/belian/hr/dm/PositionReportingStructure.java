/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.util.Date;

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
 * @author Agung Dodi Perdana
 */
@Getter
@Setter
@Entity
@Table(name="position_reporting_structure")
public class PositionReportingStructure implements Serializable
{
	@Id
	private String id;
	
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
	private Position parent;
	
	@Version
	private Long version;
}
