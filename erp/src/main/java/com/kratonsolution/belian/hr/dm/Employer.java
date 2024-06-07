
package com.kratonsolution.belian.hr.dm;

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
@Table(name="employer")
public class Employer extends PartyRole
{
	public Employer()
	{
		setType(PartyRoleType.EMPLOYER);
	}
}
