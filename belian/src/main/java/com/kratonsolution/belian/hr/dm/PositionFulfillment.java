/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="position_fulfillment")
public class PositionFulfillment
{
	@Id
	private String id;

	@Column(name="start_date")
	private Date start;
	
	@Column(name="end_date")
	private Date end;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="fk_person_employee")
	private Person employee;
	
	@ManyToOne
	@JoinColumn(name="fk_position")
	private Position position;
	
	@Version
	private Long version;
}
