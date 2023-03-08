/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.partys.dm.PartyRelationship;
import com.kratonsolution.belian.partys.dm.PartyRelationshipType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="patient_provider_relationship")
public class PatientProviderRelationship extends PartyRelationship
{
	public PatientProviderRelationship()
	{	
		setType(PartyRelationshipType.PATIENT_PROVIDER_RELATIONSHIP);
	}
}
