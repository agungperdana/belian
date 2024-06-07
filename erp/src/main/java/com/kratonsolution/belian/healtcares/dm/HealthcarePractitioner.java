
package com.kratonsolution.belian.healtcares.dm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.kratonsolution.belian.core.party.impl.orm.PartyRole;
import com.kratonsolution.belian.core.party.impl.orm.PartyRoleType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="healtcare_practitioner")
public class HealthcarePractitioner extends PartyRole
{
	public HealthcarePractitioner()
	{
		setType(PartyRoleType.HEALTCARE_PRACTITIONER);
	}
}
