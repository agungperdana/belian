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
@Table(name="practitioner_provider_relationship")
public class PractitionerProviderRelationship extends PartyRelationship
{
	public PractitionerProviderRelationship()
	{
		setType(PartyRelationshipType.PRACTITIONER_PROVIDER_RELATIONSHIP);
	}
}
