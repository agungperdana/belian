/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="course_attendance")
public class CourseAttendance implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_Schedule")
	private CourseSchedule schedule;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="attendance",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CourseAttendanceItem> items = new HashSet<>();
	
	public CourseAttendance(){}
}
