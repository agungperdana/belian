/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.io.Serializable;
import java.util.UUID;

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
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="student_attendance_item")
public class StudentAttendanceItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="status")
	private AttendanceStatus status = AttendanceStatus.LEAVE;
	
	@ManyToOne
	@JoinColumn(name="fk_student")
	private Person student;
	
	@ManyToOne
	@JoinColumn(name="fk_attendance")
	private StudentAttendance attendance;

	@Version
	private Long version;
	
	public StudentAttendanceItem(){}
}