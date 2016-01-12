/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

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

import com.kratonsolution.belian.general.dm.Organization;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * Doctor to Patient relationship
 */
@Getter
@Setter
@Entity
@Table(name="doctor_appointment")
public class DoctorAppointment implements Serializable
{
	public enum Status{REGISTERED,QUEUE,PROGRESS,ONHOLD,DONE,CANCELED}
		
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization company;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	@Column(name="queue")
	private int queue = 1;
	
	@ManyToOne
	@JoinColumn(name="fk_doctor")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="fk_patient")
	private Patient patient;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status = Status.REGISTERED;
	
	@ManyToOne
	@JoinColumn(name="fk_doctor_appointment_billing")
	private DoctorAppointmentBilling appointmentBilling;
	
	@ManyToOne
	@JoinColumn(name="fk_medicine_billing")
	private MedicineBilling medicineBilling;
	
	@ManyToOne
	@JoinColumn(name="fk_laboratory_billing")
	private LaboratoryBilling laboratoryBilling;

	public DoctorAppointment(){}
	
	public boolean isCancelable()
	{
		if(appointmentBilling != null && appointmentBilling.isPaid())
			return false;
		if(medicineBilling != null && medicineBilling.isPaid())
			return false;
		if(laboratoryBilling != null && laboratoryBilling.isPaid())
			return false;
		
		return true;
	}
}
