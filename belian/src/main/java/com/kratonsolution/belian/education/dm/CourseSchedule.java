/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.inventory.dm.Product;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="course_schedule")
public class CourseSchedule implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="day")
	private String day;

	@Column(name="start")
	private Time start;
	
	@Column(name="end")
	private Time end;
	
	@ManyToOne
	@JoinColumn(name="fk_room")
	private StudyRoom room;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_teacher")
	private Person teacher;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="schedule")
	private Set<CourseAttendance> attendances = new HashSet<>();
	
	public CourseSchedule(){}
}
