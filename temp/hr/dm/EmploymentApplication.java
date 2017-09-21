/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.sql.Date;
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

import com.kratonsolution.belian.partys.dm.Person;

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
@Table(name="employment_application")
public class EmploymentApplication implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status_type")
	private EmploymentApplicationStatusType statusType = EmploymentApplicationStatusType.RECEIVED;
	
	@Enumerated(EnumType.STRING)
	@Column(name="source_type")
	private EmploymentApplicationSourceType sourceType = EmploymentApplicationSourceType.INTERNET;
	
	@ManyToOne
	@JoinColumn(name="fk_position")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name="fk_person_referal")
	private Person referal;
	
	@ManyToOne
	@JoinColumn(name="fk_person_applicant")
	private Person applicant;
	
	@Version
	private Long version;
	
	public EmploymentApplication(){}
}
