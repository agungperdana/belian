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
import com.kratonsolution.belian.production.dm.TimeEntry;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="course_attendance_item")
public class CourseAttendanceItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="status")
	private AttendanceStatus status = AttendanceStatus.IN;
	
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="fk_attendance")
	private CourseAttendance attendance;

	@ManyToOne
	@JoinColumn(name="fk_time_entry")
	private TimeEntry timeEntry;
	
	@Version
	private Long version;
	
	public CourseAttendanceItem(){}
}
