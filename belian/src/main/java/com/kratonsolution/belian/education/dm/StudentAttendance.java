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
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.inventory.dm.Facility;
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
@Table(name="student_attendance")
public class StudentAttendance implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date;

	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="fk_facility")
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
	@JoinColumn(name="fk_staff")
	private Person staff;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="attendance",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<StudentAttendanceItem> items = new HashSet<>();

	public StudentAttendance(){}
}
