/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.general.dm.PersonRole;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="doctor")
public class Doctor extends PersonRole
{
	@ManyToOne
	@JoinColumn(name="fk_doctor_type")
	@NotFound(action=NotFoundAction.IGNORE)
	private DoctorType type;
}
