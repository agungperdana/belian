
package com.kratonsolution.belian.healtcares.dm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.kratonsolution.belian.core.party.impl.orm.PartyRelationship;
import com.kratonsolution.belian.core.party.impl.orm.PartyRelationshipType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="patient_practitioner_relationship")
public class PatientPractitionerRelationship extends PartyRelationship
{
	public PatientPractitionerRelationship()
	{
		setType(PartyRelationshipType.PATIENT_PRACTITIONER_RELATIONSHIP);
	}
}
