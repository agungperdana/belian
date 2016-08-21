/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.order.dm.Requirement;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="study_room")
public class StudyRoom extends Requirement
{	
	@ManyToOne
	@JoinColumn(name="fk_room")
	private Facility room;
	
	@ManyToOne
	@JoinColumn(name="fk_period")
	private StudyPeriod period;
	
	@ManyToOne
	@JoinColumn(name="fk_day")
	private StudyDay day;
	
	@ManyToOne
	@JoinColumn(name="fk_time")
	private StudyTime time;
	
	@ManyToOne
	@JoinColumn(name="fk_course")
	private Product course;
	
	@ManyToOne
	@JoinColumn(name="fk_feature")
	private ProductFeature feature;
	
	@OneToMany(mappedBy="room")
	private Set<CourseRegistration> registrations = new HashSet<>();
	
	@OneToMany(mappedBy="requirement",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("day")
	private Set<CourseSchedule> efforts = new HashSet<>();
	
	public StudyRoom(){}
}
