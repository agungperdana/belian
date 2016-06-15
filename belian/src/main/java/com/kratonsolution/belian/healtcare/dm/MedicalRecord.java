/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="medical_record")
public class MedicalRecord implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;

	@Column(name="anamnesis")
	private String anamnesis;

	@Column(name="checking_result")
	private String checkingResult;
	
	@Column(name="diagnosis")
	private String diagnosis;

	@ManyToOne
	@JoinColumn(name="fk_patient")
	@NotFound(action=NotFoundAction.IGNORE)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="fk_doctor")
	@NotFound(action=NotFoundAction.IGNORE)
	private DoctorRelationship doctor;
	
	@OneToOne
	@JoinColumn(name="fk_doctor_appointment")
	@NotFound(action=NotFoundAction.IGNORE)
	private DoctorAppointment appointment;
	
	@ManyToOne
	@JoinColumn(name="fk_medication")
	@NotFound(action=NotFoundAction.IGNORE)
	private Medication medication;
	
	@ManyToOne
	@JoinColumn(name="fk_treatment")
	@NotFound(action=NotFoundAction.IGNORE)
	private Treatment treatment;
	
	@ManyToOne
	@JoinColumn(name="fk_laboratory")
	@NotFound(action=NotFoundAction.IGNORE)
	private Laboratory laboratory;
	
	@Version
	private Long version;
	
	public MedicalRecord(){}
}
