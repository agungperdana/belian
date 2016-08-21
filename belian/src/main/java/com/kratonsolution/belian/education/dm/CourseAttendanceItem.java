/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.effort.dm.TimeEntry;
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
@Table(name="course_attendance_item")
public class CourseAttendanceItem extends TimeEntry
{
	@Column(name="status")
	private AttendanceStatus status = AttendanceStatus.IN;
	
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="fk_attendance")
	private CourseAttendance attendance;
	
	public CourseAttendanceItem(){}
}
