/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.effort.dm.WorkEffort;
import com.kratonsolution.belian.products.dm.Product;

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
public class CourseSchedule extends WorkEffort
{
	@Column(name="day")
	private String day;
	
	@ManyToOne
	@JoinColumn(name="fk_room")
	private StudyRoom requirement;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@OneToMany(mappedBy="schedule")
	private Set<CourseAttendance> attendances = new HashSet<>();
	
	public CourseSchedule(){}
}
