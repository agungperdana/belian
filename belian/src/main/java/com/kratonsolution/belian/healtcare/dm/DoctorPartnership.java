/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.PartyRelationship;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="doctor_partnership")
public class DoctorPartnership extends PartyRelationship
{
	public DoctorPartnership()
	{
		setType(Type.DOCTORPARTNERSHIP);
	}
}
