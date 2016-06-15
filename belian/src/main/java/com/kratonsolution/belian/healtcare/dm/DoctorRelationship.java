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

import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.PartyRelationship;
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
@Table(name="doctor_relationship")
public class DoctorRelationship extends PartyRelationship
{
	@ManyToOne
	@JoinColumn(name="fk_doctor_type")
	@NotFound(action=NotFoundAction.IGNORE)
	private DoctorType category;
	
	@ManyToOne
	@JoinColumn(name="fk_doctor")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="fk_internal_organization")
	private InternalOrganization organization;
	
	@OneToMany(mappedBy="doctor")
	@OrderBy("date DESC")
	private Set<DoctorAppointment> appointments = new HashSet<DoctorAppointment>();
	
	public DoctorRelationship(){}
	
	public Person getPerson()
	{
		if(doctor == null)
			return null;
		
		return doctor.getPerson();
	}
}
