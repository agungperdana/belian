/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Person;

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
	public enum StatusType{RECEIVED,REVIEWED,REJECTED,ACCEPTED}
	
	public enum SourceType{NEWSPAPER,INTERNET,REFERENCE}
	
	@Id
	private String id;
	
	@Column(name="date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status_type")
	private StatusType statusType = StatusType.RECEIVED;
	
	@Enumerated(EnumType.STRING)
	@Column(name="source_type")
	private SourceType sourceType = SourceType.INTERNET;
	
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
}
