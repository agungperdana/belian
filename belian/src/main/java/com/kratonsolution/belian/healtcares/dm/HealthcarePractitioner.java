/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.partys.dm.PartyRole;
import com.kratonsolution.belian.partys.dm.PartyRoleType;

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
