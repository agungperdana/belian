/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.io.Serializable;
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
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;

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
public class StudyRoom implements Serializable
{
	@Id
	private String id  = UUID.randomUUID().toString();

	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
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
	
	@ManyToOne
	@JoinColumn(name="fk_staff")
	private Person staff;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="room")
	private Set<CourseRegistration> registrations = new HashSet<>();
	
	@OneToMany(mappedBy="room",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CourseSchedule> schedules = new HashSet<>();
	
	public StudyRoom(){}
}
