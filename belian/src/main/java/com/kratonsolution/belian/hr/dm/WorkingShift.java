/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.sql.Time;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
//@Entity
//@Table(name="working_shift")
public class WorkingShift implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name",unique=true)
	private String name;
	
	@Column(name="start")
	private Time start;
	
	@Column(name="end")
	private Time end;
	
	@Column(name="is_active")
	private boolean active;
	
	@Version
	private Long version;
	
	public WorkingShift(){}
}
