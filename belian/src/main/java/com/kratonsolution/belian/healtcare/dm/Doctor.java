/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.general.dm.PersonRole;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="doctor")
public class Doctor extends PersonRole
{
	@ManyToOne
	@JoinColumn(name="fk_doctor_type")
	@NotFound(action=NotFoundAction.IGNORE)
	private DoctorType category;

	@OneToMany(mappedBy="doctor")
	@OrderBy("date DESC")
	private Set<DoctorAppointment> appointments = new HashSet<DoctorAppointment>();
	
	public Doctor(){}
}
